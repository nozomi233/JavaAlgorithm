package main;

/**
 * @Author zhulang
 * @Date 2023-05-24
 **/
public class LeetCode0494_FindTargetSumWays {

    int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        backTrace(0, nums, target);
        return count;
    }

    public void backTrace(int i, int[] nums, int res){
        if (i == nums.length){
            if (res == 0){
                count += 1;
            }
            return;
        }

        res += nums[i];
        backTrace(i + 1, nums, res);
        res -= nums[i];

        res -= nums[i];
        backTrace(i + 1, nums, res);
        res += nums[i];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1};
        int target = 3;
        LeetCode0494_FindTargetSumWays obj = new LeetCode0494_FindTargetSumWays();
        System.out.println(obj.findTargetSumWays(nums, target));
    }

}
