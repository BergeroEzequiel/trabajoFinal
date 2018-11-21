package ar.edu.ucc.trabajoFinal.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import ar.edu.ucc.trabajoFinal.model.UmbralEspecifico;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.ucc.trabajoFinal.dao.DaoGenerico;
import ar.edu.ucc.trabajoFinal.dao.IUmbralDao;
import ar.edu.ucc.trabajoFinal.dao.UmbralDao;
import ar.edu.ucc.trabajoFinal.model.Umbral;

@Service
@Transactional
public class UmbralService {
	
	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	DaoGenerico<Umbral, Long> umbralDao;

	IUmbralDao umbralDaoParticular;

	SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	DateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
	
	@PostConstruct
	public void init() {
		umbralDaoParticular = (UmbralDao) umbralDao;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public List<Umbral> getUmbralesGenericos() {
		log.info("Buscando todos los umbrales genericos");
		List<Umbral> umbrales = umbralDaoParticular.getUmbralesGenericos();
		return umbrales;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public Umbral getUmbralGenericoByVariable(String nombreVariable){		
		Umbral umbral = umbralDaoParticular.getUmbralGenericoByVariable(nombreVariable);
		return umbral;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public Umbral grabarUmbral(UmbralEspecifico umbralEsp) throws ParseException {
		Boolean isEspecifico = true;
		Umbral umbral = new Umbral();
		if (umbralEsp.getNodo() == null) {
			isEspecifico = false;
			umbral.setId(umbralEsp.getId());
			umbral.setActivo(umbralEsp.isActivo());
			umbral.setCriticidad(umbralEsp.getCriticidad());
			umbral.setNombreVariable(umbralEsp.getNombreVariable());
			umbral.setUnidadMedida(umbralEsp.getUnidadMedida());
			umbral.setValorMax(umbralEsp.getValorMax());
			umbral.setValorMin(umbralEsp.getValorMin());
			umbral.setUltimaModificacion(umbralEsp.getUltimaModificacion());
		}
		umbralDaoParticular.saveOrUpdate((isEspecifico) ? umbralEsp : umbral);
		return umbral;
	}		
		
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public List<Umbral> getUmbralesEspByNodo(Long idNodo) {
		return umbralDaoParticular.getUmbralesEspByNodo(idNodo);
	}
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public List<Umbral> getUmbralesNodo(Long idNodo) {
		List<Umbral> umbrales = umbralDaoParticular.getUmbralesGenericos();;
		List<Umbral> umbralesEsp = umbralDaoParticular.getUmbralesEspByNodo(idNodo);
		
		List<Umbral> umbralesMerge = new ArrayList<Umbral>();

		ArrayList<String> variablesEspecificas = new ArrayList<String>();
		
		for (Umbral umbralEsp : umbralesEsp) {			
			umbralesMerge.add(umbralEsp);
			variablesEspecificas.add(umbralEsp.getNombreVariable());
		}
		for (Umbral umbral : umbrales) {
			if (!variablesEspecificas.contains(umbral.getNombreVariable())) {
				umbralesMerge.add(umbral);
			}
		}
		
		return umbralesMerge;
	}

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void deleteUmbralEspecifico(Long id) {
	    Umbral umbral = this.umbralDaoParticular.load(id);
	    if (umbral.getTipoUmbral().equalsIgnoreCase("especifico")) {
	    	this.umbralDaoParticular.remove(umbral);
		}
    }
}
