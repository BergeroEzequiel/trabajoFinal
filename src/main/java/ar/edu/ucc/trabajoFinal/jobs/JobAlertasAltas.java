package ar.edu.ucc.trabajoFinal.jobs;

import ar.edu.ucc.trabajoFinal.dao.AlertaDao;
import ar.edu.ucc.trabajoFinal.dao.CriticidadDao;
import ar.edu.ucc.trabajoFinal.dao.NodoDao;
import ar.edu.ucc.trabajoFinal.model.Alerta;
import ar.edu.ucc.trabajoFinal.model.AlertaAuxiliar;
import ar.edu.ucc.trabajoFinal.model.Criticidad;
import ar.edu.ucc.trabajoFinal.utils.Hora;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class JobAlertasAltas extends QuartzJobBean{
    
    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private AlertaDao alertaDao;

    @Autowired
    private CriticidadDao criticidadDao;
    
    @Autowired
    private NodoDao nodoDao;

    private Time horaActual;
    private Time horaMenos10Minutos;

    @Override
    protected void executeInternal(JobExecutionContext jec) throws JobExecutionException {
        List<AlertaAuxiliar> alertasAGenerar = null;
        horaActual = new Time(System.currentTimeMillis());
        horaMenos10Minutos = Hora.restarMinutos(horaActual, 10);
        Criticidad criticidadAlta = criticidadDao.getCriticidadByPrioridad("Alta");
        alertasAGenerar = alertaDao.getAlertasAMostrar(horaMenos10Minutos, horaActual,
                criticidadAlta);
        if(alertasAGenerar != null && !alertasAGenerar.isEmpty())
            for (AlertaAuxiliar alertaAuxiliar : alertasAGenerar) {
                if (alertaAuxiliar.getCantidadRepeticiones() >= criticidadAlta.getCantidadRepeticiones()) {
                    Alerta alerta = new Alerta();
                    alerta.setCriticidad(criticidadAlta);
                    alerta.setDescripcion(" Se generaron " + alertaAuxiliar.getCantidadRepeticiones());
                    try {
                        alerta.setFecha(dateFormatter.parse(dateFormatter.format(new Date())));
                        //Hacemos ese doble casteo para que en la BD el DateTime se inserte de la forma yyyy-mm-dd 00:00:00
                    } catch (ParseException ex) {
                        Logger.getLogger(JobAlertasCriticas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    alerta.setHora(horaActual);
                    alerta.setNodo(nodoDao.getNodoById(alertaAuxiliar.getNodo().getId()));
                    alerta.setVariableAfectada(alertaAuxiliar.getVariableAfectada());
                    alerta.setVisualizar(true);
                    alertaDao.saveOrUpdate(alerta);
                }

            }
    }

    public void setAlertaDao(AlertaDao alertaDao) {
        this.alertaDao = alertaDao;
    }

    public void setCriticidadDao(CriticidadDao criticidadDao) {
        this.criticidadDao = criticidadDao;
    }

    public void setNodoDao(NodoDao nodoDao) {
        this.nodoDao = nodoDao;
    }
    
}
