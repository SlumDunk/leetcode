package com.github.interview.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 4/11/19 10:54
 * @Description:
 */
public class ReorderLogFiles {

    class LogComparator implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            String[] array1 = s1.split(" ");
            String[] array2 = s2.split(" ");

            char s1FirstChar = array1[1].charAt(0);
            char s2FirstChar = array2[1].charAt(0);

            //都是数字，无差别
            if (Character.isDigit(s1FirstChar) && Character.isDigit(s2FirstChar)) {
                return 0;
            }
            //都是字母
            if (!(Character.isDigit(s1FirstChar)) && !(Character.isDigit(s2FirstChar))) {
                String log1 = s1.substring(array1[0].length() + 1);
                String log2 = s2.substring(array2[0].length() + 1);

                int result = log1.compareTo(log2);
                return result != 0 ? result : array1[0].compareTo(array2[0]);
            }

            //一条是字母，一条是数字
            return Character.isDigit(s1FirstChar) ? 1 : -1;
        }
    }

    public List<String> reorderLogFiles(int logFileSize, List<String> logLines) {
        if (logFileSize == 0 || logLines == null || logLines.size() == 0) {
            return new ArrayList<>();
        }
        Collections.sort(logLines, new LogComparator());
        return logLines;
    }
}
