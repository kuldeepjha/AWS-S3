package com.ama.aws.config;
// you can also use imports, for example:

// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {

	public int[] solution(int[] A, int F, int M) {

		int[] result = new int[F];
		int val = 0;

		int total = 0;
		for (int i = 0; i < A.length; i++) {
			total += A[i];
		}

		int count = A.length;

		for (int i = 1; i <= F; i++) {
			
			double avg = -1;
			
			for (int j = 1; j <= 6; j++) {
				
				if (((total + j) / (count + 1)) == M) {
					total += j;
					count++;
					result[val++] = j;
					break;
				}

				if (avg == -1) {
					avg = ((total + j) / (count + 1));
				} else {
					double temp = ((total + j) / (count + 1));
					if (Math.abs(avg - M) < Math.abs(temp - M)) {
						total += j - 1;
						count++;
						result[val++] = j - 1;
						break;
					} else {
						if (j == 6) {
							total += j;
							count++;
							result[val++] = j;
						}
						avg = temp;
					}
				}

			}
		}

		if (total / count != M)
			return new int[] { 0 };
		else
			return result;

	}

}
