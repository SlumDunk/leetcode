package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 3/17/19 17:36
 * @Description: Given a list of directory info including directory path, and all the files with contents in this directory, you need to find out all the groups of duplicate files in the file system in terms of their paths.
 * <p>
 * A group of duplicate files consists of at least two files that have exactly the same content.
 * <p>
 * A single directory info string in the input list has the following format:
 * <p>
 * "root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"
 * <p>
 * It means there are n files (f1.txt, f2.txt ... fn.txt with content f1_content, f2_content ... fn_content, respectively) in directory root/d1/d2/.../dm. Note that n >= 1 and m >= 0. If m = 0, it means the directory is just the root directory.
 * <p>
 * The output is a list of group of duplicate file paths. For each group, it contains all the file paths of the files that have the same content. A file path is a string that has the following format:
 * <p>
 * "directory_path/file_name.txt"
 * <p>
 * Example 1:
 * <p>
 * Input:
 * ["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
 * Output:
 * [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
 * <p>
 * <p>
 * Note:
 * <p>
 * No order is required for the final output.
 * You may assume the directory name, file name and file content only has letters and digits, and the length of file content is in the range of [1,50].
 * The number of files given is in the range of [1,20000].
 * You may assume no files or directories share the same name in the same directory.
 * You may assume each given directory info represents a unique directory. Directory path and file info are separated by a single blank space.
 * <p>
 * <p>
 * Follow-up beyond contest:
 * Imagine you are given a real file system, how will you search files? DFS or BFS?
 * If the file content is very large (GB level), how will you modify your solution?
 * If you can only read the file by 1kb each time, how will you modify your solution?
 * What is the time complexity of your modified solution? What is the most time-consuming part and memory consuming part of it? How to optimize?
 * How to make sure the duplicated files you find are not false positive?
 */
public class Leetcode609 {
    /**
     * Follow up questions:
     * 1. Imagine you are given a real file system, how will you search files? DFS or BFS ?
     * In general, BFS will use more memory then DFS. However BFS can take advantage of the locality of files in inside directories, and therefore will probably be faster
     * <p>
     * 2. If the file content is very large (GB level), how will you modify your solution?
     * In a real life solution we will not hash the entire file content, since it's not practical. Instead we will first map all the files according to size. Files with different sizes are guaranteed to be different. We will than hash a small part of the files with equal sizes (using MD5 for example). Only if the md5 is the same, we will compare the files byte by byte
     * <p>
     * 3. If you can only read the file by 1kb each time, how will you modify your solution?
     * This won't change the solution. We can create the hash from the 1kb chunks, and then read the entire file if a full byte by byte comparison is required.
     * <p>
     * What is the time complexity of your modified solution? What is the most time consuming part and memory consuming part of it? How to optimize?
     * Time complexity is O(n^2 * k) since in worse case we might need to compare every file to all others. k is the file size
     * <p>
     * How to make sure the duplicated files you find are not false positive?
     * We will use several filters to compare: File size, Hash and byte by byte comparisons.
     *
     * @param paths
     * @return
     */
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for (String path :
                paths) {
            String[] array = path.split(" ");
            String dir = array[0];
            for (int i = 1; i < array.length; i++) {
                String filename = array[i].substring(0, array[i].indexOf('('));
                String content = array[i].substring(array[i].indexOf('(') + 1, array[i].length() - 1);
                String fileLoc = dir + "/" + filename;
                map.putIfAbsent(content, new ArrayList<>());
                map.get(content).add(fileLoc);
            }
        }

        for (String key :
                map.keySet()) {
            //重复出现过的
            if (map.get(key).size() > 1) {
                ans.add(new ArrayList<>(map.get(key)));
            }
        }
        return ans;
    }
}
