package com.SMSLATAM.app.domain.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.SMSLATAM.app.statsResponse;
import com.SMSLATAM.app.domain.repository.DnaRepository;
import com.SMSLATAM.app.domain.service.AdnApi;
import com.SMSLATAM.app.domain.service.MutantDetectorService;

@Service
public class MutantDetectorServiceImpl implements MutantDetectorService {
	@Autowired
	DnaRepository dnaRepository;

	public Boolean isMutant(String[] adn) {
		AdnApi dna = new AdnApi();
		dna.setDna(adn);
		int genNumber = 0;
		for (String gen : adn) {
			if (compareHorizontal(gen)) {
				dna.setMutant(true);
				dnaRepository.save(dna);
				return true;
			}

			int baseNumber = 0;
			for (char baseNitrogenada : gen.toCharArray()) {
				if (compareDiagonal(baseNitrogenada, adn, genNumber, baseNumber)) {
					dna.setMutant(true);
					dnaRepository.save(dna);
					return true;
				}
				if (compareVertical(baseNitrogenada, adn, genNumber, baseNumber)) {
					dna.setMutant(true);
					dnaRepository.save(dna);
					return true;
				}
				baseNumber++;
			}
			genNumber++;
		}
		dna.setMutant(false);
		dnaRepository.save(dna);
		return false;
	}

	private boolean compareDiagonal(char baseNitrogenada, String[] adn, int genNumber, int baseNumber) {
		if (adn.length - genNumber >= 4) {
			if (adn[genNumber].length() - baseNumber >= 4) {

				if (baseNitrogenada == adn[genNumber + 1].toCharArray()[baseNumber + 1]
						&& baseNitrogenada == adn[genNumber + 2].toCharArray()[baseNumber + 2]
						&& baseNitrogenada == adn[genNumber + 3].toCharArray()[baseNumber + 3]) {
					return true;
				}
			} else {
				if (baseNumber >= 3) {

					if (baseNitrogenada == adn[genNumber + 1].toCharArray()[baseNumber - 1]
							&& baseNitrogenada == adn[genNumber + 2].toCharArray()[baseNumber - 2]
							&& baseNitrogenada == adn[genNumber + 3].toCharArray()[baseNumber - 3])

					{
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean compareVertical(char baseNitrogenada, String[] adn, int genNumber, int baseNumber) {
		if (adn.length - genNumber >= 4) {
			if (baseNitrogenada == adn[genNumber + 1].toCharArray()[baseNumber]
					&& baseNitrogenada == adn[genNumber + 2].toCharArray()[baseNumber]
					&& baseNitrogenada == adn[genNumber + 3].toCharArray()[baseNumber]) {
				return true;
			}
		}

		return false;
	}

	private Boolean compareHorizontal(String gen) {
		char LastbaseNitrogenada = 0;
		int counter = 0;
		for (char baseNitrogenada : gen.toCharArray()) {
			if (baseNitrogenada == LastbaseNitrogenada) {
				counter++;
				if (counter == 4)
					return true;
			} else {
				LastbaseNitrogenada = baseNitrogenada;
				counter = 1;
			}
		}
		return false;

	}

	@Override
	public statsResponse stats() {
		List<AdnApi> adns = dnaRepository.findAll();
		statsResponse response = new statsResponse();
		float humanCounter = 0;
		float mutantCounter = 0;
		for (AdnApi adn : adns) {
			if (adn.getMutant() == true)
				mutantCounter++;
			humanCounter++;
		}
		response.setCount_human_dna(humanCounter);
		response.setCount_mutant_dna(mutantCounter);
		response.setRatio(mutantCounter / (mutantCounter + humanCounter));
		return response;
	}

}
