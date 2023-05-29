package main.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhulang
 * @Date 2023-04-14
 **/
public class LeetCode1023_CamelMatch {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        for (String query : queries){
            res.add(match(query, pattern));
        }
        return res;
    }

    public boolean match(String query, String pattern){
        int index = 0;
        for (char c : query.toCharArray()){
            if (index == pattern.length()){
                if (c < 'a' || c > 'z'){
                    return false;
                }
            } else {
                if (c == pattern.charAt(index)){
                    index++;
                } else {
                    if (c < 'a' || c > 'z'){
                        return false;
                    }
                }
            }
        }
        return index == pattern.length();

    }
}
