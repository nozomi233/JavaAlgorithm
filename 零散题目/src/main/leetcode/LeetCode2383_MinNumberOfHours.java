package main.leetcode;

/**
 * @Author zhulang
 * @Date 2023-03-13
 **/
public class LeetCode2383_MinNumberOfHours {
    static class Solution {
        public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {

            int sum = 0;
            for (int e : energy) {
                sum += e;
            }
            int trainingHours = initialEnergy > sum ? 0 : sum + 1 - initialEnergy;
            for (int e : experience) {
                if (initialExperience <= e) {
                    trainingHours += 1 + (e - initialExperience);
                    initialExperience = 2 * e + 1;
                } else {
                    initialExperience += e;
                }
            }
            return trainingHours;
        }
    }
}
