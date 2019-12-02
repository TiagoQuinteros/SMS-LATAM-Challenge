package com.SMSLATAM.app;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "adn")
public class AdnRequestApi {
	
// TODO: how to make this work
//	@Pattern(regexp = "[ATCGatcg]*$", message = "Una base nitrogenada solo pueden ser de tipo ATCG")
	@NotNull
	@JsonProperty("dna")
	private String[] dna;

	public String[] getDna() {
		return dna;
	}

	public void setDna(String[] dna) {
		this.dna = dna;
	}

}
