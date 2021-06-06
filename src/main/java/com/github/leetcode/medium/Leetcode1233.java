package com.github.leetcode.medium;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 5/9/21 21:48
 * @Description: Given a list of folders, remove all sub-folders in those folders and return in any order the folders after removing.
 * <p>
 * If a folder[i] is located within another folder[j], it is called a sub-folder of it.
 * <p>
 * The format of a path is one or more concatenated strings of the form: / followed by one or more lowercase English letters. For example, /leetcode and /leetcode/problems are valid paths while an empty string and / are not.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
 * Output: ["/a","/c/d","/c/f"]
 * Explanation: Folders "/a/b/" is a subfolder of "/a" and "/c/d/e" is inside of folder "/c/d" in our filesystem.
 * Example 2:
 * <p>
 * Input: folder = ["/a","/a/b/c","/a/b/d"]
 * Output: ["/a"]
 * Explanation: Folders "/a/b/c" and "/a/b/d/" will be removed because they are subfolders of "/a".
 * Example 3:
 * <p>
 * Input: folder = ["/a/b/c","/a/b/ca","/a/b/d"]
 * Output: ["/a/b/c","/a/b/ca","/a/b/d"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= folder.length <= 4 * 10^4
 * 2 <= folder[i].length <= 100
 * folder[i] contains only lowercase letters and '/'
 * folder[i] always starts with character '/'
 * Each folder name is unique.
 */
public class Leetcode1233 {
    class TrieNode {
        Map<String, TrieNode> children = new HashMap<>();
        String path;
    }

    public List<String> removeSubfolders(String[] folder) {
        TrieNode root = buildTrie(folder);
        return bfs(root);
    }

    private List<String> bfs(TrieNode root) {
        List<String> result = new ArrayList<>();
        Queue<TrieNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TrieNode node = queue.poll();
            if (node.path == null) {
                for(TrieNode child:node.children.values()){
                   queue.offer(child);
                }
            }else{
                result.add(node.path);
            }
        }
        return result;
    }

    private TrieNode buildTrie(String[] folder) {
        TrieNode root = new TrieNode();
        for (String path :
                folder) {
            TrieNode cur = root;
            String[] dirs = path.substring(1).split("/");
            for (String dir :
                    dirs) {
                cur.children.putIfAbsent(dir, new TrieNode());
                cur = cur.children.get(dir);
            }
            cur.path = path;
        }
        return root;
    }
}
