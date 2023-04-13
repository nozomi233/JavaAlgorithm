package class01;

import java.util.Arrays;

/**
 * @Author zhulang
 * @Date 2021-11-30
 **/
public class Class01 {


    public static int maxPoint1(int[] arr, int L) {
        int res = 1;

        return res;
    }

    // for test
    public static int test(int[] arr, int L) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int pre = i - 1;
            while (pre >= 0 && arr[i] - arr[pre] <= L) {
                pre--;
            }
            max = Math.max(max, i - pre);
        }
        return max;
    }


    // for test
    public static int[] generateArray(int len, int max) {
        int[] ans = new int[(int) (Math.random() * len) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (int) (Math.random() * max);
        }
        Arrays.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        int len = 100;
        int max = 1000;
        int testTime = 100000;
        for (int i = 0; i < testTime; i++) {
            int L = (int) (Math.random() * max);
            int[] arr = generateArray(len, max);
            int ans1 = maxPoint1(arr, L);
//            int ans2 = maxPoint2(arr, L);
            int ans3 = test(arr, L);
//            if (ans1 != ans2 || ans2 != ans3) {
//                System.out.println("oops!");
//                break;
//            }
            System.out.println(ans1);
        }
    }
}
