package main.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @Author zhulang
 * @Date 2023-04-12
 **/
public class LeetCode2404_MostFrequentEven {


    static class Solution {
        public int mostFrequentEven(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < nums.length; i++){
                if (nums[i] % 2 == 0){
                    map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
                }
            }
            int res = -1;
            int ct = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()){
                if (entry.getValue() > ct || (res > entry.getKey() && entry.getValue() == ct)){
                    res = entry.getKey();
                    ct = entry.getValue();
                }
            }
            return res;
        }
    }
}
