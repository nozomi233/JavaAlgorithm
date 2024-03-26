package offer;

public class JZ11 {
    public int minNumberInRotateArray (int[] nums) {
            int l = 0;
            int r = nums.length - 1;
            while (l < r){
                int mid = l + ((r - l) >> 1);
                if (nums[mid] > nums[r]){
                    l = mid + 1;
                } else if (nums[mid] == nums[r]){
                    r--;
                } else {
                    r = mid;
                }
            }
            return nums[l];
    }
}
