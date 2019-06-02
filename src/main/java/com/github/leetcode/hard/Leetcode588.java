package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @Author: zerongliu
 * @Date: 5/26/19 11:28
 * @Description: Design an in-memory file system to simulate the following functions:
 * <p>
 * ls: Given a path in string format. If it is a file path, return a list that only contains this file's name. If it is a directory path, return the list of file and directory names in this directory. Your output (file and directory names together) should in lexicographic order.
 * <p>
 * mkdir: Given a directory path that does not exist, you should make a new directory according to the path. If the middle directories in the path don't exist either, you should create them as well. This function has void return type.
 * <p>
 * addContentToFile: Given a file path and file content in string format. If the file doesn't exist, you need to create that file containing given content. If the file already exists, you need to append given content to original content. This function has void return type.
 * <p>
 * readContentFromFile: Given a file path, return its content in string format.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input:
 * ["FileSystem","ls","mkdir","addContentToFile","ls","readContentFromFile"]
 * [[],["/"],["/a/b/c"],["/a/b/c/d","hello"],["/"],["/a/b/c/d"]]
 * <p>
 * Output:
 * [null,[],null,null,["a"],"hello"]
 * <p>
 * Explanation:
 * filesystem
 * <p>
 * <p>
 * Note:
 * <p>
 * You can assume all file or directory paths are absolute paths which begin with / and do not end with / except that the path is just "/".
 * You can assume that all operations will be passed valid parameters and users will not attempt to retrieve file content or list a directory or file that does not exist.
 * You can assume that all directory names and file names only contain lower-case letters, and same names won't exist in the same directory.
 */
public class Leetcode588 {
    static class FileSystem {

        interface Node {
            List<String> list();
        }

        class DirNode implements Node {
            TreeMap<String, Node> children;

            DirNode() {
                children = new TreeMap<>();
            }

            @Override
            public List<String> list() {
                List<String> ret = new ArrayList<>();
                for (String key :
                        children.keySet()) {
                    ret.add(key);
                }
                return ret;
            }
        }

        class FileNode implements Node {
            String name;
            StringBuilder content;

            FileNode(String s) {
                this.name = s;
                content = new StringBuilder();
            }

            @Override
            public List<String> list() {
                List<String> ret = new ArrayList<>();
                ret.add(this.name);
                return ret;
            }
        }

        private Node root = null;

        public FileSystem() {
            root = new DirNode();
        }

        public List<String> ls(String path) {
            String[] nodes = path.split("/");
            Node tmp = goToNode(nodes, nodes.length - 1);
            return tmp.list();
        }

        private Node goToNode(String[] path, int end) {
            Node tmp = root;
            for (int i = 0; i <= end; i++) {
                String n = path[i];
                //跳过根节点
                if (n.length() == 0) continue;
                if (tmp instanceof DirNode) {
                    DirNode x = (DirNode) tmp;
                    if (x.children.get(n) == null) {
                        x.children.put(n, new DirNode());
                    }
                    tmp = x.children.get(n);
                }
            }
            return tmp;
        }

        public void mkdir(String path) {
            String[] nodes = path.split("/");
            goToNode(nodes, nodes.length - 1);
        }

        public void addContentToFile(String filePath, String content) {
            String[] nodes = filePath.split("/");
            //找到文件的父节点
            Node tmp = goToNode(nodes, nodes.length - 2);
            if (tmp instanceof DirNode) {
                DirNode x = (DirNode) tmp;
                String fileName = nodes[nodes.length - 1];
                if (x.children.containsKey(fileName)) {
                    ((FileNode) x.children.get(fileName)).content.append(content);
                } else {
                    FileNode newFile = new FileNode(fileName);
                    newFile.content.append(content);
                    x.children.put(fileName, newFile);
                }
            }
        }

        public String readContentFromFile(String filePath) {
            String[] nodes = filePath.split("/");
            Node tmp = goToNode(nodes, nodes.length - 1);
            if (tmp instanceof FileNode) {
                return ((FileNode) tmp).content.toString();
            } else {
                return null;
            }
        }
    }
}
