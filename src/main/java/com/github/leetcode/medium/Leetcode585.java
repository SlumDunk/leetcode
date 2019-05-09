package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 3/19/19 18:57
 * @Description: Write a query to print the sum of all total investment values in 2016 (TIV_2016), to a scale of 2 decimal places, for all policy holders who meet the following criteria:
 * <p>
 * Have the same TIV_2015 value as one or more other policyholders.
 * Are not located in the same city as any other policyholder (i.e.: the (latitude, longitude) attribute pairs must be unique).
 * Input Format:
 * The insurance table is described as follows:
 * <p>
 * | Column Name | Type          |
 * |-------------|---------------|
 * | PID         | INTEGER(11)   |
 * | TIV_2015    | NUMERIC(15,2) |
 * | TIV_2016    | NUMERIC(15,2) |
 * | LAT         | NUMERIC(5,2)  |
 * | LON         | NUMERIC(5,2)  |
 * where PID is the policyholder's policy ID, TIV_2015 is the total investment value in 2015, TIV_2016 is the total investment value in 2016, LAT is the latitude of the policy holder's city, and LON is the longitude of the policy holder's city.
 * <p>
 * Sample Input
 * <p>
 * | PID | TIV_2015 | TIV_2016 | LAT | LON |
 * |-----|----------|----------|-----|-----|
 * | 1   | 10       | 5        | 10  | 10  |
 * | 2   | 20       | 20       | 20  | 20  |
 * | 3   | 10       | 30       | 20  | 20  |
 * | 4   | 10       | 40       | 40  | 40  |
 * Sample Output
 * <p>
 * | TIV_2016 |
 * |----------|
 * | 45.00    |
 * Explanation
 * <p>
 * The first record in the table, like the last record, meets both of the two criteria.
 * The TIV_2015 value '10' is as the same as the third and forth record, and its location unique.
 * <p>
 * The second record does not meet any of the two criteria. Its TIV_2015 is not like any other policyholders.
 * <p>
 * And its location is the same with the third record, which makes the third record fail, too.
 * <p>
 * So, the result is the sum of TIV_2016 of the first and last record, which is 45.
 */
public class Leetcode585 {
    public static void main(String[] args) {
        System.out.println("select\n" +
                "    sum(insurance.TIV_2016) as TIV_2016\n" +
                "from\n" +
                "    insurance\n" +
                "where\n" +
                "    insurance.TIV_2015 in\n" +
                "    (\n" +
                "        select\n" +
                "            TIV_2015\n" +
                "        from\n" +
                "            insurance\n" +
                "        group by TIV_2015\n" +
                "        having count(*)>1\n" +
                "    )\n" +
                "    and concat(LAT,LON) in\n" +
                "    (\n" +
                "        select\n" +
                "            concat(LAT,LON)\n" +
                "        from\n" +
                "            insurance\n" +
                "        group by LAT,LON\n" +
                "        having count(*)=1\n" +
                "    );");
    }
}
