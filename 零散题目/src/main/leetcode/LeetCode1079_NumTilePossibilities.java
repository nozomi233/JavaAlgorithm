package main.leetcode;

import com.sun.deploy.util.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author zhulang
 * @Date 2023-05-19
 **/
public class LeetCode1079_NumTilePossibilities {
    private static final int MX = 8;
    private static final int[][] c = new int[MX][MX];

    static {
        for (int i = 0; i < MX; i++) {
            c[i][0] = c[i][i] = 1;
            for (int j = 1; j < i; j++) {
                c[i][j] = c[i - 1][j - 1] + c[i - 1][j]; // 预处理组合数
            }
        }
    }

    // 计数DP，见leetCode题解
    public int numTilePossibilities(String tiles) {
        HashMap<Character, Integer> counts = new HashMap<>();// 统计每个字母的出现次数
        for (char c : tiles.toCharArray()) {
            counts.merge(c, 1, Integer::sum); // counts[c]++
        }
        int m = counts.size(), n = tiles.length();
        int[][] f = new int[m + 1][n + 1];
        f[0][0] = 1; // 构造空序列的方案数
        int i = 1;
        for (int cnt : counts.values()) { // 枚举第 i 种字母
            for (int j = 0; j <= n; j++) // 枚举序列长度 j
            {
                for (int k = 0; k <= j && k <= cnt; k++) // 枚举第 i 种字母选了 k 个
                {
                    f[i][j] += f[i - 1][j - k] * c[j][k];
                }
            }
            i++;
        }
        int ans = 0;
        for (int j = 1; j <= n; j++) {
            ans += f[m][j];
        }
        return ans;
    }
    // dfs
    public static int numTilePossibilitiesRecur(String tiles) {
        if (tiles == null || tiles.length() == 0){
            return 0;
        }

        char[] str = tiles.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Set<String> df = new HashSet<>();
        int n = tiles.length();
        StringBuilder path = new StringBuilder();
        backTrace(map, 0, n, df, path);
//        for (String s : df){
//            System.out.println(s);
//        }
        return df.size();
    }

    public static void backTrace(Map<Character, Integer> map, int i, int n, Set<String> df, StringBuilder path){
        if (i == n + 1){
            return;
        }
        String res = path.toString();
        if (!df.contains(res) && res.length() != 0){
            df.add(res);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            if (entry.getValue() > 0){
                map.put(entry.getKey(), entry.getValue() - 1);
                path.append(entry.getKey());
                backTrace(map, i + 1, n, df, path);
                map.put(entry.getKey(), entry.getValue() + 1);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "AAABBC";
        System.out.println(numTilePossibilitiesRecur(s));
    }
}
