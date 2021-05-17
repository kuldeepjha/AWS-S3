package com.ama.aws.config;
/* 
 * Enter your code here. Read input from STDIN. Print your output to STDOUT. 
 * Your class should be named CandidateCode.
*/

import java.util.Scanner;

public class CandidateCode1 {
	public static void main(String args[]) throws Exception {

		// Write code here
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int firstInput[] = new int[size];
		int sceInput[] = new int[size];

		if (size <= 10) {

			for (int i = 0; i < size; i++) {
				firstInput[i] = scanner.nextInt();
				sceInput[i] = scanner.nextInt();
			}
			int bigValue = 0;
			int smallValue = 0;
			int primeCheck = 0;
			int smallPrime = 1;
			int bigPrime = 1;
			int val = 0;
			int val1 = 0;
			for (int t = 0; t < size; t++) {

				smallPrime = 1;
				bigPrime = 1;
				if (firstInput[t] > sceInput[t]) {
					bigValue = firstInput[t];
					smallValue = sceInput[t];
				} else {
					bigValue = sceInput[t];
					smallValue = firstInput[t];
				}
				if (smallValue > 1 && bigValue > 1 && bigValue < 1000000 && smallValue < 1000000) {
					val = bigValue;
					val1 = smallValue;

					for (int z = smallValue; z <= val; z++) {
						primeCheck = 0;
						if (z % 2 == 0 && z != 2) {
							primeCheck = 1;
						}
						for (int y = 2; y < z / 2; y++) {
							if (z % y == 0) {
								primeCheck = 1;
							}
						}
						if (smallPrime == 1 && primeCheck == 0) {
							smallPrime = z;
							break;
						}
					}

					primeCheck = 0;
					for (int o = bigValue; o >= val1; o--) {
						primeCheck = 0;
						if (o % 2 == 0 && o != 2) {
							primeCheck = 1;
						}
						for (int y = 2; y < o / 2; y++) {
							if (o % y == 0) {
								primeCheck = 1;
							}
						}
						if (bigPrime == 1 && primeCheck == 0) {
							bigPrime = o;
							break;
						}
					}
				}
				
				if (smallPrime != 1 && bigPrime == 1) {
					bigPrime = smallPrime;
				}
				if (smallPrime == 1 && bigPrime == 1) {
					System.out.println(-1);
				} else if (smallPrime == bigPrime) {
					System.out.println(0);
				} else {
					if (smallPrime < bigPrime) {
						System.out.println(bigPrime - smallPrime);
					} else {
						System.out.println(smallPrime - bigPrime);
					}
				}
			}
		}
	}
}
