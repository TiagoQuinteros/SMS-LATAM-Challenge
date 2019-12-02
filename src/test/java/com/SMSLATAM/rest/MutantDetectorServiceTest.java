package com.SMSLATAM.rest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;	
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.SMSLATAM.adnApiFixture;
import com.SMSLATAM.app.statsResponse;
import com.SMSLATAM.app.domain.repository.DnaRepository;
import com.SMSLATAM.app.domain.service.AdnApi;
import com.SMSLATAM.app.domain.service.Impl.MutantDetectorServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class MutantDetectorServiceTest {

	@InjectMocks
	private MutantDetectorServiceImpl service;

	@Mock
	private DnaRepository dnaRepository;

	@Test
	public void NotMutant() {

		String[] adn = new String[] { "ATGCGA", "AAGTGC", "ATATTA", "TGACAC", "GCGACA", "TCTCTG" };

		boolean response = service.isMutant(adn);

		assertFalse(response);

	}

	@Test
	public void MutantHorizontal() {

		String[] adn = new String[] { "ATGCGA", "AAGTGC", "GTATTT", "AGACGC", "GCGTCA", "TCAAAA" };

		boolean response = service.isMutant(adn);

		assertTrue(response);

	}

	@Test
	public void MutantVertical() {

		String[] adn = new String[] { "ATGCGA", "AATTGC", "ATATTA", "AGACGA", "GCGTCA", "TCGCAA" };

		boolean response = service.isMutant(adn);

		assertTrue(response);

	}

	@Test
	public void MutantDiagonalToRight() {

		String[] adn = new String[] { "ATGCGA", "GAGTGC", "ATATTT", "CGAAGC", "GCGTCA", "TCGCAA" };

		boolean response = service.isMutant(adn);

		assertTrue(response);

	}

	@Test
	public void MutantDiagonalToLeft() {
		
		String[] adn = new String[] { "TTGCGA", "GAGTGC", "TCTCAA", "GCGTAA", "CGAAGC", "ATATTT" };

		boolean response = service.isMutant(adn);

		assertTrue(response);

	}

	@Test
	public void stats() {
		List<AdnApi> listaAdn = new ArrayList<AdnApi>();
		listaAdn.add(adnApiFixture.buildHumanDefault());
		listaAdn.add(adnApiFixture.buildMutantDefault());

		when(dnaRepository.findAll()).thenReturn(listaAdn);

		statsResponse response = service.stats();
		statsResponse expectedResponse = new statsResponse();
		expectedResponse.setCount_human_dna(1);
		expectedResponse.setCount_mutant_dna(1);
		expectedResponse.setRatio((float) 0.5);

		assertTrue(response.getRatio() == expectedResponse.getRatio());
		assertTrue(response.getCount_human_dna() == expectedResponse.getCount_human_dna());
		assertTrue(response.getCount_mutant_dna() == expectedResponse.getCount_mutant_dna());
	}
	
	@Test
	public void statsNull() {
	
		when(dnaRepository.findAll()).thenReturn(null);

		statsResponse response = service.stats();

		assertTrue(response.getCount_human_dna() == 0);
		assertTrue(response.getCount_mutant_dna() == 0);
		assertTrue(response.getRatio() == 0);
	}
}
