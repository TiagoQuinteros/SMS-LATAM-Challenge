package com.SMSLATAM.rest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.mockito.junit.MockitoJUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;

import com.SMSLATAM.app.domain.service.Impl.MutantDetectorServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class MutantDetectorServiceTest
{

	@InjectMocks
	private MutantDetectorServiceImpl service;
	
	@Test
	public void NotMutant(){
		
		
		String[] adn = new String[]{"ATGCGA", "AAGTGC", "ATATTA", "TGACAC", "GCGACA", "TCTCTG"};
				
		boolean response = service.isMutant(adn);

		assertFalse(response);
		
	}
	
	
	@Test
	public void MutantHorizontal(){
		
		
		String[] adn = new String[]{"ATGCGA", "AAGTGC", "GTATTT", "AGACGC", "GCGTCA", "TCAAAA"};
				
		boolean response = service.isMutant(adn);

		assertTrue(response);
		
	}
	
	@Test
	public void MutantVertical(){
		
		
		String[] adn = new String[]{"ATGCGA", "AATTGC", "ATATTA", "AGACGA", "GCGTCA", "TCGCAA"};
				
		boolean response = service.isMutant(adn);

		assertTrue(response);
		
	}
	
	@Test
	public void MutantDiagonalToRight(){
		
		
		String[] adn = new String[]{"ATGCGA", "GAGTGC", "ATATTT", "CGAAGC", "GCGTCA", "TCGCAA"};
				
		boolean response = service.isMutant(adn);

		assertTrue(response);
		
	}
	
	@Test
	public void MutantDiagonalToLeft(){
		
		
		String[] adn = new String[] { "TTGCGA", 
									  "GAGTGC", 
									  "TCTCAA", 
									  "GCGTAA", 
									  "CGAAGC", 
									  "ATATTT"};
				
		boolean response = service.isMutant(adn);

		assertTrue(response);
		
	}
}
