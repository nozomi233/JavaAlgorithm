package com.zhulang;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author zhulang
 * @Date 2022-12-29
 **/
public class LeetCode2032_TwoOutOfThree {
    static class Solution {
        public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
            Set<Integer> set = new HashSet<>();
            List<Integer> list1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
            List<Integer> list2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
            List<Integer> list3 = Arrays.stream(nums3).boxed().collect(Collectors.toList());
            for (int i : list1){
                if (list2.contains(i) || list3.contains(i)){
                    set.add(i);
                }
            }
            for (int i : list2){
                if (list1.contains(i) || list3.contains(i)){
                    set.add(i);
                }
            }
            for (int i : list3){
                if (list2.contains(i) || list1.contains(i)){
                    set.add(i);
                }
            }
            List<Integer> result = new ArrayList<Integer>();
            result.addAll(set);
            return result;
        }

        public List<Integer> twoOutOfThree2(int[] nums1, int[] nums2, int[] nums3) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i : nums1) {
                map.put(i, 1);
            }
            for (int i : nums2) {
                map.put(i, map.getOrDefault(i, 0) | 2);
            }
            for (int i : nums3) {
                map.put(i, map.getOrDefault(i, 0) | 4);
            }
            List<Integer> res = new ArrayList<Integer>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int k = entry.getKey(), v = entry.getValue();
                if ((v & (v - 1)) != 0) {
                    res.add(k);
                }
            }
            return res;
        }
    }
}
