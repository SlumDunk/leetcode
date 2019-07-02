package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/2/19 16:04
 * @Description: Given strings A and B of the same length, we say A[i] and B[i] are equivalent characters. For example, if A = "abc" and B = "cde", then we have 'a' == 'c', 'b' == 'd', 'c' == 'e'.
 * <p>
 * Equivalent characters follow the usual rules of any equivalence relation:
 * <p>
 * Reflexivity: 'a' == 'a'
 * Symmetry: 'a' == 'b' implies 'b' == 'a'
 * Transitivity: 'a' == 'b' and 'b' == 'c' implies 'a' == 'c'
 * For example, given the equivalency information from A and B above, S = "eed", "acd", and "aab" are equivalent strings, and "aab" is the lexicographically smallest equivalent string of S.
 * <p>
 * Return the lexicographically smallest equivalent string of S by using the equivalency information from A and B.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = "parker", B = "morris", S = "parser"
 * Output: "makkek"
 * Explanation: Based on the equivalency information in A and B, we can group their characters as [m,p], [a,o], [k,r,s], [e,i]. The characters in each group are equivalent and sorted in lexicographical order. So the answer is "makkek".
 * Example 2:
 * <p>
 * Input: A = "hello", B = "world", S = "hold"
 * Output: "hdld"
 * Explanation:  Based on the equivalency information in A and B, we can group their characters as [h,w], [d,e,o], [l,r]. So only the second letter 'o' in S is changed to 'd', the answer is "hdld".
 * Example 3:
 * <p>
 * Input: A = "leetcode", B = "programs", S = "sourcecode"
 * Output: "aauaaaaada"
 * Explanation:  We group the equivalent characters in A and B as [a,o,e,r,s,c], [l,p], [g,t] and [d,m], thus all letters in S except 'u' and 'd' are transformed to 'a', the answer is "aauaaaaada".
 * <p>
 * <p>
 * Note:
 * <p>
 * String A, B and S consist of only lowercase English letters from 'a' - 'z'.
 * The lengths of string A, B and S are between 1 and 1000.
 * String A and B are of the same length.
 */
public class Leetcode1061 {
    class UnionFind {
        int[] father;

        public UnionFind() {
            father = new int[26];
            for (int i = 0; i < 26; i++) {
                father[i] = i;
            }
        }

        public int find(int x) {
            if (father[x] == x) return x;
            return father[x] = find(father[x]);
        }

        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA != rootB) {
                father[rootA] = rootB;
            }
        }
    }

    public String smallestEquivalentString(String A, String B, String S) {
        UnionFind uf = new UnionFind();
        for (int i = 0; i < A.length(); i++) {
            uf.union(A.charAt(i) - 'a', B.charAt(i) - 'a');
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int index = c - 'a';
            for (int j = 0; j < 26; j++) {
                if (uf.find(c - 'a') == uf.find(j) && j < c - 'a') {
                    index = j;
                    break;
                }
            }
            sb.append((char) (index + 'a'));
        }
        return sb.toString();
    }
}
