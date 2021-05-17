package com.ama.aws.config;
/* 
 * Enter your code here. Read input from STDIN. Print your output to STDOUT. 
 * Your class should be named CandidateCode.
*/

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author Kuldeep
 *
 */
public class CandidateCode {
	
	@Autowired
	static
	Bean1 bean1;
	
	public static void main(String args[]) throws Exception {

		bean1.init();
		// Write code here
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String virus = scanner.nextLine();
		char[] virusChar = virus.toCharArray();

		int person = scanner.nextInt();
		if (person > 0 && person < 11) {
			String[] bloodComposition = new String[person];

			for (int i = 0; i < person; i++) {
				String str = scanner.next();
				bloodComposition[i] = str;
			}

			int temp = 0;
			int value = 0;
			String result = null;
			int val = 0;
			if (virusChar.length > 0 && virusChar.length <= 100000) {

				for (int p = 0; p < person; p++) {
					val = 0;
					char[] bloodCompositionChar = bloodComposition[p].toCharArray();

					for (int t = 0; t < bloodCompositionChar.length; t++) {
						if (bloodCompositionChar.length > 0 && bloodCompositionChar.length <= 100000) {
							if (result != "NEGATIVE") {

								if (virusChar.length > t || virusChar.length < bloodCompositionChar.length) {
									temp = 0;
									for (int z = val; z < virusChar.length; z++) {
										if (Character.compare(virusChar[z], bloodCompositionChar[t]) == 0) {
											if (result != "NEGATIVE") {
												if (result == null) {
													result = "POSITIVE";
													value = z;
													val = value + 1;
													temp = 1;
													break;
												} else {
													if (value < z) {
														result = "POSITIVE";
														value = z;
														temp = 1;
														val = value + 1;
														break;
													} else {
														result = "NEGATIVE";
													}
												}
											}

										}
										if (result == "NEGATIVE")
											break;
									}
									if (temp == 0) {
										result = "NEGATIVE";
									}
								}
								if (result == null) {
									result = "NEGATIVE";
									break;
								}
							}
						}
					}
					if (result == null)
						result = "NEGATIVE";
					System.out.println(result);
					result = null;
					value = 0;
				}
			}
		}
	}
}
