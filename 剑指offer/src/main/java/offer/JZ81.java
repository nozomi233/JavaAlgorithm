package offer;

/**
 * @Author Nozomi
 * @Date 2024/4/26 10:10
 */

public class JZ81 {
    public int[] reOrderArrayTwo (int[] array) {
        // write code here
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            while (left <= right && array[left] % 2 == 1) {
                left++;
            }
            while (left <= right && array[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
        return array;
    }
}
