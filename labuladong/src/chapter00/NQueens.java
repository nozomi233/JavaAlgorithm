package chapter00;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhulang
 * @Date 2023-04-28
 **/
public class NQueens {

    public static int count;
    public static int[] record;

    public static int nQueens(int n){
        count = 0;
        record = new int[n];

        backtrack(0, n, record);
        return count;
    }


    public static void backtrack(int i, int n, int[] record){
        // if 满足结束条件 ,假设做10次选择后结束
        if (i == n){
            count++;
            return;
        }

        // for 选择 in 选择列表
        for (int j = 0; j < n; j++){
            if (isValid(i, j, record)){
                record[i] = j;
                backtrack(i + 1, n, record);
                record[i] = 0;
            }
        }
    }

    public static int nQueens1(int n){
        int[] record = new int[n];
        return process(0, n, record);
    }

    public static int process(int i, int n, int[] record){
        if (i == n){
            return 1;
        }

        int res = 0;
        for (int j = 0; j < n; j++){
            if (isValid(i, j, record)){
                record[i] = j;
                res += process(i + 1,  n, record);
            }
        }
        return res;
    }

    private static boolean isValid(int i, int j, int[] record){
        for (int k = 0; k < i; k++){
            if (record[k] == j || Math.abs(record[k] - j) == Math.abs(i - k)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(nQueens1(8));
        System.out.println(nQueens(8));
    }
}
