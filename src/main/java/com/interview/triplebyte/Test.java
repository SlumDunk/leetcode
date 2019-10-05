package com.interview.triplebyte;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 9/18/19 17:36
 * @Description:
 */
public class Test {
    public static void main(String[] args) {

//        System.out.println(question3(40));
//        int[] array = new int[]{3, 2, 4, 6, 3, 4, 5, 8, 6, 7, 9, 6, 3, 6, 8, 4, 2, 2, 4, 6, 2, 1, 3, 4, 5, 6, 7, 4, 5, 7, 4, 5, 3, 2, 5, 6, 3, 7, 8, 3, 2, 9, 0, 4, 3, 6, 8, 9};
//
//        System.out.println(question4(array));
//
//        System.out.println(question6("LFIHKRVHRMWRXZGVZURHHSLIGLUDZGVI"));
//        coinBlocks();
//        String[] array = new String[]{
//                "&|&|&|&&&|&|||&&&|&&|||&||&||&|&&|||||&|&|&&&&||||&&&|&|&&||||&&&|&&|||&&|&&&|||",
//                "&&||&&&|&||&&&||&|||&&&|&||&&&|||||||&&&&|&&||&||&&|||&|&&&&&&|&|||&&||&|||&&|&|",
//                "&|&|&&&&|&&&|&|||&&&||||||&&|&&&&|&&|&&&|&||&|&&|||&&&|&&&&&|&&&&&&||&|&&||&&|&&",
//                "&|&&|||||&&&&||&&&||||&&&&|||||&||&|&|&|&||&|&&|&|&||||||&&||||||&|&&|&&&&&&||||",
//                "&||&&||&|&||&|&|&&&&&||&&&&&&&||&&|&&||&|&|&|&&&&|&&|||||&&&||||&||&&&|||&&&|||&",
//                "&&&&|&&|&|&&&|||&&&||||&|&|&&|&&&|&&&|||&|&&&|&|&&&|&&|||&|&|&|&|&&|&&&&|&&|||||",
//                "&&|&|&||||&||||&&|||&&&|||&&||&|&|||&||&&&||||&|&|&&|&&&|&&&|&&|&||&|&&&|&&&||||",
//                "&&&||||&&&&&|&|&&&&||&&|&|||&&&||&&&&|&&&|&&|&||&|&&|&||||&|&|||&|&||&||&|&&&&||",
//                "&&&|&&&||&||&||&|&|&||&&&|||||&|&&||&&&|||&|||||||&&|||&&||&|&|&|&|&&&&&&||&|&||",
//                "&&||&&|&&|||||&&&||&|&|&|&|&||&|&||&&&&||||&|&|||||||&|&&&&|&&|||||&|&||&&&||&|&"
//        };
//        escapeDungeon(array);
//        numberMunchers();
//        System.out.println(isMuncheres(690));
        System.out.println(Math.pow(0.98,50));
    }


    public static int question1() {
        int count = 0;
        for (int i = 2; i < 5000; i++) {
            if (i % 3 == 0 || i % 7 == 0 || i % 11 == 0) {
                count++;
            }
        }
        return count;
    }

    public static int question3(int n) {
        if (n == 1) {
            return 2;
        }
        if (n == 2) {
            return 5;
        } else {
            return question3(n - 1) + question3(n - 2);
        }
    }

    public static int question4(int[] array) {
        int[] count = new int[10];
        int ans = 0;
        for (int item :
                array) {
            count[item]++;
        }
        for (int item :
                count) {
            if (item % 2 == 1) {
                ans++;
            }
        }
        return ans;
    }

    static Map<Character, Character> map = new HashMap<>();

    static {
        map.put('A', 'Z');
        map.put('B', 'Y');
        map.put('C', 'X');
        map.put('D', 'W');
        map.put('E', 'V');
        map.put('F', 'U');
        map.put('G', 'T');
        map.put('H', 'S');
        map.put('I', 'R');
        map.put('J', 'Q');
        map.put('K', 'P');
        map.put('L', 'O');
        map.put('M', 'N');

        map.put('Z', 'A');
        map.put('Y', 'B');
        map.put('X', 'C');
        map.put('W', 'D');
        map.put('V', 'E');
        map.put('U', 'F');
        map.put('T', 'G');
        map.put('S', 'H');
        map.put('R', 'I');
        map.put('Q', 'J');
        map.put('P', 'K');
        map.put('O', 'L');
        map.put('N', 'M');
    }

    public static String question6(String origin) {
        StringBuilder buffer = new StringBuilder();
        for (char item :
                origin.toCharArray()) {
            buffer.append(map.get(item));
        }
        System.out.println(buffer.toString());
        return buffer.toString();
    }


    public static int coinBlocks() {
        int result = 0;
        for (int i = 1; i <= 1000; i++) {
            if (i % 15 == 0) {
                result += (i * 10);
            } else if (i % 5 == 0) {
                result += (i * 3);
            } else if (i % 3 == 0) {
                result += (i * 2);
            } else {
                result += i;
            }
        }
        System.out.println(result);

        return result;
    }

    public static void escapeDungeon(String[] array) {

        StringBuilder buffer = new StringBuilder();
        for (String str :
                array) {
            int keys = 0;
            boolean flag = true;
            for (char item :
                    str.toCharArray()) {
                if (item == '&') {
                    keys++;
                } else {
                    keys--;
                    if (keys >= 0) {
                        continue;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                buffer.append(1);
            } else {
                buffer.append(0);
            }
        }

        System.out.println(buffer.toString());
        System.out.println(binaryToDecimal(buffer.toString()));
    }

    public static int binaryToDecimal(String binarySource) {
        BigInteger bi = new BigInteger(binarySource, 2);    //转换为BigInteger类型
        return Integer.parseInt(bi.toString());        //转换成十进制
    }


    public static void numberMunchers() {
        int max = 1000;
        int count = 0;
        for (int i = 1; i <= 1000; i++) {
            for (int j = i; j <= 1000; j++) {
                int temp = i * j;
                if (temp <= 1000) {
                    if (isMuncheres(temp)) {
                        System.out.println(i + "," + j + "=" + temp);
                        count++;
                    }
                }
            }
        }

        System.out.println(count);

    }

    private static boolean isMuncheres(int temp) {
        int prev = 10;
        while (temp > 0) {
            int cur = temp % 10;
            if (cur >= prev) {
                return false;
            }
            prev = cur;

            temp = temp / 10;
        }
        return true;
    }
}
