package main.top100;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhulang
 * @Date 2023-04-09
 **/
public class Top001_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        // 改进：循环，两数不在map才放进map,省空间，且不用先全放map
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i){
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        return new int[0];
    }
}
