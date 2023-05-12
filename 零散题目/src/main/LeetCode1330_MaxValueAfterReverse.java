package main;

/**
 * @Author zhulang
 * @Date 2023-05-12
 **/
public class LeetCode1330_MaxValueAfterReverse {
    /**
     * O(n^2) , 超时
     * @param nums
     * @return
     */
    public static int maxValueAfterReverse(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++){
            res += Math.abs(nums[i + 1] - nums[i]);
        }

        int init = res;

        int gap = 0;

        for (int i = 0; i < nums.length - 1; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (i == 0 && j < nums.length - 1){
                    gap = Math.abs(nums[j + 1] - nums[i]) - Math.abs(nums[j + 1] - nums[j]);
                } else if (j == nums.length - 1 && i > 0){
                    gap = Math.abs(nums[j] - nums[i - 1]) - Math.abs(nums[i] - nums[i - 1]);
                } else if (i == 0 && j == nums.length - 1){
                    gap = 0;
                } else {
                    gap = Math.abs(nums[j + 1] - nums[i]) + Math.abs(nums[j] - nums[i - 1]) - (Math.abs(nums[i] - nums[i - 1]) + Math.abs(nums[j + 1] - nums[j]));
                }
                res = Math.max(res, init + gap);
            }
        }
        return res;
    }
    public int maxValueAfterReverse2(int[] nums) {
        int value = 0, n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            value += Math.abs(nums[i] - nums[i + 1]);
        }
        int mx1 = 0;
        for (int i = 1; i < n - 1; i++) {
            mx1 = Math.max(mx1, Math.abs(nums[0] - nums[i + 1]) - Math.abs(nums[i] - nums[i + 1]));
            mx1 = Math.max(mx1, Math.abs(nums[n - 1] - nums[i - 1]) - Math.abs(nums[i] - nums[i - 1]));
        }
        int mx2 = Integer.MIN_VALUE, mn2 = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int x = nums[i], y = nums[i + 1];
            mx2 = Math.max(mx2, Math.min(x, y));
            mn2 = Math.min(mn2, Math.max(x, y));
        }
        return value + Math.max(mx1, 2 * (mx2 - mn2));
    }



    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,5,4};
        System.out.println(maxValueAfterReverse(nums));
    }
}
