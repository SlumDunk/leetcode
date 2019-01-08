package com.github.sort;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 1/7/19 22:43
 * @Description: 堆排序
 */
public class HeapSort {
    /**
     * 堆
     */
    static abstract class Heap {
        /**
         * 堆最大容量
         */
        protected int capacity;
        /**
         * 堆实际大小
         */
        protected int size;
        /**
         * 存储数据数组
         */
        protected int[] items;

        public Heap() {
            this.capacity = 10;
            this.size = 0;
            this.items = new int[capacity];
        }

        /**
         * 获取左子节点的位置
         *
         * @param parentIndex
         * @return
         */
        public int getLeftChildIndex(int parentIndex) {
            return 2 * parentIndex + 1;
        }

        /**
         * 获取右子节点的位置
         *
         * @param parentIndex
         * @return
         */
        public int getRightChildIndex(int parentIndex) {
            return 2 * parentIndex + 2;
        }

        /**
         * 获取父节点的位置
         *
         * @param childIndex
         * @return
         */
        public int getParentIndex(int childIndex) {
            return (childIndex - 1) / 2;
        }

        /**
         * 是否有左子节点
         *
         * @param index
         * @return
         */
        public boolean hasLeftChild(int index) {
            return getLeftChildIndex(index) < size;
        }

        /**
         * 是否有右子节点
         *
         * @param index
         * @return
         */
        public boolean hasRightChild(int index) {
            return getRightChildIndex(index) < size;
        }

        /**
         * 是否有父节点
         *
         * @param index
         * @return
         */
        public boolean hasParent(int index) {
            return getParentIndex(index) >= 0;
        }

        /**
         * 获取左子节点
         *
         * @param index
         * @return
         */
        public int leftChild(int index) {
            return items[getLeftChildIndex(index)];
        }

        /**
         * 获取右子节点
         *
         * @param index
         * @return
         */
        public int rightChild(int index) {
            return items[getRightChildIndex(index)];
        }

        /**
         * 获取父节点元素
         *
         * @param index
         * @return
         */
        public int parent(int index) {
            return items[getParentIndex(index)];
        }

        /**
         * 交换两个位置元素
         *
         * @param indexOne
         * @param indexTwo
         */
        public void swap(int indexOne, int indexTwo) {
            int temp = items[indexOne];
            items[indexOne] = items[indexTwo];
            items[indexTwo] = temp;
        }

        /**
         * 保证堆的存储容量
         */
        public void ensureCapacity() {
            if (size == capacity) {
                capacity = capacity << 1;
                items = Arrays.copyOf(items, capacity);
            }
        }

        /**
         * 获得堆顶元素
         *
         * @return
         */
        public int peek() {
            isEmpty("peek");
            return items[0];
        }

        /**
         * 判断是否为空
         *
         * @param methodName
         */
        public void isEmpty(String methodName) {
            if (size == 0) {
                throw new IllegalStateException("You cannot perform ' " + methodName + "' on an empty Heap.");
            }
        }

        /**
         * 数据出堆
         *
         * @return
         */
        public int poll() {
            isEmpty("poll");
            int item = items[0];
            items[0] = items[size - 1];
            size--;
            heapifyDown();
            return item;
        }

        /**
         * 添加数据
         *
         * @param item
         */
        public void add(int item) {
            ensureCapacity();
            items[size++] = item;
            heapifyUp();
        }

        /**
         * 删除数据时自顶向下调整堆结构
         */
        public abstract void heapifyDown();

        /**
         * 插入数据时自下向上调整堆结构
         */
        public abstract void heapifyUp();
    }

    /**
     * 最大堆
     */
    static class MaxHeap extends Heap {

        @Override
        public void heapifyDown() {
            int index = 0;
            while (hasLeftChild(index)) {
                //候选更大节点
                int biggerIndex = getLeftChildIndex(index);
                if (hasRightChild(index) && rightChild(index) > leftChild(index)) {//右子节点存在且比较大
                    biggerIndex = getRightChildIndex(index);
                }
                if (items[index] > items[biggerIndex]) {
                    break;
                } else {
                    swap(index, biggerIndex);
                }
                index = biggerIndex;
            }
        }

        @Override
        public void heapifyUp() {
            int index = size - 1;
            while (hasParent(index) && parent(index) < items[index]) {
                swap(getParentIndex(index), index);
                index = getParentIndex(index);
            }
        }
    }

    /**
     * 最小堆
     */
    static class MinHeap extends Heap {

        @Override
        public void heapifyDown() {
            int index = 0;
            while (hasLeftChild(index)) {
                int smallerIndex = getLeftChildIndex(index);
                if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                    smallerIndex = getRightChildIndex(index);
                }
                if (items[smallerIndex] > items[index]) {
                    break;
                } else {
                    swap(smallerIndex, index);
                }
                index = smallerIndex;
            }
        }

        @Override
        public void heapifyUp() {
            int index = size - 1;
            while (hasParent(index) && parent(index) > items[index]) {
                swap(getParentIndex(index), index);
                index = getParentIndex(index);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {57, 68, 59, 52};
        MinHeap minHeap = new MinHeap();
        MaxHeap maxHeap = new MaxHeap();
        for (int i = 0; i < nums.length; i++) {
            //minHeap.add(nums[i]);
            maxHeap.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            //System.out.println(minHeap.poll());
            System.out.println(maxHeap.poll());
        }

    }
}
