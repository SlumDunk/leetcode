package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 15:16
 * @Description: Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * <p>
 * Example:
 * <p>
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 */
public class Leetcode93 {
    public static void main(String[] args) {
        Leetcode93 leetcode93 = new Leetcode93();
        System.out.println(leetcode93.restoreIpAddresses("25525511135"));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        backTrack(result, s, "", 0, "", 0);
        return result;
    }

    /**
     * @param result       结果集
     * @param s            字符串
     * @param parentDomain 父级网段
     * @param startIndex   开始位置
     * @param curDomain    当前网段
     * @param times        当前属于第几段 IP地址总共有4个段
     */
    private void backTrack(List<String> result, String s, String parentDomain, int startIndex, String curDomain, int times) {
        if (times < 4 && times > 0) {
            parentDomain = parentDomain + curDomain + '.';
        } else if (times == 4 && startIndex == s.length()) {
            //遍历完字符串，且得到4个段，所以是合法IP
            result.add(parentDomain + curDomain);
        }
        //要拼接的下一个子网IP段
        String subDomain = "";
        for (int i = startIndex; i < s.length() && times < 4; i++) {
            subDomain = subDomain + s.charAt(i);
            //该子网ip不合法，跳过
            if (subDomain.length() > 1 && subDomain.startsWith("0") || Integer.parseInt(subDomain) > 255)
                break;
            backTrack(result, s, parentDomain, i + 1, subDomain, times + 1);
            //因为父网段和子网段之间用.隔开，所以递归过程不会出现重复，所以回溯时不需要移除末尾字符
        }
    }

}
