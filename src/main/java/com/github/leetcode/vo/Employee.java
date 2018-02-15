package com.github.leetcode.vo;

import java.util.List;
/**
 * employee
 * @author liuzhongda
 *
 */
public class Employee {
	/**
	 * the unique id of the employee
	 */
	public int id;
	
	/**
	 * the importance value of this employee
	 */
	public int importance;
	
	/**
	 * the id of direct subordinates
	 */
	public List<Integer> subordinates;
}
