package com.github.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 1/8/19 11:24
 * @Description: 桶排序算法
 * <p>
 * 常见的快速排序、归并排序、堆排序、冒泡排序等属于比较排序。在排序的最终结果里，元素之间的次序依赖于它们之间的比较。每个数都必须和其他数进行比较，才能确定自己的位置。
 * 在冒泡排序之类的排序中，问题规模为n，又因为需要比较n次，所以平均时间复杂度为O(n²)。在归并排序、快速排序之类的排序中，问题规模通过分治法消减为logN次，
 * 所以时间复杂度平均O(nlogn)。
 * 比较排序的优势是，适用于各种规模的数据，也不在乎数据的分布，都能进行排序。可以说，比较排序适用于一切需要排序的情况。
 * <p>
 * 计数排序、基数排序、桶排序则属于非比较排序。非比较排序是通过确定每个元素之前，应该有多少个元素来排序。针对数组arr，计算arr[i]之前有多少个元素，则唯一确定了arr[i]在排序后数组中的位置。
 * 非比较排序只要确定每个元素之前的已有的元素个数即可，所有一次遍历即可解决。算法时间复杂度O(n)。
 * 非比较排序时间复杂度低，但由于非比较排序需要占用空间来确定唯一位置。所以对数据规模和数据分布有一定的要求
 */
public class BucketSort {

    /**
     * 桶排序可用于最大最小值相差较大的数据情况，比如[9012,19702,39867,68957,83556,102456]。
     * 但桶排序要求数据的分布必须均匀，否则可能导致数据都集中到一个桶中。比如[104,150,123,132,20000], 这种数据会导致前4个数都集中到同一个桶中。导致桶排序失效。
     * <p>
     * 过程分析
     * 桶排序的基本思想是：把数组 arr 划分为n个大小相同子区间（桶），每个子区间各自排序，最后合并。
     * 计数排序是桶排序的一种特殊情况，可以把计数排序当成每个桶里只有一个元素的情况。
     * <p>
     * 1.找出待排序数组中的最大值max、最小值min
     * 2.我们使用 动态数组ArrayList 作为桶，桶里放的元素也用 ArrayList 存储。桶的数量为(max-min)/arr.length+1
     * 3.遍历数组 arr，计算每个元素 arr[i] 放的桶
     * 4.每个桶各自排序
     * 5.遍历桶数组，把排序好的元素放进输出数组
     *
     * @param nums
     */
    public static void sort(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }

        //确定桶的数量
        int bucketNum = (max - min) / nums.length + 1;
        //初始化桶
        List<List<Integer>> buckets = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            buckets.add(new ArrayList<>());
        }

        //将每个元素放入桶
        for (int i = 0; i < nums.length; i++) {
            int bucket = (nums[i] - min) / nums.length;
            buckets.get(bucket).add(nums[i]);
        }
        //对每个桶进行排序
        for (int i = 0; i < buckets.size(); i++) {
            Collections.sort(buckets.get(i));
        }
        for (List<Integer> bucket : buckets
                ) {
            if (bucket.size() > 0) {
                for (Integer item :
                        bucket) {
                    System.out.print(item);
                    System.out.print(',');
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {5, 3, 4, 0, 1, 100};
        sort(nums);
    }
}
