package com.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/controller")
public class Controller {
	
	@GetMapping(value = "/get")
	public ResponseEntity<String> get() {
		return ResponseEntity.ok("pass");
	}

}
