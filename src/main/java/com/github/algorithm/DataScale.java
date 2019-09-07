package com.github.algorithm;

/**
 * @Author: zerongliu
 * @Date: 1/6/19 14:39
 * @Description:
 */
public class DataScale {
    /**
     * java数据处理范围10^8
     * f(n)=10^8
     * O(1) O(logn) O(sqrt(n)) >> 10^8
     * O(n)=10^8
     * O(nlogn) O(n^2) O(n^3) 10^4
     * O(n!) O(2^n)
     */
    public static void dataScale() {
        for (int i = 1; i < 10; i++) {
            double num = Math.pow(10, (double) i);
            int sum = 0;
            long start = System.currentTimeMillis();
            System.out.println(num);
            for (int j = 0; j <= num; j++) {
                sum += j;
            }
            long end = System.currentTimeMillis();
            long scale = end - start;
            System.out.println("10^" + i + " : " + scale);
        }
    }

    public static void main(String[] args) {
        String str = "hello";
        System.out.println(str.substring(0, 0));
        //dataScale();
        Integer max = Integer.MAX_VALUE;
        System.out.println(max + 1);

        Integer min = Integer.MIN_VALUE;
        System.out.println(min - 1);
    }
}
