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
        //替换掉题目中List结构，加速查找
        HashSet<String> wordSet = new HashSet<>(wordList);
        //如果目标顶点不在图中，直接返回0
        if (!wordSet.contains(endWord)) return 0;
        //用来存储已访问的节点，并存储其在路径上的位置，相当于BFS算法中的isVisted功能
        HashMap<String, Integer> map = new HashMap<>();
        //构建队列，实现广度优先遍历
        Queue<String> queue = new LinkedList<>();
        //加入源顶点
        queue.add(beginWord);
        //添加源顶点为“已访问”，并记录它在路径的位置
        map.put(beginWord, 1);
        while (!queue.isEmpty()) { //开始遍历队列中的顶点
            //记录现在正在处理的顶点
            String word = queue.poll();
            //记录现在路径的长度
            int level = map.get(word);
            for (int i = 0; i < word.length(); i++) {
                char[] wordLetter = word.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    if (wordLetter[i] == j) continue;
                    //对于每一位字母，分别替换成另外25个字母
                    wordLetter[i] = j;
                    String check = new String(wordLetter);
                    //如果已经抵达目标节点，因为每次只能变更一个字符，所以保证最先找到的是最短的
                    if (check.equals(endWord)) return level + 1;
                    //如果字典中存在邻接节点，且这个邻接节点还未被访问
                    if (wordSet.contains(check) && !map.containsKey(check)) {
                        //标记这个邻接节点为已访问，记录其在路径上的位置
                        map.put(check, level + 1);
                        //加入队列，以供广度搜索
                        queue.add(check);
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Leetcode127 leetcode127 = new Leetcode127();
        List<String> wordList = new ArrayList<>();
        wordList.add("a");
        wordList.add("b");
        wordList.add("c");

        System.out.println(leetcode127.ladderLength("a", "c", wordList));
    }

    /**
     * O(N*26)
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength__(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || !wordList.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        HashSet<String> wordSet = new HashSet<>(wordList);

        Set<String> visited = new HashSet<>();

        queue.add(beginWord);
        int level = 1;
        visited.add(beginWord);

        while (!queue.isEmpty()) {

            int size = queue.size();
            while (size > 0) {
                String current = queue.poll();

                if (current.equals(endWord)) {
                    return level;
                }

                for (int i = 0; i < current.length(); i++) {
                    char[] array = current.toCharArray();
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (j != array[i]) {
                            array[i] = j;
                            String word = new String(array);
                            if (wordSet.contains(word)) {
                                if (word.equals(endWord)) {
                                    return level + 1;
                                } else if (!visited.contains(word)) {
                                    queue.add(word);
                                    visited.add(word);
                                }
                            }

                        } else {
                            continue;
                        }
                    }
                }
                size--;
            }
            level++;
        }

        return 0;

    }
}
