package ar.edu.ucc.trabajoFinal.service;

import java.text.ParseException;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.ucc.trabajoFinal.dao.DaoGenerico;
import ar.edu.ucc.trabajoFinal.dao.ITramaProcesadaDao;
import ar.edu.ucc.trabajoFinal.dao.TramaProcesadaDao;
import ar.edu.ucc.trabajoFinal.dto.TramaProcesadaDto;
import ar.edu.ucc.trabajoFinal.model.TramaProcesada;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TramaProcesadaService {

    private Logger log = Logger.getLogger(this.getClass());

    @Autowired
    DaoGenerico<TramaProcesada, Long> tramaProcesadaDao;

    ITramaProcesadaDao tramaProcesadaDaoParticular;

    @PostConstruct
    public void init() {
        tramaProcesadaDaoParticular = (TramaProcesadaDao) tramaProcesadaDao;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public TramaProcesadaDto grabarTramaProcesada(TramaProcesadaDto tramaProcesadaDto) throws ParseException {

        TramaProcesada tramaProcesada = new TramaProcesada();

        tramaProcesada.setCorrienteContinuaAvg(tramaProcesadaDto.getCorrienteContinuaAvg());
        tramaProcesada.setCorrienteContinuaMax(tramaProcesadaDto.getCorrienteContinuaMax());
        tramaProcesada.setCorrienteContinuaMin(tramaProcesadaDto.getCorrienteContinuaMin());
        tramaProcesada.setCorrienteInternaAvg(tramaProcesadaDto.getCorrienteInternaAvg());
        tramaProcesada.setCorrienteInternaMax(tramaProcesadaDto.getCorrienteInternaMax());
        tramaProcesada.setCorrienteInternaMin(tramaProcesadaDto.getCorrienteInternaMin());
        tramaProcesada.setCorrienteRedAvg(tramaProcesadaDto.getCorrienteRedAvg());
        tramaProcesada.setCorrienteRedMax(tramaProcesadaDto.getCorrienteRedMax());
        tramaProcesada.setCorrienteRedMin(tramaProcesadaDto.getCorrienteInternaMin());
        tramaProcesada.setDesfasajeAvg(tramaProcesadaDto.getDesfasajeAvg());
        tramaProcesada.setDesfasajeMax(tramaProcesadaDto.getDesfasajeMax());
        tramaProcesada.setDesfasajeMin(tramaProcesadaDto.getDesfasajeMin());
        tramaProcesada.setFrecuenciaCorrienteAvg(tramaProcesadaDto.getFrecuenciaCorrienteAvg());
        tramaProcesada.setFrecuenciaCorrienteMax(tramaProcesadaDto.getFrecuenciaCorrienteMax());
        tramaProcesada.setFrecuenciaCorrienteMin(tramaProcesadaDto.getFrecuenciaCorrienteMin());
        tramaProcesada.setFrecuenciaTensionAvg(tramaProcesadaDto.getFrecuenciaTensionAvg());
        tramaProcesada.setFrecuenciaTensionMax(tramaProcesadaDto.getFrecuenciaTensionMax());
        tramaProcesada.setFrecuenciaTensionMin(tramaProcesadaDto.getFrecuenciaTensionMin());
        tramaProcesada.setHumedadAvg(tramaProcesadaDto.getHumedadAvg());
        tramaProcesada.setHumedadMax(tramaProcesadaDto.getHumedadMax());
        tramaProcesada.setHumedadMin(tramaProcesadaDto.getHumedadMin());
//		tramaProcesada.setIpNodo(tramaProcesadaDto.getIpNodo());
        tramaProcesada.setNodo(tramaProcesadaDto.getNodo());
        tramaProcesada.setPotenciaContinuaAvg(tramaProcesadaDto.getPotenciaContinuaAvg());
        tramaProcesada.setPotenciaContinuaMax(tramaProcesadaDto.getPotenciaContinuaMax());
        tramaProcesada.setPotenciaContinuaMin(tramaProcesadaDto.getPotenciaContinuaMin());
        tramaProcesada.setPotenciaRedAvg(tramaProcesadaDto.getPotenciaRedAvg());
        tramaProcesada.setPotenciaRedMax(tramaProcesadaDto.getPotenciaRedMax());
        tramaProcesada.setPotenciaRedMin(tramaProcesadaDto.getPotenciaRedMin());
        tramaProcesada.setPotenciaInternaAvg(tramaProcesadaDto.getPotenciaInternaAvg());
        tramaProcesada.setPotenciaInternaMax(tramaProcesadaDto.getPotenciaInternaMax());
        tramaProcesada.setPotenciaInternaMin(tramaProcesadaDto.getPotenciaInternaMin());
        tramaProcesada.setPvmAvg(tramaProcesadaDto.getPvmAvg());
        tramaProcesada.setPvmMax(tramaProcesadaDto.getPvmMax());
        tramaProcesada.setPvmMin(tramaProcesadaDto.getPvmMin());
        tramaProcesada.setTemperatura1Avg(tramaProcesadaDto.getTemperatura1Avg());
        tramaProcesada.setTemperatura1Max(tramaProcesadaDto.getTemperatura1Max());
        tramaProcesada.setTemperatura1Min(tramaProcesadaDto.getTemperatura1Min());
        tramaProcesada.setTemperatura2Avg(tramaProcesadaDto.getTemperatura2Avg());
        tramaProcesada.setTemperatura2Max(tramaProcesadaDto.getTemperatura2Max());
        tramaProcesada.setTemperatura2Min(tramaProcesadaDto.getTemperatura2Min());
        tramaProcesada.setTemperatura3Avg(tramaProcesadaDto.getTemperatura3Avg());
        tramaProcesada.setTemperatura3Max(tramaProcesadaDto.getTemperatura3Max());
        tramaProcesada.setTemperatura3Min(tramaProcesadaDto.getTemperatura3Min());
        tramaProcesada.setTemperatura4Avg(tramaProcesadaDto.getTemperatura4Avg());
        tramaProcesada.setTemperatura4Max(tramaProcesadaDto.getTemperatura4Max());
        tramaProcesada.setTemperatura4Min(tramaProcesadaDto.getTemperatura4Min());
        tramaProcesada.setTemperatura5Avg(tramaProcesadaDto.getTemperatura5Avg());
        tramaProcesada.setTemperatura5Max(tramaProcesadaDto.getTemperatura5Max());
        tramaProcesada.setTemperatura5Min(tramaProcesadaDto.getTemperatura5Min());
        tramaProcesada.setTensionContinuaAvg(tramaProcesadaDto.getTensionContinuaAvg());
        tramaProcesada.setTensionContinuaMax(tramaProcesadaDto.getTensionContinuaMax());
        tramaProcesada.setTensionContinuaMin(tramaProcesadaDto.getTensionContinuaMin());
        tramaProcesada.setTensionInternaAvg(tramaProcesadaDto.getTensionInternaAvg());
        tramaProcesada.setTensionContinuaMax(tramaProcesadaDto.getTensionInternaMax());
        tramaProcesada.setTensionInternaMin(tramaProcesadaDto.getTensionInternaMin());
        tramaProcesada.setTensionRedAvg(tramaProcesadaDto.getTensionRedAvg());
        tramaProcesada.setTensionRedMax(tramaProcesadaDto.getTensionRedMax());
        tramaProcesada.setTensionRedMin(tramaProcesadaDto.getTensionRedMin());
        tramaProcesada.setTensionTierraAvg(tramaProcesadaDto.getTensionTierraAvg());
        tramaProcesada.setTensionTierraMax(tramaProcesadaDto.getTensionTierraMax());
        tramaProcesada.setTensionTierraMin(tramaProcesadaDto.getTensionTierraMin());

        tramaProcesadaDao.saveOrUpdate(tramaProcesada);

        tramaProcesadaDto.setId(tramaProcesada.getId());

        return tramaProcesadaDto;

    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public List<TramaProcesada> getTramasProcesadasByFecha(Date fechaDesde, Date fechaHasta, Long idTipoProcesamiento) throws ParseException {
        return tramaProcesadaDaoParticular.getTramasProcesadasByFecha(fechaDesde, fechaHasta, idTipoProcesamiento);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public List<TramaProcesada> getTramasProcesadasByHora(Time horaDesde, Time horaHasta, Long idTipoProcesamiento) throws ParseException {
        return tramaProcesadaDaoParticular.getTramasProcesadasByHora(horaDesde, horaHasta, idTipoProcesamiento);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public List getTramasProcesadasByTiempoAndTipoProcesamiento(
            String[] nombreVariable, Date fechaDesde, Date fechaHasta, String horaDesde,
            String horaHasta, Long idTipoProcesamiento, Long idNodo) throws ParseException {
        
        Time horaDesdeCasteada;
        Time horaHastaCasteada;
        
        if(horaDesde != null && !horaDesde.isEmpty() && horaHasta != null && !horaHasta.isEmpty()){
            horaDesdeCasteada = Time.valueOf(horaDesde);
            horaHastaCasteada = Time.valueOf(horaHasta);
        } else{
            horaDesdeCasteada = Time.valueOf("00:00:00");
            horaHastaCasteada = Time.valueOf("23:59:59");
        }
         
        
        List trama = tramaProcesadaDaoParticular.getTramasProcesadasByTiempoAndTipoProcesamiento(
                nombreVariable, fechaDesde, fechaHasta, horaDesdeCasteada, horaHastaCasteada, idTipoProcesamiento, idNodo);
        
        return trama;
    }

}
