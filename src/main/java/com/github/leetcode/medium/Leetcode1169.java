package com.github.leetcode.medium;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 9/14/19 17:01
 * @Description: A transaction is possibly invalid if:
 * <p>
 * the amount exceeds $1000, or;
 * if it occurs within (and including) 60 minutes of another transaction with the same name in a different city.
 * Each transaction string transactions[i] consists of comma separated values representing the name, time (in minutes), amount, and city of the transaction.
 * <p>
 * Given a list of transactions, return a list of transactions that are possibly invalid.  You may return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
 * Output: ["alice,20,800,mtv","alice,50,100,beijing"]
 * Explanation: The first transaction is invalid because the second transaction occurs within a difference of 60 minutes, have the same name and is in a different city. Similarly the second one is invalid too.
 * Example 2:
 * <p>
 * Input: transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
 * Output: ["alice,50,1200,mtv"]
 * Example 3:
 * <p>
 * Input: transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
 * Output: ["bob,50,1200,mtv"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * transactions.length <= 1000
 * Each transactions[i] takes the form "{name},{time},{amount},{city}"
 * Each {name} and {city} consist of lowercase English letters, and have lengths between 1 and 10.
 * Each {time} consist of digits, and represent an integer between 0 and 1000.
 * Each {amount} consist of digits, and represent an integer between 0 and 2000.
 */
public class Leetcode1169 {
    class Pair {
        int time;
        int money;
        String city;
        String user;

        public Pair(int time, int money, String city, String user) {
            this.time = time;
            this.money = money;
            this.city = city;
            this.user = user;
        }

        public String toString() {
            return this.user + "," + this.time + "," + this.money + "," + this.city;
        }
    }

    public List<String> invalidTransactions(String[] transactions) {
        //金额超过1000
        //60minutes内同个人在两个不同城市进行两笔交易

        Set<String> result = new HashSet<>();
        Map<String, List<Pair>> transactionMap = new HashMap<>();

        for (String transaction : transactions) {
            String[] array = transaction.split(",");
            String user = array[0];
            Integer time = Integer.valueOf(array[1]);
            Integer money = Integer.valueOf(array[2]);
            String city = array[3];
            if (transactionMap.get(user) == null) {
                transactionMap.put(user, new ArrayList<Pair>());
            }
            transactionMap.get(user).add(new Pair(time, money, city, user));
        }

        for (String key : transactionMap.keySet()) {
            List<Pair> transactionList = transactionMap.get(key);
            for (Pair item : transactionList) {
                if (item.money > 1000) {
                    result.add(item.toString());
                } else if (sameTransaction(item, transactionList)) {
                    result.add(item.toString());
                }
            }
        }
        List<String> ans = new ArrayList<>();
        Iterator<String> iterator = result.iterator();
        while (iterator.hasNext()) {
            ans.add(iterator.next());
        }

        return ans;
    }

    public boolean sameTransaction(Pair item, List<Pair> transactionList) {
        for (Pair value : transactionList) {
            if (item != value && Math.abs(item.time - value.time) <= 60 && !item.city.equals(value.city)) {
                return true;
            }
        }
        return false;
    }
}
