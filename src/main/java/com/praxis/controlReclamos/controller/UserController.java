package com.praxis.controlReclamos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

	
	@GetMapping("/")
	public String inicio() {
		return "home";
	}

	@GetMapping("/loginRegister")
	public ModelAndView getMethodName(@RequestParam String accionTxt) {
		ModelAndView mav = new ModelAndView("login");
		
		if (accionTxt.equals("register")) {
			mav.setViewName("register");
			
		}
		return mav;	
	}
	

	@GetMapping("/register")
	public String vistaRegistrar() {
		return "register";
	}
	

	@PostMapping("/userRegister")
	public ModelAndView postMethodName(@RequestParam String nameTxt) {
		ModelAndView mav = new ModelAndView("wellcomeUser");
		
		mav.addObject("correoUsuario", nameTxt);
		
		return mav;
	}
	
	

	@GetMapping("/perfil")
	public String vistaPerfil() {
		return "perfilUsuario";
	}
	
	
	@GetMapping("/adminView")
	public String vistaPanelAdmin() {
		return "panelAdmin";
	}
	
	
}
