package ar.edu.ucc.trabajoFinal.jobs;

import ar.edu.ucc.trabajoFinal.dao.HistorialNodoDao;
import ar.edu.ucc.trabajoFinal.dao.NodoDao;
import ar.edu.ucc.trabajoFinal.dao.TramaDao;
import ar.edu.ucc.trabajoFinal.model.HistorialNodo;
import ar.edu.ucc.trabajoFinal.model.Nodo;
import ar.edu.ucc.trabajoFinal.model.TramaAuxiliar;
import ar.edu.ucc.trabajoFinal.service.NodoService;
import ar.edu.ucc.trabajoFinal.utils.Hora;
import ar.edu.ucc.trabajoFinal.utils.NodoMapper;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 *
 * @author ezequiel
 */
public class JobNodosFuncionando extends QuartzJobBean {

    @Autowired
    private TramaDao tramaDao;

    @Autowired
    private NodoDao nodoDao;
    
    @Autowired
    private NodoService nodoService;

    @Autowired
    private HistorialNodoDao historialNodoDao;

    private Date horaMenos10Minutos;
    private Time horaActual;
    
    DateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");

    @Override
    protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {

        List<TramaAuxiliar> ultimasTramas = tramaDao.getUltimaTramaPorNodo();
        List<Nodo> nodos = NodoMapper.getInstance().getNodosActivos();
        horaActual = new Time(System.currentTimeMillis());
            horaMenos10Minutos = Hora.restarMinutos(horaActual, 10);

        HistorialNodo historialNodo = null;
        Calendar cal = Calendar.getInstance();
        Nodo nodoADesactivar = null;
        Nodo nodoParaActivar = null;
        Date horaMenod10MinutosDate = new Date(horaMenos10Minutos.getTime()); 
        try {
            horaMenod10MinutosDate = timeFormatter.parse(timeFormatter.format(horaMenos10Minutos));
        } catch (ParseException ex) {
            Logger.getLogger(JobNodosFuncionando.class.getName()).log(Level.SEVERE, null, ex);
        }
        

         for (TramaAuxiliar trama : ultimasTramas) {
            cal.set(Calendar.HOUR_OF_DAY, trama.getHora().getHours());
            cal.set(Calendar.MINUTE, trama.getHora().getMinutes());
            cal.set(Calendar.SECOND, trama.getHora().getSeconds());

            if (trama.getHora().before(horaMenod10MinutosDate)
                    && this.contieneNodo(nodos, trama.getNodo()) != null) {

                nodoADesactivar = this.contieneNodo(nodos, trama.getNodo());
                nodoADesactivar = nodoService.getNodo(nodoADesactivar.getId());
                if (nodoADesactivar.isFuncionando()) {
                    nodoADesactivar.setFuncionando(false);
                    try {
                        nodoService.grabarNodo(nodoADesactivar);
                    } catch (ParseException ex) {
                        Logger.getLogger(JobNodosFuncionando.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    //MARCAR EN EL HISTOTRIAL
                    historialNodo = new HistorialNodo(nodoADesactivar, new Date(),
                            cal, "El nodo dejó de funcionar.");
                    historialNodoDao.add(historialNodo);
                }

            } else {
                if (this.contieneNodo(nodos, trama.getNodo()) != null) {
                    nodoParaActivar = this.contieneNodo(nodos, trama.getNodo());
                    Nodo n = nodoService.getNodo(nodoParaActivar.getId());
                    if (!n.isFuncionando()) {
                        n.setFuncionando(true);
                        
                        try {
                            nodoService.grabarNodo(n);
                        } catch (ParseException ex) {
                            Logger.getLogger(JobNodosFuncionando.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        //MARCAR EN EL HISTORIAL
                        historialNodo = new HistorialNodo(nodoParaActivar, new Date(),
                                cal, "El nodo ha vuelto a funcionar.");
                        historialNodoDao.add(historialNodo);
                    }
                }
            }

        }

    }

    public Nodo contieneNodo(List<Nodo> nodos, Nodo nodoABuscar) {
        for (Nodo nodo : nodos) {
            if (nodo.getId() == nodoABuscar.getId()) {
                return nodo;
            }
        }
        return null;
    }

    public void setTramaDao(TramaDao tramaDao) {
        this.tramaDao = tramaDao;
    }

    public void setNodoDao(NodoDao nodoDao) {
        this.nodoDao = nodoDao;
    }

    public void setHistorialNodoDao(HistorialNodoDao historialNodoDao) {
        this.historialNodoDao = historialNodoDao;
    }

    public void setNodoService(NodoService nodoService) {
        this.nodoService = nodoService;
    }
    
    

}
