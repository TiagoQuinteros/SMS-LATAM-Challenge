package com.SMSLATAM.app.domain.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.SMSLATAM.app.statsResponse;

@Service
public interface MutantDetectorService
{
	public Boolean isMutant(String[] adn);

	public statsResponse stats();
}
