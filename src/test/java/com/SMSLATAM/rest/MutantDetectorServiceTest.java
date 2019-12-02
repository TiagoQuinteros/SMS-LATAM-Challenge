package com.SMSLATAM.rest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.SMSLATAM.adnApiFixture;
import com.SMSLATAM.app.Application;
import com.SMSLATAM.app.statsResponse;
import com.SMSLATAM.app.domain.repository.DnaRepository;
import com.SMSLATAM.app.domain.service.AdnApi;
import com.SMSLATAM.app.domain.service.Impl.MutantDetectorServiceImpl;

@SpringBootTest(classes = Application.class)
@RunWith(MockitoJUnitRunner.class)
public class MutantDetectorServiceTest {

	@InjectMocks
	private MutantDetectorServiceImpl service;

	@Mock
	private DnaRepository dnaRepository;

	@Test
	public void NotMutant() {

		when(dnaRepository.saveAndFlush(any())).thenReturn(adnApiFixture.buildHumanDefault());
		String[] adn = new String[] { "ATGCGA", "AAGTGC", "ATATTA", "TGACAC", "GCGACA", "TCTCTG" };

		boolean response = service.isMutant(adn);

		assertFalse(response);

	}

	@Test
	public void MutantHorizontal() {
		when(dnaRepository.saveAndFlush(any())).thenReturn(adnApiFixture.buildMutantDefault());

		String[] adn = new String[] { "ATGCGA", "AAGTGC", "GTATTT", "AGACGC", "GCGTCA", "TCAAAA" };

		boolean response = service.isMutant(adn);

		assertTrue(response);

	}

	@Test
	public void MutantVertical() {
		when(dnaRepository.saveAndFlush(any())).thenReturn(adnApiFixture.buildMutantDefault());

		String[] adn = new String[] { "ATGCGA", "AATTGC", "ATATTA", "AGACGA", "GCGTCA", "TCGCAA" };

		boolean response = service.isMutant(adn);

		assertTrue(response);

	}

	@Test
	public void MutantDiagonalToRight() {

		when(dnaRepository.saveAndFlush(any())).thenReturn(adnApiFixture.buildMutantDefault());
		String[] adn = new String[] { "ATGCGA", "GAGTGC", "ATATTT", "CGAAGC", "GCGTCA", "TCGCAA" };

		boolean response = service.isMutant(adn);

		assertTrue(response);

	}

	@Test
	public void MutantDiagonalToLeft() {
		when(dnaRepository.saveAndFlush(any())).thenReturn(adnApiFixture.buildMutantDefault());

		String[] adn = new String[] { "TTGCGA", "GAGTGC", "TCTCAA", "GCGTAA", "CGAAGC", "ATATTT" };

		boolean response = service.isMutant(adn);

		assertTrue(response);

	}

	@Test
	private void stats() {
		List<AdnApi> listaAdn = new ArrayList<AdnApi>();
		listaAdn.add(adnApiFixture.buildHumanDefault());
		listaAdn.add(adnApiFixture.buildMutantDefault());

		when(dnaRepository.findAll()).thenReturn(listaAdn);

		statsResponse response = service.stats();
		statsResponse expectedResponse = new statsResponse();
		expectedResponse.setCount_human_dna(1);
		expectedResponse.setCount_mutant_dna(1);
		expectedResponse.setRatio((float) 0.5);

		assertEquals(response, expectedResponse);
	}
}
