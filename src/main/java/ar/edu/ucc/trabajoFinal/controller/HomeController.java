package ar.edu.ucc.trabajoFinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {


	@RequestMapping(value = "/views/index", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView home = new ModelAndView("index");
		home.addObject("msg", "Mensaje en el Controller!!!!!!!!!!!!!11!");

		return home;
	}

}
