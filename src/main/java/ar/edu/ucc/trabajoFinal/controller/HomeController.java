package ar.edu.ucc.trabajoFinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView home = new ModelAndView("home");
		return home;
	}
	
	@RequestMapping(value = "conf-umbrales", method = RequestMethod.GET)
	public ModelAndView variables() {
		ModelAndView umbrales = new ModelAndView("conf-umbrales");
		return umbrales;
	}

}
