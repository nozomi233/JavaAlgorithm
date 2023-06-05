package main.leetcode;

/**
 * @Author zhulang
 * @Date 2023-06-05
 **/
public class LeetCode2460_ApplyOperations {
    public int[] applyOperations(int[] nums) {
        int[] res = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] != 0){
                if (nums[i] == nums[i + 1]){
                    nums[i] = 2 * nums[i];
                    nums[i + 1] = 0;
                }
                res[index++] = nums[i];
            }

        }
        if (nums[nums.length - 1] != 0){
            res[index] = nums[nums.length - 1];
        }
        return res;
    }



    public int[] applyOperations2(int[] nums) {
        int n = nums.length;
        for (int i = 0, j = 0; i < n; i++) {
            if (i + 1 < n && nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
            if (nums[i] != 0) {
                swap(nums, i, j);
                j++;
            }
        }
        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,1,1,0};
        LeetCode2460_ApplyOperations l = new LeetCode2460_ApplyOperations();
        int[] res = l.applyOperations(nums);
        for (int i : res){
            System.out.println(i);
        }
    }
}
