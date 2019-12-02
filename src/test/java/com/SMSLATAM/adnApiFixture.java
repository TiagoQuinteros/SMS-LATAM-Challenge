package com.SMSLATAM;

import com.SMSLATAM.app.domain.service.AdnApi;

public class adnApiFixture {
	private Long id = 1L;

	private AdnApi getMutantDefault() {
		String[] adn = { "AAAAGC" };
		return new AdnApi(id, adn, true);
	}

	private AdnApi getHumanDefault() {
		String[] adn = { "AAAGGC" };
		return new AdnApi(id, adn, false);
	}

	public static AdnApi buildHumanDefault() {
		return new adnApiFixture().getHumanDefault();
	}

	public static AdnApi buildMutantDefault() {
		return new adnApiFixture().getMutantDefault();
	}

}
