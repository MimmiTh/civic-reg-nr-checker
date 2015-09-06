package com.mimmithorneus.civregnr;

import java.util.Scanner;

/**
 * Civic registration number checker
 * 
 * Checks if civic registration nr is correct according to the Luhn algorithm, and what gender it represents
 * 
 * @author Mimmi Thorneus <mimmi.thorneus@gmail.com>
 * @since 2015-06-18
 */
public class Main {
	public static void main(String[] args) {
		String nr;
		
		Scanner keyboard = new Scanner(System.in);
		
		do {
			System.out.print("Input civic registration number (YYMMDD-XXXX) (empty string closes program): ");
			nr = keyboard.nextLine();
			
			if (!nr.equals("")) {
				CivicRegistrationNumber crn = new CivicRegistrationNumber(nr);

				boolean invalid = !crn.isCorrect();
				boolean isMale = crn.isMale();
				
				if (invalid) {
					System.out.println("The civic registration number '" + nr + "' is incorrect.");
					continue;
				}
				
				if (isMale) {
					System.out.println("The male civic registration number '" + nr + "' is correct.");
				} else {
					System.out.println("The female civic registration number '" + nr + "' is correct.");
				}
			}
		} while (!nr.equals(""));
		
		keyboard.close();

	}

}
