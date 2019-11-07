package com.github.lintcode.hard;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 10/22/19 19:02
 * @Description: 一致性哈希
 */
public class Lintcode519 {
    class Range {
        int id;
        int from, to;

        Range(int id, int from, int to) {
            this.id = id;
            this.from = from;
            this.to = to;
        }
    }


    public List<List<Integer>> consistentHashing(int n) {
        PriorityQueue<Range> heap = new PriorityQueue<>(16, new Comparator<Range>() {
            @Override
            public int compare(Range a, Range b) {
                //pick the range with larger range
                if (a.to - a.from > b.to - b.from) return -1;
                if (a.to - a.from < b.to - b.from) return 1;
                return a.id - b.id;
            }
        });

        heap.offer(new Range(1, 0, 359));

        for (int i = 2; i <= n; i++) {
            Range range = heap.poll();
            Range r1 = new Range(range.id, range.from, (range.from + range.to) / 2);
            Range r2 = new Range(i, (range.from + range.to) / 2 + 1, range.to);
            heap.offer(r1);
            heap.offer(r2);
        }

        List<List<Integer>> results = new ArrayList<>();
        while (!heap.isEmpty()) {
            Range range = heap.poll();
            List<Integer> result = new ArrayList<>();
            result.add(range.from);
            result.add(range.to);
            result.add(range.id);
            results.add(result);
        }
        return results;
    }

}
