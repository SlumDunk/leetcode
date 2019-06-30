package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 6/28/19 21:13
 * @Description: In a N x N grid composed of 1 x 1 squares, each 1 x 1 square consists of a /, \, or blank space.  These characters divide the square into contiguous regions.
 * <p>
 * (Note that backslash characters are escaped, so a \ is represented as "\\".)
 * <p>
 * Return the number of regions.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * " /",
 * "/ "
 * ]
 * Output: 2
 * Explanation: The 2x2 grid is as follows:
 * <p>
 * Example 2:
 * <p>
 * Input:
 * [
 * " /",
 * "  "
 * ]
 * Output: 1
 * Explanation: The 2x2 grid is as follows:
 * <p>
 * Example 3:
 * <p>
 * Input:
 * [
 * "\\/",
 * "/\\"
 * ]
 * Output: 4
 * Explanation: (Recall that because \ characters are escaped, "\\/" refers to \/, and "/\\" refers to /\.)
 * The 2x2 grid is as follows:
 * <p>
 * Example 4:
 * <p>
 * Input:
 * [
 * "/\\",
 * "\\/"
 * ]
 * Output: 5
 * Explanation: (Recall that because \ characters are escaped, "/\\" refers to /\, and "\\/" refers to \/.)
 * The 2x2 grid is as follows:
 * <p>
 * Example 5:
 * <p>
 * Input:
 * [
 * "//",
 * "/ "
 * ]
 * Output: 3
 * Explanation: The 2x2 grid is as follows:
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= grid.length == grid[0].length <= 30
 * grid[i][j] is either '/', '\', or ' '.
 */
public class Leetcode959 {
    public static void main(String[] args) {
        Leetcode959 leetcode959 = new Leetcode959();
        String[] grid = {" /", "  "};
        leetcode959.regionsBySlashes(grid);
    }

    class Node {
        public Node parent;

        public Node() {
            this.parent = this;
        }
    }

    /**
     * \    \   \
     * \    \   \
     * \    \   \
     * @param grid
     * @return
     */
    public int regionsBySlashes(String[] grid) {
        int N = grid.length;
        //多包了一道边界
        Node[][] nodes = new Node[N + 1][N + 1];
        nodes[0][0] = new Node();

        //初始化节点矩阵
        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes[i].length; j++) {
                if (nodes[i][j] == null) {
                    nodes[i][j] = new Node();
                }
            }
        }

        //整体构成一个大的连通分量
        fillLine(nodes, 0, nodes[0][0]);
        fillLine(nodes, nodes.length - 1, nodes[0][0]);
        fillColumn(nodes, 0, nodes[0][0]);
        fillColumn(nodes, nodes[0].length - 1, nodes[0][0]);


        int ans = 1;
        //遍历输入矩阵
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                char symbol = grid[i].charAt(j);
                if (symbol == '\\') {
                    if (find(nodes[i][j]) == find(nodes[i + 1][j + 1])) {//左上角 和 右下角
                        ans++;
                    }
                    union(nodes[i][j], nodes[i + 1][j + 1]);
                } else if (symbol == '/') {
                    if (find(nodes[i][j + 1]) == find(nodes[i + 1][j])) {// 右上角 和 左下角
                        ans++;
                    }
                    union(nodes[i][j + 1], nodes[i + 1][j]);
                }
            }
        }

        return ans;
    }

    /**
     * 寻找节点的根节点
     *
     * @param n
     * @return
     */
    private Node find(Node n) {
        Node parent = n.parent;
        if (n.parent != n) {
            parent = find(n.parent);
        }
        n.parent = parent;//path compression
        return parent;
    }

    /**
     * 归并两个节点
     *
     * @param a
     * @param b
     */
    private void union(Node a, Node b) {
        Node pA = find(a);
        Node pB = find(b);
        pA.parent = pB;
    }

    /**
     * 从行边界开始往里收
     *
     * @param nodes  节点数组
     * @param line   行号
     * @param parent 父节点
     */
    private void fillLine(Node[][] nodes, int line, Node parent) {
        for (int j = 0; j < nodes[line].length; j++) {
            if (nodes[line][j] == null) {
                nodes[line][j] = new Node();
            }
            nodes[line][j].parent = parent;
        }
    }

    /**
     * 从列边界开始往里收
     *
     * @param nodes
     * @param column
     * @param parent
     */
    private void fillColumn(Node[][] nodes, int column, Node parent) {
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i][column] == null) {
                nodes[i][column] = new Node();
            }
            nodes[i][column].parent = parent;
        }
    }
}
