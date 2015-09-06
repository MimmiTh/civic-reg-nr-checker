package com.mimmithorneus.civregnr;

public class CivicRegistrationNumber {
	private String nr;
	private String cleanedNr;

	public CivicRegistrationNumber(String nr) {
		this.nr = nr;
		this.cleanedNr = cleanCivicRegNr();
	}

	public void setCivicRegNr(String nr) {
		this.nr = nr;
		this.cleanedNr = cleanCivicRegNr();
	}

	public String getCivicRegNr() {
		return nr;
	}

	public boolean isCorrect() {
		if (this.cleanedNr.length() != 10) {
			return false;
		}

		int[] numbers = new int[this.cleanedNr.length()];

		for (int i = 0; i < this.cleanedNr.length(); i++) {
			numbers[i] = Character.digit(this.cleanedNr.charAt(i), 10);
		}

		return calculateChecksum(numbers) % 10 == 0;
	}

	public boolean isMale() {
		Character controlNr = this.cleanedNr.charAt(8);

		return controlNr % 2 == 1;
	}

	private String cleanCivicRegNr() {
		String newNr = "";

		for (int i = 0; i < this.nr.length(); i++) {
			char c = this.nr.charAt(i);

			if (Character.isDigit(c)) {
				newNr += c;
			}
		}

		return newNr;
	}

	private int calculateChecksum(int[] numbers) {
		int sum = 0;

		for (int i = 0; i < numbers.length; i++) {
			int number = numbers[numbers.length - i - 1];

			if (i % 2 == 1) {
				number *= 2;
			}

			sum += (number < 10) ? number : number - 9;
		}

		return sum;
	}
}
