package com.github.leetcode.hard;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 6/23/19 11:25
 * @Description: Under a grammar given below, strings can represent a set of lowercase words.  Let's use R(expr) to denote the set of words the expression represents.
 * <p>
 * Grammar can best be understood through simple examples:
 * <p>
 * Single letters represent a singleton set containing that word.
 * R("a") = {"a"}
 * R("w") = {"w"}
 * When we take a comma delimited list of 2 or more expressions, we take the union of possibilities.
 * R("{a,b,c}") = {"a","b","c"}
 * R("{{a,b},{b,c}}") = {"a","b","c"} (notice the final set only contains each word at most once)
 * When we concatenate two expressions, we take the set of possible concatenations between two words where the first word comes from the first expression and the second word comes from the second expression.
 * R("{a,b}{c,d}") = {"ac","ad","bc","bd"}
 * R("{a{b,c}}{{d,e},f{g,h}}") = R("{ab,ac}{dfg,dfh,efg,efh}") = {"abdfg", "abdfh", "abefg", "abefh", "acdfg", "acdfh", "acefg", "acefh"}
 * Formally, the 3 rules for our grammar:
 * <p>
 * For every lowercase letter x, we have R(x) = {x}
 * For expressions e_1, e_2, ... , e_k with k >= 2, we have R({e_1,e_2,...}) = R(e_1) ∪ R(e_2) ∪ ...
 * For expressions e_1 and e_2, we have R(e_1 + e_2) = {a + b for (a, b) in R(e_1) × R(e_2)}, where + denotes concatenation, and × denotes the cartesian product.
 * Given an expression representing a set of words under the given grammar, return the sorted list of words that the expression represents.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "{a,b}{c{d,e}}"
 * Output: ["acd","ace","bcd","bce"]
 * Example 2:
 * <p>
 * Input: "{{a,z},a{b,c},{ab,z}}"
 * Output: ["a","ab","ac","z"]
 * Explanation: Each distinct word is written only once in the final answer.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= expression.length <= 50
 * expression[i] consists of '{', '}', ','or lowercase English letters.
 * The given expression represents a set of words based on the grammar given in the description.
 */
public class Leetcode1096 {
    public static void main(String[] args) {
        Leetcode1096 leetcode1096 = new Leetcode1096();
        leetcode1096.braceExpansionII("{a,b}{c{d,e}}");
    }

    public List<String> braceExpansionII(String expression) {
        char[] expCharAry = expression.toCharArray();
        //放置最外层结果
        LinkedList<TreeSet<String>> strOrSetStack = new LinkedList<>();
        //放置内层结果
        LinkedList<TreeSet<String>> strConcatSetStack = new LinkedList<>();

        //预留一个空的坑 相当于空串
        strConcatSetStack.addLast(new TreeSet<>());
        strConcatSetStack.getLast().add("");

        for (char expChar : expCharAry) {
            if (expChar == '{') {//遇到新的层
                //预留一个坑放置此层结果
                strOrSetStack.addLast(new TreeSet<String>());
                //放置一个旧层的坑，是空 给单个字符预留的
                strConcatSetStack.addLast(new TreeSet<>());
                strConcatSetStack.getLast().add("");

                continue;
            }
            if (expChar == '}') {//这一层结束
                //先把剩下的元素取出来 放到这一层的坑中
                strOrSetStack.getLast().addAll(strConcatSetStack.removeLast());
                //把这一层结果取出
                TreeSet<String> strOrSet = strOrSetStack.removeLast();
                //这一层旧的结果
                TreeSet<String> oldStrConcatSet = strConcatSetStack.removeLast();
                //存储这一层的新结果 跟上层结果进行组合，flatten 拉平
                TreeSet<String> newStrConcatSet = new TreeSet<>();
                for (String oldStrConcat : oldStrConcatSet) {
                    for (String strOr : strOrSet) {
                        newStrConcatSet.add(oldStrConcat + strOr);
                    }
                }
                //构建完新层，放置进去
                strConcatSetStack.addLast(newStrConcatSet);
                continue;
            }
            if (expChar == ',') {//遇到同一层内的分隔符
                //直接将结果取出添加到这一层的结果中
                strOrSetStack.getLast().addAll(strConcatSetStack.removeLast());
                //放置一个新坑
                strConcatSetStack.addLast(new TreeSet<>());
                strConcatSetStack.getLast().add("");
                continue;
            }
            {//遇到元素
                //取出旧坑中的元素，组装新坑
                TreeSet<String> oldStrConcatSet = strConcatSetStack.removeLast();
                TreeSet<String> newStrConcatSet = new TreeSet<>();
                for (String oldStrConcat : oldStrConcatSet) {
                    newStrConcatSet.add(oldStrConcat + expChar);
                }
                strConcatSetStack.addLast(newStrConcatSet);
            }
        }

        return new LinkedList<String>(strConcatSetStack.getLast());
    }
}
