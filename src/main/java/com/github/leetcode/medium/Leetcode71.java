package com.github.leetcode.medium;

import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 10/23/18 16:27
 * @Description: Given an absolute path for a file (Unix-style), simplify it.
 * <p>
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * path = "/a/../../b/../c//.//", => "/c"
 * path = "/a//b////c/d//././/..", => "/a/b/c"
 * <p>
 * In a UNIX-style file system, a period ('.') refers to the current directory, so it can be ignored in a simplified path. Additionally, a double period ("..") moves up a directory, so it cancels out whatever the last directory was. For more information, look here: https://en.wikipedia.org/wiki/Path_(computing)#Unix_style
 * <p>
 * Corner Cases:
 * <p>
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 */
public class Leetcode71 {

    public String simplifyPath(String path) {
        String[] pathArray = path.split("/");
        String result = "";
        Stack<String> stack = new Stack<String>();
        for (String value : pathArray) {
            if (value.equals("") || value.equals(".")) {//遇到""和.直接跳过

            } else if (value.equals("..")) {//遇到..表示返回上级目录，若栈非空，那么出栈
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {//进栈
                stack.push(value);
            }
        }
        //栈是否清空
        if (stack.isEmpty()) {
            return "/";
        } else {
            while (!stack.isEmpty()) {
                result = "/" + stack.pop() + result;
            }
            return result;
        }

    }


}
