package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 11/15/18 20:26
 * @Description: Suppose we abstract our file system by a string in the following manner:
 * <p>
 * The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:
 * <p>
 * dir
 * subdir1
 * subdir2
 * file.ext
 * The directory dir contains an empty backTrack-directory subdir1 and a backTrack-directory subdir2 containing a file file.ext.
 * <p>
 * The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:
 * <p>
 * dir
 * subdir1
 * file1.ext
 * subsubdir1
 * subdir2
 * subsubdir2
 * file2.ext
 * The directory dir contains two backTrack-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty second-level backTrack-directory subsubdir1. subdir2 contains a second-level backTrack-directory subsubdir2 containing a file file2.ext.
 * <p>
 * We are interested in finding the longest (number of characters) absolute path to a file within our file system. For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).
 * <p>
 * Given a string representing the file system in the above format, return the length of the longest absolute path to file in the abstracted file system. If there is no file in the system, return 0.
 * <p>
 * Note:
 * The name of a file contains at least a . and an extension.
 * The name of a directory or backTrack-directory will not contain a ..
 * Time complexity required: O(n) where n is the size of the input string.
 * <p>
 * Notice that a/aa/aaa/file1.txt is not the longest file path, if there is another path aaaaaaaaaaaaaaaaaaaaa/sth.png.
 */
public class Leetcode388 {
    public static void main(String[] args) {
        Leetcode388 leetcode388 = new Leetcode388();
        System.out.println(leetcode388.lengthLongestPath_("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
    }

    public int lengthLongestPath(String input) {
        String[] paths = input.split("\n");
        int[] stack = new int[paths.length + 1];
        int maxLen = 0;
        for (String s : paths) {
            int lev = s.lastIndexOf("\t") + 1;
            int curLen = stack[lev + 1] = stack[lev] + s.length() - lev + 1;
            if (s.contains(".")) maxLen = Math.max(maxLen, curLen - 1);
        }
        return maxLen;
    }


    /**
     * O(n) '\t'只占一个字符位置
     *
     * @param input
     * @return
     */
    public int lengthLongestPath_(String input) {
        //整个字符串是深度优先
        String[] paths = input.split("\n");
        int[] stack = new int[paths.length + 1];
        int maxLen = 0;
        //后面相同的level会覆盖前面的
        for (String s : paths) {
            //当前所属的层级 最顶级是0
            int t_idx = s.lastIndexOf("\t");
            int level = t_idx + 1;

            //前缀目录的长度
            int prev = level >= 1 ? stack[level - 1] : 0;
            stack[level] = prev + s.length() - level;
            //包含文件的路径
            if (s.contains(".")) {
                maxLen = Math.max(maxLen, stack[level] + level);
            }
        }
        return maxLen;
    }
}
