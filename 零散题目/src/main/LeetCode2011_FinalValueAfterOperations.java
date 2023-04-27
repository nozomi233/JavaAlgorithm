package main;

/**
 * @Author zhulang
 * @Date 2022-12-23
 **/
public class LeetCode2011_FinalValueAfterOperations {
    static class Solution {
        public int finalValueAfterOperations(String[] operations) {
            int x = 0;
            for(String opt : operations){
                if(opt.contains("--X") || opt.contains("X--")){
                    x -= 1;
                } else {
                    x += 1;
                }
            }
            return x;
        }

        public int finalValueAfterOperations2(String[] operations) {
            int x = 0;
            for (String op : operations) {
                if ("X++".equals(op) || "++X".equals(op)) {
                    x++;
                } else {
                    x--;
                }
            }
            return x;
        }

    }
}
