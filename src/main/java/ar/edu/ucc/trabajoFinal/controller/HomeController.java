package ar.edu.ucc.trabajoFinal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
        
        @RequestMapping(value = "conf-usuarios", method = RequestMethod.GET)
	public ModelAndView confUsuarios() {
		ModelAndView confUsuarios = new ModelAndView("conf-usuarios");
		return confUsuarios;
	}

	// ALERTAS
	@RequestMapping(value = "alertas-detalle", method = RequestMethod.GET)
	public ModelAndView alertas() {
		ModelAndView alertasDetalle = new ModelAndView("alertas-detalle");
		return alertasDetalle;
	}

	// NODOS
	@RequestMapping(value = "nodos-detalle", method = RequestMethod.GET)
	public ModelAndView nodos() {
		ModelAndView nodosDetalle = new ModelAndView("nodos-detalle");
		return nodosDetalle;
	}

	// HISTORICOS
	@RequestMapping(value = "historicos", method = RequestMethod.GET)
	public ModelAndView historicos() {
		ModelAndView historicos = new ModelAndView("historicos");
		return historicos;
	}
        
//        @RequestMapping(value = "/login", method = RequestMethod.GET)
//        public ModelAndView login() {
//            ModelAndView login = new ModelAndView("login");
//            return login;
//        }
        
        @RequestMapping(value="/logout", method = RequestMethod.GET)
        public ModelAndView logoutPage (HttpServletRequest request, HttpServletResponse response) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth != null){    
                new SecurityContextLogoutHandler().logout(request, response, auth);
            }
            ModelAndView login = new ModelAndView("login");
            return login;
        }
        
        // PAGINA DE MANTENIMIENTO
	@RequestMapping(value = "en-mantenimiento", method = RequestMethod.GET)
	public ModelAndView enMantenimiento() {
		ModelAndView enMantenimiento = new ModelAndView("en-mantenimiento");
		return enMantenimiento;
	}
        
        @RequestMapping(value = "/cambiar-password", method = RequestMethod.GET)
        public ModelAndView cambiarPassword() {
            ModelAndView cambiarPassword = new ModelAndView("cambiar-password");
            return cambiarPassword;
        }

}
