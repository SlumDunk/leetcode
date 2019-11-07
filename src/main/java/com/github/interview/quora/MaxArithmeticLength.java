package com.github.interview.quora;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 10/19/19 12:03
 * @Description:
 */
public class MaxArithmeticLength {

    public static void main(String[] args) {
        int[] A = new int[]{0, 4, 8, 16};
        int[] B = new int[]{0, 2, 6, 12, 14, 20};

        Set<Integer> aSet = new HashSet<>();
        Set<Integer> bSet = new HashSet<>();
        int min = A[0];
        int max = A[0];

        for (int item : B) {
            bSet.add(item);
            min = Math.min(min, item);
            max = Math.max(max, item);
        }

        aSet.add(A[0]);


        int k = Integer.MAX_VALUE;
        //计算出等差的取值范围
        for (int i = 1; i < A.length; i++) {
            k = Math.min(k, A[i] - A[i - 1]);
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
            aSet.add(A[i]);
        }

        if (A.length == 1) {
            k = 0;
        }
        List<Integer> temp = new ArrayList<>();

        int most = -1;
        int cur = min;
        int idxA = 0;
        int idxB = 0;

        for (int i = 0; i <= k; i++) {
            boolean flag = true;
            while (idxA < A.length && idxB < B.length) {
                if (A[idxA] == cur) {
                    temp.add(cur);
                    idxA++;
                    cur = cur + i;
                } else {
                    if (!bSet.contains(cur)) {
                        flag = false;
                        break;
                    }
                    while (idxB < B.length && B[idxB] < cur) {
                        idxB++;
                    }
                    if (B[idxB] == cur) {
                        temp.add(idxB);
                    }
                    idxB++;
                    cur = cur + i;
                }
            }

            if (flag) {
                //数组A还有剩余，看符合条件不
                while (idxA < A.length) {
                    if (temp.get(temp.size() - 1) + i == A[idxA]) {
                        temp.add(A[idxA]);
                        idxA++;
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    //数组B还有剩余，看符合条件不
                    while (idxB < B.length) {
                        if (temp.get(temp.size() - 1) + i == B[idxB]) {
                            temp.add(B[idxB]);
                            idxB++;
                        } else {
                            if (B[idxB] > temp.get(temp.size() - 1)) {
                                break;
                            }
                            idxB++;
                        }
                    }

                    most = Math.max(temp.size() - A.length, most);
                }
            }
            temp.clear();
            cur = min;
            idxA = 0;
            idxB = 0;
        }

        System.out.println(most);
    }


    /**
     * @param b
     * @param idxB
     * @param diff
     * @param temp
     */
    public static void addAfter(int[] b, int idxB, int diff, LinkedList<Integer> temp) {
        while (idxB < b.length) {
            if (b[idxB] == diff + temp.get(temp.size() - 1)) {
                temp.add(b[idxB]);
            }
            idxB++;
        }
    }

    /**
     * 从后往前插入
     *
     * @param b
     * @param idxB
     * @param diff
     * @param temp
     */
    public static void addFront(int[] b, int idxB, int diff, LinkedList<Integer> temp) {
        while (idxB >= 0) {
            if (b[idxB] == temp.get(0) - diff) {
                temp.addFirst(b[idxB]);
            }
            idxB--;
        }
    }

    public static int checkIdxA(int[] a, int idxA, int diff, LinkedList<Integer> temp) {
        while (idxA < a.length) {
            if (a[idxA] == diff + temp.get(temp.size() - 1)) {
                temp.add(a[idxA++]);
            } else {
                break;
            }
        }
        return idxA;
    }

    /**
     * @param b   数组
     * @param val 数组a当前位置元素的值
     * @param pos
     * @param loc 数组B当前元素
     * @return
     */
    public static int findLong(int[] b, int val, int pos, int loc) {
        LinkedList<Integer> temp = new LinkedList<Integer>();
        temp.add(val);
        int diff = Math.abs(val - b[loc]);
        int res = 0;
        if (pos == -1) {
            addAfter(b, 0, diff, temp);
        } else if (pos == b.length - 1) {
            addFront(b, b.length - 1, diff, temp);
        } else {
            addAfter(b, pos, diff, temp);
            addFront(b, pos, diff, temp);
        }
        res = Math.max(res, temp.size());
        return res;
    }

    public static int maxArithmeticLength(int[] a, int[] b) {
        int lenA = a.length;
        int lenB = b.length;
        // find the place a[0] in b
        int left = 0, right = lenB - 1;
        int pos = -1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (b[mid] >= a[0]) {
                right = mid - 1;
            } else {
                pos = mid;
                left = mid + 1;
            }
        }
        // pos is the first b[pos] strictly less than a[0]
        int res = -1;
        if (a.length == 1) {
            // only have a[0] but not sure about the difference
            // the problem is equivalent to find the max Arithmetic length
            // contains A[0]
            for (int i = 0; i < b.length; i++) {
                res = Math.max(res, findLong(b, a[0], pos, i));
            }
        } else {
            // get the range of the difference
            int diffMax = a[1] - a[0];
            for (int i = 1; i < lenA; i++) {
                diffMax = Math.min(diffMax, a[i] - a[i - 1]);
            }
            for (int diff = 0; diff <= diffMax; diff++) {
                LinkedList<Integer> temp = new LinkedList<Integer>();
                temp.add(a[0]);
                if (pos == -1) {
                    // all elements in b is greater than A[0]
                    int idxA = 1, idxB = 0;
                    while (idxA < lenA && idxB < lenB) {
                        if (a[idxA] == diff + temp.get(temp.size() - 1)) {
                            temp.add(a[idxA++]);
                        } else if (b[idxB] == diff + temp.get(temp.size() - 1)) {
                            temp.add(b[idxB++]);
                        } else {
                            idxB++;
                        }
                    }
                    //A中剩余的元素符合条件
                    idxA = checkIdxA(a, idxA, diff, temp);
                    //B中剩余符合条件的元素加进来
                    if (idxA == lenA) {
                        addAfter(b, idxB, diff, temp);
                    }
                } else if (pos == lenB - 1) {
                    // all elements in B is smaller than a[0]
                    int idxA = 1;
                    idxA = checkIdxA(a, idxA, diff, temp);
                    if (idxA == lenA) {
                        addFront(b, b.length - 1, diff, temp);
                    }
                } else {
                    // a[0] split [0, pos] and [pos + 1, lenB - 1]
                    int idxA = 1, idxB = pos + 1;
                    while (idxA < lenA && idxB < lenB) {
                        if (a[idxA] == diff + temp.get(temp.size() - 1)) {
                            temp.add(a[idxA++]);
                        } else if (b[idxB] == diff + temp.get(temp.size() - 1)) {
                            temp.add(b[idxB++]);
                        } else {
                            idxB++;
                        }
                    }
                    idxA = checkIdxA(a, idxA, diff, temp);
                    // add
                    if (idxA == lenA) {
                        addFront(b, pos, diff, temp);
                        addAfter(b, idxB, diff, temp);
                    }
                }
                res = Math.max(res, temp.size());
            }
        }
        return res;
    }
}
