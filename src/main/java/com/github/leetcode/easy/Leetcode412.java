package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a program that outputs the string representation of numbers from 1 to
 * n.
 * 
 * But for multiples of three it should output “Fizz” instead of the number and
 * for the multiples of five output “Buzz”. For numbers which are multiples of
 * both three and five output “FizzBuzz”.
 * 
 * Example:
 * 
 * n = 15,
 * 
 * Return: [ "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz",
 * "11", "Fizz", "13", "14", "FizzBuzz" ]
 * 
 * @author liuzhongda
 *
 */
public class Leetcode412 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fizzBuzz(30));
	}

	public static List<String> fizzBuzz(int n) {
		List<String> resultList = new ArrayList<String>();
		for (int i = 1; i <= n; i++) {
			if (i % 15 == 0) {
				resultList.add("FizzBuzz");
			} else if (i % 5 == 0) {
				resultList.add("Buzz");
			} else if (i % 3 == 0) {
				resultList.add("Fizz");
			} else {
				resultList.add(String.valueOf(i));
			}
		}
		return resultList;
	}

}
