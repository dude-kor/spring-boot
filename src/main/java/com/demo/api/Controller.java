package com.demo.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/controller")
public class Controller {
	private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
	
	@GetMapping(value = "/get")
	public ResponseEntity<String> get() {
//		log.warn("[GET] CONTROLLER ");
		return ResponseEntity.ok("pass");
	}

}
