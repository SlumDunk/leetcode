package com.github.leetcode.hard;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 7/24/19 16:13
 * @Description: In a project, you have a list of required skills req_skills, and a list of people.  The i-th person people[i] contains a list of skills that person has.
 * <p>
 * Consider a sufficient team: a set of people such that for every required skill in req_skills, there is at least one person in the team who has that skill.  We can represent these teams by the index of each person: for example, team = [0, 1, 3] represents the people with skills people[0], people[1], and people[3].
 * <p>
 * Return any sufficient team of the smallest possible size, represented by the index of each person.
 * <p>
 * You may return the answer in any order.  It is guaranteed an answer exists.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: req_skills = ["java","nodejs","reactjs"], people = [["java"],["nodejs"],["nodejs","reactjs"]]
 * Output: [0,2]
 * Example 2:
 * <p>
 * Input: req_skills = ["algorithms","math","java","reactjs","csharp","aws"], people = [["algorithms","math","java"],["algorithms","math","reactjs"],["java","csharp","aws"],["reactjs","csharp"],["csharp","math"],["aws","java"]]
 * Output: [1,2]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= req_skills.length <= 16
 * 1 <= people.length <= 60
 * 1 <= people[i].length, req_skills[i].length, people[i][j].length <= 16
 * Elements of req_skills and people[i] are (respectively) distinct.
 * req_skills[i][j], people[i][j][k] are lowercase English letters.
 * Every skill in people[i] is a skill in req_skills.
 * It is guaranteed a sufficient team exists.
 */
public class Leetcode1125 {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int sLen = req_skills.length, pLen = people.size();

        Map<String, Integer> skmap = new HashMap<>();
        for (int i = 0; i < sLen; i++)
            skmap.put(req_skills[i], i);

        //能够cover 前k项skill集合的最少人数集合
        Set<Integer>[] skillArr = new Set[1 << sLen];
        skillArr[0] = new HashSet<>();

        for (int ppl = 0; ppl < pLen; ppl++) {
            int pplSkill = 0;
            //获取这家伙会的技能
            for (String sks : people.get(ppl)) {
                pplSkill |= 1 << (skmap.get(sks));
            }

            for (int k = 0; k < skillArr.length; k++) {
                if (skillArr[k] == null) continue;
                Set<Integer> currSkills = skillArr[k];
                int combined = k | pplSkill;
                //此人的技能对整个结果集没有任何贡献，前面的人已经能cover掉了
                if (combined == k) continue;
                if (skillArr[combined] == null || skillArr[combined].size() > currSkills.size() + 1) {
                    Set<Integer> cSkills = new HashSet<>(currSkills);
                    cSkills.add(ppl);
                    skillArr[combined] = cSkills;
                }
            }
        }

        Set<Integer> resSet = skillArr[(1 << sLen) - 1];
        int[] res = new int[resSet.size()];
        int pos = 0;
        for (Integer n : resSet)
            res[pos++] = n;

        return res;
    }
}
