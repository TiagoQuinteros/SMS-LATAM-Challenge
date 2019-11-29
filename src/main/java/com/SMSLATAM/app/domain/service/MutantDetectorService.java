package com.SMSLATAM.app.domain.service;

import org.springframework.stereotype.Service;

@Service
public interface MutantDetectorService
{
	public Boolean isMutant(String[] adn);
}
