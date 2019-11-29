package com.SMSLATAM.app.domain.service.Impl;

public class MutantDetectorServiceImpl
{

	public Boolean isMutant(String[] adn)
	{
		int genNumber = 0;
		for (String gen : adn)
		{
			if (compareHorizontal(gen))
				return true;

			int baseNumber = 0;
			for (char baseNitrogenada : gen.toCharArray())
			{
				if (compareDiagonal(baseNitrogenada, adn, genNumber, baseNumber))
					return true;
				if (compareVertical(baseNitrogenada, adn, genNumber, baseNumber))
					return true;
				baseNumber++;
			}
			genNumber++;
		}

		return false;
	}

	private boolean compareDiagonal(char baseNitrogenada, String[] adn, int genNumber, int baseNumber)
	{
		if (adn.length - genNumber >= 4)
		{
			if (adn[genNumber].length() - baseNumber >= 4)
			{

				if (baseNitrogenada == adn[genNumber + 1].toCharArray()[baseNumber + 1]
						&& baseNitrogenada == adn[genNumber + 2].toCharArray()[baseNumber + 2]
						&& baseNitrogenada == adn[genNumber + 3].toCharArray()[baseNumber + 3])
				{
					return true;
				}
			}
			else
			{
				if (baseNumber >= 3)
				{

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

	private boolean compareVertical(char baseNitrogenada, String[] adn, int genNumber, int baseNumber)
	{
		if (adn.length - genNumber >= 4)
		{
			if (baseNitrogenada == adn[genNumber + 1].toCharArray()[baseNumber]
					&& baseNitrogenada == adn[genNumber + 2].toCharArray()[baseNumber]
					&& baseNitrogenada == adn[genNumber + 3].toCharArray()[baseNumber])
			{
				return true;
			}
		}

		return false;
	}

	private Boolean compareHorizontal(String gen)
	{
		char LastbaseNitrogenada = 0;
		int counter = 0;
		for (char baseNitrogenada : gen.toCharArray())
		{
			if (baseNitrogenada == LastbaseNitrogenada)
			{
				counter++;
				if (counter == 4)
					return true;
			}
			else
			{
				LastbaseNitrogenada = baseNitrogenada;
				counter = 1;
			}
		}
		return false;

	}

}
