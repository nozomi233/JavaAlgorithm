package class08.copy;

/**
 * @Author zhulang
 * @Date 2023-04-24
 **/
public class NQuees {
    public static int nums1(int n){
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n];
        return process(record, 0, n);
    }

    public static int process(int[] record, int i, int n){
        if (i == n) {
            return 1;
        }

        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)){
                record[i] = j;
                res += process(record, i + 1, n);
            }
        }
        return res;
    }

    public static boolean isValid(int[] record, int i, int j){
        for (int k = 0; k < i; k++){
            if (record[k] == j || Math.abs(record[k] - j) == Math.abs(i - k)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(nums1(8));
    }
}
