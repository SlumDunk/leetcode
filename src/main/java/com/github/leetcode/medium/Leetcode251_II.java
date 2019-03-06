package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 3/4/19 15:24
 * @Description:
 */
public class Leetcode251_II {
    public static void main(String[] args) {
        int[][] v = new int[][]{{1, 2}, {3}, {4}};
        Vector2D iterator = new Vector2D(v);

        iterator.next(); // return 1
        iterator.next(); // return 2
        iterator.next(); // return 3
        iterator.hasNext(); // return true
        iterator.hasNext(); // return true
        iterator.next(); // return 4
        iterator.hasNext(); // return false
    }

    static class Vector2D {

        List<List<Integer>> vec2d;

        int row = 0;

        int col = 0;

        public Vector2D(int[][] v) {
            this.vec2d = new ArrayList<>();
            int m = v.length;
            for (int i = 0; i < m; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < v[i].length; j++) {
                    temp.add(v[i][j]);
                }
                vec2d.add(temp);
            }
        }

        public int next() {
            if (col >= vec2d.get(row).size()) {
                row++;
                col = 0;
            }
            Integer value = vec2d.get(row).get(col);
            col++;
            return value;
        }

        public boolean hasNext() {
            if (vec2d.isEmpty() || row >= vec2d.size()) {
                return false;
            } else {
                //判断是否需要更新列位置
                if (col == vec2d.get(row).size()) {
                    row++;
                    while (row != vec2d.size()) {//找到接下来第一个非空的行
                        if (vec2d.get(row).size() == 0) {
                            row++;
                        } else {
                            break;
                        }
                    }
                    col = 0;
                    //不存在非空的行了
                    if (row == vec2d.size()) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

}
