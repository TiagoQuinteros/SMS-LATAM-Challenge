package com.SMSLATAM.app.rest;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SMSLATAM.app.domain.service.MutantDetectorService;


@CrossOrigin(origins = "*", maxAge = 86400)
@RestController
@RequestMapping("/mutant/")
public class MutantDetectorController
{
	@Autowired
	private MutantDetectorService mutantDetectorService;
	
	@PostMapping(path = "", produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> digitalAccountTransfer(
			@RequestBody(required = true) String ADN) {
				
		if(mutantDetectorService.isMutant(null)) {
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Object>(HttpStatus.FORBIDDEN);
		}
		
		
	}
	
}
