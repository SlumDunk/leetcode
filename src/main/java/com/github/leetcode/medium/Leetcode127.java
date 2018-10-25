package com.github.leetcode.medium;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 19:59
 * @Description: Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 * <p>
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 * <p>
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * Output: 5
 * <p>
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 * <p>
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * Output: 0
 * <p>
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class Leetcode127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList); //替换掉题目中List结构，加速查找
        if (!wordSet.contains(endWord)) return 0; //如果目标顶点不在图中，直接返回0
        HashMap<String, Integer> map = new HashMap<>(); //用来存储已访问的节点，并存储其在路径上的位置，相当于BFS算法中的isVisted功能
        Queue<String> q = new LinkedList<>(); //构建队列，实现广度优先遍历
        q.add(beginWord); //加入源顶点
        map.put(beginWord, 1); //添加源顶点为“已访问”，并记录它在路径的位置
        while (!q.isEmpty()) { //开始遍历队列中的顶点
            String word = q.poll(); //记录现在正在处理的顶点
            int level = map.get(word); //记录现在路径的长度
            for (int i = 0; i < word.length(); i++) {
                char[] wordLetter = word.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    if (wordLetter[i] == j) continue;
                    wordLetter[i] = j; //对于每一位字母，分别替换成另外25个字母
                    String check = new String(wordLetter);
                    if (check.equals(endWord)) return map.get(word) + 1; //如果已经抵达目标节点，返回当前路径长度+1
                    if (wordSet.contains(check) && !map.containsKey(check)) { //如果字典中存在邻接节点，且这个邻接节点还未被访问
                        map.put(check, level + 1); //标记这个邻接节点为已访问，记录其在路径上的位置
                        q.add(check); //加入队列，以供广度搜索
                    }
                }
            }
        }
        return 0;
    }
}
