package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/2/19 07:49
 * @Description:
 */
public class Leetcode534 {
    public static void main(String[] args) {
        System.out.println("select a1.player_id,a1.event_date,sum(a2.games_played) as games_played_so_far\n" +
                "from activity a1\n" +
                "left join activity a2\n" +
                "on a1.player_id=a2.player_id\n" +
                "and a1.event_date>=a2.event_date\n" +
                "group by 1,2\n" +
                "order by 1,2");
    }
}
