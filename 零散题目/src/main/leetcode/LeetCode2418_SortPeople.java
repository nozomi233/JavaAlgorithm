package main.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author zhulang
 * @Date 2023-04-24
 **/
public class LeetCode2418_SortPeople {
    static class People implements Comparable<People>{
        private String name;
        private Integer height;

        public People(String name, Integer height) {
            this.name = name;
            this.height = height;
        }


        @Override
        public int compareTo(People o) {
            return o.height - this.height;
        }
    }

    static class Solution {
        public String[] sortPeople(String[] names, int[] heights) {
            List<People> list = new ArrayList<>();
            for (int i = 0; i < names.length; i++){
                list.add(new People(names[i], heights[i]));
            }

            Collections.sort(list);
            String[] res = new String[names.length];
            for (int i = 0; i < names.length; i++){
                res[i] = list.get(i).name;
            }
            return res;
        }
    }

    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> heights[b] - heights[a]);
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = names[indices[i]];
        }
        return res;
    }

}
