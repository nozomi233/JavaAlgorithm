package class01.copy;

/**
 * 在一个有序数组中，找某个数是否存在
 * @Author zhulang
 * @Date 2023-04-07
 **/
public class BSExist {

    public static boolean exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0){
            return false;
        }
        int L = 0;
        int R = sortedArr.length - 1;
        int mid = 0;
        while (L < R){
            mid = L + ((R - L) >> 1);
            if (sortedArr[mid] < num){
                L = mid + 1;
            } else if (sortedArr[mid] > num){
                R = mid - 1;
            } else {
                return true;
            }
        }
        return sortedArr[L] == num;
    }
}
