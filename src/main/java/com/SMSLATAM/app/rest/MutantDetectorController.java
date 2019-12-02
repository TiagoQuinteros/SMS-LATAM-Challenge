package com.SMSLATAM.app.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SMSLATAM.app.AdnRequestApi;
import com.SMSLATAM.app.statsResponse;
import com.SMSLATAM.app.domain.service.MutantDetectorService;

@CrossOrigin(origins = "*", maxAge = 86400)
@RestController
@RequestMapping("")
public class MutantDetectorController {
	@Autowired
	private MutantDetectorService mutantDetectorService;

	@Validated
	@PostMapping(path = "/mutant/", produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> isMutant(@RequestBody(required = true) @Valid AdnRequestApi dna) {

		if (mutantDetectorService.isMutant(dna.getDna())) {
			return new ResponseEntity<Object>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(HttpStatus.FORBIDDEN);
		}

	}

	@GetMapping(path = "/stats", produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public statsResponse stats() {

		return mutantDetectorService.stats();

	}

}
