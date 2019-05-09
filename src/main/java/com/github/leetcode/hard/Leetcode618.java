package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 3/19/19 10:59
 * @Description: A U.S graduate school has students from Asia, Europe and America. The students' location information are stored in table student as below.
 * <p>
 * <p>
 * | name   | continent |
 * |--------|-----------|
 * | Jack   | America   |
 * | Pascal | Europe    |
 * | Xi     | Asia      |
 * | Jane   | America   |
 * <p>
 * <p>
 * Pivot the continent column in this table so that each name is sorted alphabetically and displayed underneath its corresponding continent. The output headers should be America, Asia and Europe respectively. It is guaranteed that the student number from America is no less than either Asia or Europe.
 * <p>
 * <p>
 * For the sample input, the output is:
 * <p>
 * <p>
 * | America | Asia | Europe |
 * |---------|------|--------|
 * | Jack    | Xi   | Pascal |
 * | Jane    |      |        |
 * <p>
 * <p>
 * Follow-up: If it is unknown which continent has the most students, can you write a query to generate the student report?
 */
public class Leetcode618 {
    public static void main(String[] args) {
        System.out.println("SELECT \n" +
                "    America, Asia, Europe\n" +
                "FROM\n" +
                "    (SELECT @as:=0, @am:=0, @eu:=0) t,\n" +
                "    (SELECT \n" +
                "        @as:=@as + 1 AS asid, name AS Asia\n" +
                "    FROM\n" +
                "        student\n" +
                "    WHERE\n" +
                "        continent = 'Asia'\n" +
                "    ORDER BY Asia) AS t1\n" +
                "        RIGHT JOIN\n" +
                "    (SELECT \n" +
                "        @am:=@am + 1 AS amid, name AS America\n" +
                "    FROM\n" +
                "        student\n" +
                "    WHERE\n" +
                "        continent = 'America'\n" +
                "    ORDER BY America) AS t2 ON asid = amid\n" +
                "        LEFT JOIN\n" +
                "    (SELECT \n" +
                "        @eu:=@eu + 1 AS euid, name AS Europe\n" +
                "    FROM\n" +
                "        student\n" +
                "    WHERE\n" +
                "        continent = 'Europe'\n" +
                "    ORDER BY Europe) AS t3 ON amid = euid\n" +
                ";");
    }
}
