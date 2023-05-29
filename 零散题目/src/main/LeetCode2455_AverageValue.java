package main;

/**
 * @Author zhulang
 * @Date 2023-05-29
 **/
public class LeetCode2455_AverageValue {

    public int averageValue(int[] nums) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] % 2 == 0 && nums[i] % 3 == 0){
                sum += nums[i];
                count += 1;
            }
        }

        return sum / count;
    }
}
