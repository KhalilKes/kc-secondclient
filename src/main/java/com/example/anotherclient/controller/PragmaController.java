package com.example.anotherclient.controller;


import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class PragmaController {

	@GetMapping(value = "/")
	public ResponseEntity<String> homeEndpoint() {
		return new ResponseEntity<String>("hello from Hogworts", HttpStatus.OK);
	}

	@RolesAllowed("ROLE_HOUSE_G")
	@GetMapping(value = "gryffindor")
	public ResponseEntity<String> adminEndpoint() {
		return new ResponseEntity<String>("hello i am Harry", HttpStatus.OK);
	}

	@RolesAllowed("ROLE_HOUSE_S")
	@GetMapping(value = "slytherin")
	public ResponseEntity<String> managerEndpoint() {
		return new ResponseEntity<String>("hello i am Draco", HttpStatus.OK);
	}
}
