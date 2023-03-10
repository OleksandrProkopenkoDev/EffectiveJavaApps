package net.javaguides;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {

	@GetMapping("/hello")// when user access to this page, this method will invoked
	public String hello(Model model) {
		model.addAttribute("message", "Hello world");
		return "helloworld"; //this is the name of html page in 'template' folder
	}
	
	@GetMapping("/style")// when user access to this page, this method will invoked
	public String style() {
		
		return "add-css-js-demo"; //this is the name of html page in 'template' folder
	}
	
	@GetMapping("/bootstrap")// when user access to this page, this method will invoked
	public String bootstrap() {
		
		return "add-bootstrap"; //this is the name of html page in 'template' folder
	}
	
}
