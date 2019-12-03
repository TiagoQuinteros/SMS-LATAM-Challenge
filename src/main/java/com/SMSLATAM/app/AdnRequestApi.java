package com.SMSLATAM.app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.constraints.NotNull;

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

	public Boolean validate() {
		Boolean validate = true;
		for (@NotNull
		String gen : this.dna) {
			Pattern pat = Pattern.compile("[ATCGatcg]*$");
			Matcher mat = pat.matcher(gen);
			if (!mat.matches())
				validate = false;

		}
		return validate;

	}

}
