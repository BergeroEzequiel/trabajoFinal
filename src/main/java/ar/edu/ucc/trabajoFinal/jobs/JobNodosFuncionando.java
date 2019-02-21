package ar.edu.ucc.trabajoFinal.jobs;

import ar.edu.ucc.trabajoFinal.dao.NodoDao;
import ar.edu.ucc.trabajoFinal.dao.TramaDao;
import ar.edu.ucc.trabajoFinal.model.Nodo;
import ar.edu.ucc.trabajoFinal.model.TramaAuxiliar;
import ar.edu.ucc.trabajoFinal.utils.Hora;
import java.sql.Time;
import java.util.List;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 *
 * @author ezequiel
 */
public class JobNodosFuncionando extends QuartzJobBean{
    
    @Autowired
    private TramaDao tramaDao;

    @Autowired
    private NodoDao nodoDao;
    
    private Time horaMenos10Minutos;
    private Time horaActual;

    @Override
    protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
        
        List<TramaAuxiliar> ultimasTramas = tramaDao.getUltimaTramaPorNodo();
        List<Nodo> nodos = nodoDao.getNodosActivosFuncionando();
        horaActual = new Time(System.currentTimeMillis());
        horaMenos10Minutos = Hora.restarMinutos(horaActual, 10);
        
        for (TramaAuxiliar trama : ultimasTramas) {
            if(trama.getHora().before(horaMenos10Minutos) && nodos.contains(trama.getNodo())){
                //PONER FUNCIONAMIENTO EN FALSE
                //MARCAR ENTRADA EN EL HISTORIAL DE NODOS CAIDOS.
            } 
            
        }
        
        
    }

    public void setTramaDao(TramaDao tramaDao) {
        this.tramaDao = tramaDao;
    }

    public void setNodoDao(NodoDao nodoDao) {
        this.nodoDao = nodoDao;
    }
    
}
