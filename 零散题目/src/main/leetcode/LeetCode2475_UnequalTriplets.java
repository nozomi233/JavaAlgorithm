package main.leetcode;

import java.util.*;

/**
 * @Author zhulang
 * @Date 2023-06-13
 **/
public class LeetCode2475_UnequalTriplets {

    public int unequalTriplets3(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int x : nums) {
            count.merge(x, 1, Integer::sum);
        }
        int res = 0, n = nums.length, t = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            res += t * entry.getValue() * (n - t - entry.getValue());
            t += entry.getValue();
        }
        return res;
    }


    public int unequalTriplets4(int[] nums) {
        Arrays.sort(nums);
        int res = 0, n = nums.length;
        for (int i = 0, j = 0; i < n; i = j) {
            while (j < n && nums[j] == nums[i]) {
                j++;
            }
            res += i * (j - i) * (n - j);
        }
        return res;
    }




    int res = 0;
    public int unequalTriplets(int[] nums) {
        List<Integer> path = new ArrayList<>();
        backtrace(nums, path, 0);


        return res;
    }

    public void backtrace(int[] nums, List<Integer> path, int index){
        if (path.size() == 3){
            res += 1;
            return;
        }

        if (index == nums.length){
            return;
        }
//        if (path.contains(nums[index])){
//            return;
//        }

        // path选
        for (int i = index; i < nums.length; i++){
            if (!path.contains(nums[i])){
                path.add(nums[i]);
                backtrace(nums, path, i + 1);
                path.remove(path.size() - 1);
            }
        }

    }

    public int unequalTriplets2(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++){
            for (int j = i + 1; j < nums.length - 1; j++){
                for (int k = j + 1; k < nums.length; k++){
                    if (nums[i] != nums[j] && nums[j] != nums[k] && nums[i] != nums[k]){
                        res += 1;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,1,2,4};
        LeetCode2475_UnequalTriplets l = new LeetCode2475_UnequalTriplets();
        System.out.println(l.unequalTriplets(nums));
    }

}
