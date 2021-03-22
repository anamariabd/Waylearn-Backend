package com.app.waylearn.Controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class IndexController {

	@RequestMapping(value = "/")
	public String index() {
		return "index"; 
	}

}