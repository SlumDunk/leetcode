package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 20:57
 * @Description: Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return all possible palindrome partitioning of s.
 * <p>
 * Example:
 * <p>
 * Input: "aab"
 * Output:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class Leetcode131 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> temp = new ArrayList<String>();
        backTrack(s, 0, temp, result);
        return result;
    }

    /**
     * @param s          字符串
     * @param startIndex 开始位置
     * @param temp       中间结果
     * @param result     结果集
     */
    private void backTrack(String s, int startIndex, List<String> temp, List<List<String>> result) {
        if (startIndex == s.length()) {
            result.add(new ArrayList<String>(temp));
            return;
        }
        for (int i = startIndex + 1; i <= s.length(); i++) {
            //startIndex...i前缀子串
            String prefix = s.substring(startIndex, i);
            //前缀子串非回文序列
            if (!isPrlindrome(prefix))  //剪枝
                continue;
            //前缀子串为回文序列，添加到中间结果集
            temp.add(prefix);
            backTrack(s, i, temp, result);
            //移除末尾元素
            temp.remove(temp.size() - 1);
        }
    }

    /**
     * 校验字符串是不是回文序列
     *
     * @param s
     * @return
     */
    private boolean isPrlindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }


    public List<List<String>> partition__(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        } else {
            char[] array = s.toCharArray();
            List<String> temp = new ArrayList<>();
            helper__(array, 0, result, temp);

            return result;
        }
    }

    /**
     * @param array
     * @param start
     * @param result
     * @param temp
     */
    public void helper__(char[] array, int start, List<List<String>> result, List<String> temp) {
        if (start == array.length) {
            result.add(new ArrayList<String>(temp));
        } else {
            StringBuilder buffer = new StringBuilder();
            for (int i = start; i < array.length; i++) {
                buffer.append(array[i]);
                if (isPalindrome__(buffer.toString())) {
                    temp.add(buffer.toString());
                    helper__(array, i + 1, result, temp);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

    /**
     * @param str
     * @return
     */
    public boolean isPalindrome__(String str) {
        int left = 0, right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;

    }


    /**
     * O(2^N)
     * @param s
     * @return
     */
    public List<List<String>> partition___(String s) {
        List<List<String>> result=new ArrayList<>();
        if(s==null||s.length()==0){
            return result;
        }else{
            List<String> temp=new ArrayList<>();
            helper(s,result,temp,0);

            return result;
        }
    }

    public void helper(String s, List<List<String>> result,List<String> temp,int start){
        if(start==s.length()){
            result.add(new ArrayList<>(temp));
        }else{
            for(int end=start+1;end<=s.length();end++){
                String str=s.substring(start,end);
                if(isValid(str)){
                    temp.add(str);
                    helper(s,result,temp,end);
                    temp.remove(temp.size()-1);
                }
            }
        }
    }

    public boolean isValid(String str){
        int left=0,right=str.length()-1;
        while(left<right){
            if(str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

}
