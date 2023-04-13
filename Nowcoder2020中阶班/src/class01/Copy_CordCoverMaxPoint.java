package class01;

/**
 * @Author zhulang
 * @Date 2023-03-28
 **/
public class Copy_CordCoverMaxPoint {
    public static int maxPoint1(int[] arr, int L) {
        int left = 0;
        int right = 0;
        int max = 0;
        int N = arr.length;
        while (left < N){
            while (right < N && arr[right] - arr[left] <= L){
                right++;
            }
            max = Math.max(max, right - (left++));
        }
        return max;

    }
}
