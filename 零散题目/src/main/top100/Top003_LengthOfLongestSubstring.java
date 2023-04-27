package main.top100;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhulang
 * @Date 2023-04-09
 **/
public class Top003_LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        char[] str = s.toCharArray();
        int L = 0;
        int R = 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        while (R < str.length){
            if (!map.containsKey(str[R])){
                map.put(str[R], R);
                max = Math.max(R - L + 1, max) ;
                R++;
                continue;
            }
            int i = map.get(str[R]);
            while (L <= i){
                map.remove(str[L]);
                L++;
            }
            map.put(str[R], R);
            R++;
        }

        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s.length()==0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }


    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
