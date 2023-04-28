package chapter00;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列问题， n 个不重复的数，全排列共有 n! 个。
 * @Author zhulang
 * @Date 2023-04-28
 **/
public class Permutations {
    /**
     * 打印数组的全排列
     * @param arr
     */

    private static final List<List<Integer>> res = new ArrayList<>();

    private static final List<Integer> path = new ArrayList<>();
    public static void printPermutations(int[] arr){
        dfs(arr, path);
    }

    public static void dfs(int[] arr, List<Integer> path){
        if (path.size() == arr.length){
            res.add(path);
            path.forEach(System.out::print);
            System.out.println();
        }

        for (int i : arr){
            // 需要把已加入路径的排除掉
            if (!path.contains(i)){
                path.add(i);
                dfs(arr, path);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        printPermutations(arr);
        // 为什么res 打印为6个空列表？
//        res.forEach(System.out::print);
//        System.out.println();
    }
}
