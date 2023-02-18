package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Sring boot";
	}
}
