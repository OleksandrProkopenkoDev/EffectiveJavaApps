package com.spro.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index() {
		System.out.println("home method");
		return "index";
	}
	
	@GetMapping("/home")
	public String home() {
		System.out.println("home method");
		return "home";
	}
}
