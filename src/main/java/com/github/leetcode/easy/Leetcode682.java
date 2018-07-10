package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * You're now a baseball game point recorder.
 * 
 * Given a list of strings, each string can be one of the 4 following types:
 * 
 * Integer (one round's score): Directly represents the number of points you get
 * in this round. "+" (one round's score): Represents that the points you get in
 * this round are the sum of the last two valid round's points. "D" (one round's
 * score): Represents that the points you get in this round are the doubled data
 * of the last valid round's points. "C" (an operation, which isn't a round's
 * score): Represents the last valid round's points you get were invalid and
 * should be removed. Each round's operation is permanent and could have an
 * impact on the round before and the round after.
 * 
 * You need to return the sum of the points you could get in all the rounds.
 * 
 * Example 1: Input: ["5","2","C","D","+"] 
 * Output: 30 Explanation: 
 * Round 1: You
 * could get 5 points. The sum is: 5. 
 * Round 2: You could get 2 points. The sum
 * is: 7. Operation 1: The round 2's data was invalid. The sum is: 5. 
 * Round 3:
 * You could get 10 points (the round 2's data has been removed). The sum is:
 * 15. 
 * Round 4: You could get 5 + 10 = 15 points. The sum is: 30.
 * 
 * @author liuzhongda
 *
 */
public class Leetcode682 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] ops=new String[] {"5","-2","4","C","D","9","+","+"};
		System.out.println(calPoints(ops));
	}
	
	public static int calPoints(String[] ops) {
		List<Integer> sumList = new ArrayList<Integer>();
		int sum = 0;
		for (String op : ops) {
			switch (op) {
			case "C":
				if (sumList.size() >= 1) {
					sum -= sumList.get(sumList.size() - 1);
					sumList.remove(sumList.size() - 1);
				}
				break;
			case "D":
				if (sumList.size() >= 1) {
					sum += sumList.get(sumList.size() - 1) * 2;
					sumList.add(sumList.get(sumList.size() - 1) * 2);					
				}
				break;
			case "+":
				if (sumList.size() >= 2) {
					sum += sumList.get(sumList.size() - 1) + sumList.get(sumList.size() - 2);
					sumList.add(sumList.get(sumList.size() - 1) + sumList.get(sumList.size() - 2));
				}
				break;
			default:
				sumList.add(Integer.parseInt(op));
				sum += Integer.parseInt(op);
				break;
			}
		}
		return sum;
	}

}
