package main.chapter01;

/**
 * @Author zhulang
 * @Date 2023-05-30
 **/
public class KMP {
    private int[][] dp;
    private String pat;

    public KMP(String pat) {
        this.pat = pat;
        // 通过 pat 构建 dp 数组
        // 需要 O(M) 时间
    }
    public int search(String txt) {
        // 借助 dp 数组去匹配 txt
        // 需要 O(N) 时间
        return 0;
    }

}


