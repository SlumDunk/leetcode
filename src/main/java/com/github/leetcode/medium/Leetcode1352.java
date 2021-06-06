package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement the class ProductOfNumbers that supports two methods:
 * <p>
 * 1. add(int num)
 * <p>
 * Adds the number num to the back of the current list of numbers.
 * 2. getProduct(int k)
 * <p>
 * Returns the product of the last k numbers in the current list.
 * You can assume that always the current list has at least k numbers.
 * At any time, the product of any contiguous sequence of numbers will fit into a single 32-bit integer without overflowing.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input
 * ["ProductOfNumbers","add","add","add","add","add","getProduct","getProduct","getProduct","add","getProduct"]
 * [[],[3],[0],[2],[5],[4],[2],[3],[4],[8],[2]]
 * <p>
 * Output
 * [null,null,null,null,null,null,20,40,0,null,32]
 * <p>
 * Explanation
 * ProductOfNumbers productOfNumbers = new ProductOfNumbers();
 * productOfNumbers.add(3);        // [3]
 * productOfNumbers.add(0);        // [3,0]
 * productOfNumbers.add(2);        // [3,0,2]
 * productOfNumbers.add(5);        // [3,0,2,5]
 * productOfNumbers.add(4);        // [3,0,2,5,4]
 * productOfNumbers.getProduct(2); // return 20. The product of the last 2 numbers is 5 * 4 = 20
 * productOfNumbers.getProduct(3); // return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
 * productOfNumbers.getProduct(4); // return 0. The product of the last 4 numbers is 0 * 2 * 5 * 4 = 0
 * productOfNumbers.add(8);        // [3,0,2,5,4,8]
 * productOfNumbers.getProduct(2); // return 32. The product of the last 2 numbers is 4 * 8 = 32
 * <p>
 * <p>
 * Constraints:
 * <p>
 * There will be at most 40000 operations considering both add and getProduct.
 * 0 <= num <= 100
 * 1 <= k <= 40000
 */
public class Leetcode1352 {
    class ProductOfNumbers {
        /**
         * 最终有 n+1 个数，包括一个初始化的 1
         */
        List<Integer> list;

        public ProductOfNumbers() {
            init();
        }

        private void init() {
            list = new ArrayList<>();
            list.add(1);
        }

        public void add(int num) {
            //遇到0表示前面的输入可以清空
            if (num == 0) {
                init();
                return;
            }
            list.add(list.get(list.size() - 1) * num);
        }

        public int getProduct(int k) {
            if (k >= list.size()) {
                return 0;
            }
            // n个数的乘积 / 前 (n-k)个数的乘积
            return list.get(list.size() - 1) / list.get(list.size() - 1 - k);
        }
    }

}
