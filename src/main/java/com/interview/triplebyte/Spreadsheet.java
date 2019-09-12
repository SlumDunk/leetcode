package com.interview.triplebyte;

/**
 * @Author: zerongliu
 * @Date: 9/11/19 16:13
 * @Description:
 */
public class Spreadsheet {
    private int rows;
    private int columns;
    private String[][] contentArray;
    /**
     * record the length of the longest word of each column for pretty print
     */
    private int[] longestWordsLen;


    public Spreadsheet(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        contentArray = new String[rows][columns];
        longestWordsLen = new int[columns];

    }

    /**
     * update the content in the specific cell
     *
     * @param row
     * @param col
     * @param content
     * @return
     */
    public boolean update(int row, int col, String content) {
        if (row > rows || col > columns || row <= 0 || col <= 0) {
            return false;
        } else {
            if (contentArray[row - 1][col - 1] != null && longestWordsLen[col - 1] == contentArray[row - 1][col - 1].length()) {
                longestWordsLen[col - 1] = 0;
            }

            contentArray[row - 1][col - 1] = content;
            longestWordsLen[col - 1] = Math.max(longestWordsLen[col - 1], content.length());
            for (int i = 0; i < rows; i++) {
                if (contentArray[i][col - 1] != null) {
                    longestWordsLen[col - 1] = Math.max(longestWordsLen[col - 1], contentArray[i][col - 1].length());
                }
            }
            return true;
        }
    }

    /**
     * print the content of the sheet
     */
    public void printContent() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (contentArray[i][j] != null)
                    System.out.print(contentArray[i][j]);
                if (j < columns - 1) {
                    System.out.print('|');
                }
            }
            //seperated by new lines for each row
            System.out.println();
        }
    }

    /**
     * pretty print the content
     */
    public void prettyPrintContent() {
        String element = null;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                element = contentArray[i][j];
                if (element != null) {
                    System.out.print(element);
                }
                //left align
                if (element == null || element.length() != longestWordsLen[j]) {
                    int len = longestWordsLen[j] - (element == null ? 0 : element.length());
                    while (len > 0) {
                        System.out.print(' ');
                        len--;
                    }
                }

                if (j < columns - 1) {
                    System.out.print('|');
                }
            }
            //seperated by new lines for each row
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Spreadsheet spreadsheet = new Spreadsheet(4, 3);
        spreadsheet.update(1, 1, "bob");
        spreadsheet.update(1, 2, "10");
        spreadsheet.update(1, 3, "foo");
        spreadsheet.update(2, 1, "article");
        spreadsheet.update(2, 1, "1");
        spreadsheet.update(2, 2, "5");
        //step 1
        spreadsheet.printContent();
        //step 2
        spreadsheet.prettyPrintContent();
    }
}
