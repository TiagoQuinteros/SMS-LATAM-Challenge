package com.SMSLATAM.app;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "adn")
public class statsResponse {

	@JsonProperty("count_mutant_dna")
	private float count_mutant_dna;

	@JsonProperty("count_human_dna")
	private float count_human_dna;

	@JsonProperty("ratio")
	private float ratio;

	public float getCount_mutant_dna() {
		return count_mutant_dna;
	}

	public void setCount_mutant_dna(float count_mutant_dna) {
		this.count_mutant_dna = count_mutant_dna;
	}

	public float getCount_human_dna() {
		return count_human_dna;
	}

	public void setCount_human_dna(float count_human_dna) {
		this.count_human_dna = count_human_dna;
	}

	public float getRatio() {
		return ratio;
	}

	public void setRatio(float ratio) {
		this.ratio = ratio;
	}

}
