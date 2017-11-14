package ar.edu.ucc.trabajoFinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView home = new ModelAndView("index");
		return home;
	}
	
	@RequestMapping(value = "variables", method = RequestMethod.GET)
	public ModelAndView variables() {
		ModelAndView variables = new ModelAndView("variables");
		return variables;
	}

}
