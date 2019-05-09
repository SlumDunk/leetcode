package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 3/19/19 10:04
 * @Description: Given a table tree, id is identifier of the tree node and p_id is its parent node's id.
 * <p>
 * +----+------+
 * | id | p_id |
 * +----+------+
 * | 1  | null |
 * | 2  | 1    |
 * | 3  | 1    |
 * | 4  | 2    |
 * | 5  | 2    |
 * +----+------+
 * Each node in the tree can be one of three types:
 * Leaf: if the node is a leaf node.
 * Root: if the node is the root of the tree.
 * Inner: If the node is neither a leaf node nor a root node.
 * <p>
 * <p>
 * Write a query to print the node id and the type of the node. Sort your output by the node id. The result for the above sample is:
 * <p>
 * <p>
 * +----+------+
 * | id | Type |
 * +----+------+
 * | 1  | Root |
 * | 2  | Inner|
 * | 3  | Leaf |
 * | 4  | Leaf |
 * | 5  | Leaf |
 * +----+------+
 * <p>
 * <p>
 * Explanation
 * <p>
 * <p>
 * <p>
 * Node '1' is root node, because its parent node is NULL and it has child node '2' and '3'.
 * Node '2' is inner node, because it has parent node '1' and child node '4' and '5'.
 * Node '3', '4' and '5' is Leaf node, because they have parent node and they don't have child node.
 * <p>
 * And here is the image of the sample tree as below:
 * <p>
 * <p>
 * 1
 * /   \
 * 2       3
 * /   \
 * 4       5
 * Note
 * <p>
 * If there is only one node on the tree, you only need to output its root attributes.
 */
public class Leetcode608 {
    public static void main(String[] args) {
        System.out.println("select\n" +
                "    id as 'Id',\n" +
                "    case\n" +
                "        when tree.id=(select atree.id from tree atree where atree.p_id is null) then 'Root'\n" +
                "        when tree.id in (select atree.p_id from tree atree) then 'Inner'\n" +
                "        else 'Leaf'\n" +
                "    end as Type\n" +
                "\n" +
                "from\n" +
                "    tree\n" +
                "order by 'Id';");
    }
}
