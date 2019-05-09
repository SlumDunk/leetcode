package com.github.interview.google;

/**
 * @Author: zerongliu
 * @Date: 12/5/18 10:00
 * @Description: Assume you are playing a card game in which each card has a cost and a damage caused to your opponent.
 * Write a function:
 * class Solution
 * {
 * public boolean Solution (int total_money, int total_damage , int[] costs, int[] damages){}
 * }
 * <p>
 * that given:
 * -baidu 1point3acres
 * integer total_money : total money you have
 * integer total_damage : total damage to be caused
 * array costs of integers (size N) : the cost of every card
 * array damages of integers (size N) : the damage caused to your opponent by every card
 * <p>
 * <p>
 * should return true if it is possible to cause at least total_damage amount of damage to your opponent using
 * a maximum of total_money units of money, or false otherwise. Each card can be selected only once.
 * <p>
 * <p>
 * For example, given total_money = 5, total_damage = 3, costs = [4,5,1] and damages = [1,2,3] your function
 * should return true. You can scause at least total_damage amount of damage to your opponent using a
 * maximum of total_money units of money in 2 different ways:
 * <p>
 * <p>
 * By selecting the third card whose cost is 1 and damage is 3.
 * By selecting the first and third card whose cost are (4,1) and damage caused to another player are (1,3)
 * <p>
 * <p>
 * It is possible to cause at least 3 units of damage to your opponent, therefore, ther answer is true.
 * <p>
 * <p>
 * Assume that:
 * <p>
 * <p>
 * N, total_money and total_damage are integers within the range [1..1,000]
 * each element of arrrays costs, damages is an integer within the range [1...1,000]
 */
public class Google5 {
    public static void main(String[] args) {
        int totalMoney = 5;
        int totalDamage = 3;
        int[] costs = {4, 5, 1};
        int[] damages = {1, 2, 3};
        Boolean result = cardGame(totalMoney, totalDamage, costs, damages);
        System.out.println(result);
    }

    private static Boolean cardGame(int totalMoney, int totalDamage, int[] costs, int[] damages) {
        int len = costs.length;
        //拥有n元打前m张牌能造成的最大伤害
        int middle[][] = new int[len + 1][totalMoney + 1];
        //拥有0张牌
        for (int i = 0; i < totalMoney + 1; i++) {
            middle[0][i] = 0;
        }
        //拥有0元
        for (int i = 0; i < len + 1; i++) {
            middle[i][0] = 0;
        }
        for (int i = 1; i < len + 1; i++) {
            for (int j = 0; j < totalMoney + 1; j++) {
                //当打此牌的花费小于等于拥有的钱的时候
                if (costs[i - 1] <= j) {
                    //当打出此牌造成的伤害比不打出此牌造成的伤害大
                    if (middle[i - 1][j] < damages[i - 1] + middle[i - 1][j - costs[i - 1]]) {
                        middle[i][j] = middle[i - 1][j - costs[i - 1]] + damages[i - 1];
                    } else {
                        middle[i][j] = middle[i - 1][j];
                    }
                } else {
                    middle[i][j] = middle[i - 1][j];
                }
            }
        }
        for (int i = 0; i < middle.length; i++) {
            for (int j = 0; j < middle[0].length; j++) {
                System.out.printf(middle[i][j] + " ");
            }
            System.out.println();
        }
        //System.out.println(middle[len][totalMoney]);
        if (middle[len][totalMoney] >= totalDamage) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }
}
