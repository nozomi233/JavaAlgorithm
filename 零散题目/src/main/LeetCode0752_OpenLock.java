package main;

import java.util.*;

/**
 * @Author zhulang
 * @Date 2023-05-04
 **/
public class LeetCode0752_OpenLock {
    static class Solution {
        public int openLock(String[] deadends, String target) {
            String start = "0000";
            // 将deadends初始化放入set，永远走不到
            Set<String> deadendSet = new HashSet<>(Arrays.asList(deadends));
            if (deadendSet.contains(start)) {
                return -1;
            }
            if (start.equals(target)) {
                return 0;
            }
            Queue<String> queue = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            queue.offer(start);
            visited.add(start);
            int step = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String cur = queue.poll();
                    if (deadendSet.contains(cur)){
                        continue;
                    }
                    if (cur.equals(target)) {
                        return step;
                    }

                    for (int j = 0; j < 4; j++) {
                        String up = plusOne(cur, j);
                        if (!visited.contains(up)){
                            queue.offer(up);
                            visited.add(up);
                        }
                        String down = minusOne(cur, j);
                        if (!visited.contains(down)){
                            queue.offer(down);
                            visited.add(down);
                        }
                    }
                }
                step += 1;
            }
            System.out.println(step);
            return -1;
        }

        /**
         * 字符串s中第 j 位 + 1
         *
         * @param s
         * @param j
         * @return
         */
        private static String plusOne(String s, int j) {
            char[] str = s.toCharArray();
            if (str[j] == '9') {
                str[j] = '0';
            } else {
                str[j] += 1;
            }
            return new String(str);
        }

        /**
         * 字符串s中第 j 位 - 1
         *
         * @param s
         * @param j
         * @return
         */
        private String minusOne(String s, int j) {
            char[] str = s.toCharArray();
            if (str[j] == '0') {
                str[j] = '9';
            } else {
                str[j] -= 1;
            }
            return new String(str);
        }
    }
}
