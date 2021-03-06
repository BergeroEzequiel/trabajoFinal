package ar.edu.ucc.trabajoFinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	// HOME
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView home = new ModelAndView("home-solar");
		return home;
	}
	
	// CONFIGURACION
	@RequestMapping(value = "conf-umbrales", method = RequestMethod.GET)
	public ModelAndView confUmbrales() {
		ModelAndView confUmbrales = new ModelAndView("conf-umbrales");
		return confUmbrales;
	}
	
	@RequestMapping(value = "conf-alertas", method = RequestMethod.GET)
	public ModelAndView confAlertas() {
		ModelAndView confAlertas = new ModelAndView("conf-alertas");
		return confAlertas;
	}
	
	@RequestMapping(value = "conf-nodos", method = RequestMethod.GET)
	public ModelAndView confNodos() {
		ModelAndView confNodos = new ModelAndView("conf-nodos");
		return confNodos;
	}

	// ALERTAS
	@RequestMapping(value = "alertas-detalle", method = RequestMethod.GET)
	public ModelAndView alertas() {
		ModelAndView alertasDetalle = new ModelAndView("alertas-detalle");
		return alertasDetalle;
	}

}
