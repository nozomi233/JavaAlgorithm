package offer;

import java.util.*;

/**
 * @Author Nozomi
 * @Date 2024/4/26 11:21
 */

public class JZ75 {

    private StringBuilder s = new StringBuilder();
    private HashMap<Character, Integer> mp = new HashMap<>();
    //Insert one char from stringstream
    public void Insert(char ch) {
        //插入字符
        s.append(ch);
        //哈希表记录字符出现次数
        mp.put(ch, mp.getOrDefault(ch, 0) + 1);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        //遍历字符串
        for (int i = 0; i < s.length(); i++)
            //找到第一个出现次数为1的
            if (mp.get(s.charAt(i)) == 1)
                return s.charAt(i);
        //没有找到
        return '#';
    }

    public static void main(String[] args) {
        JZ75 j = new JZ75();
        String caseout = "";
        String s = "googgle";
        for (char c : s.toCharArray()){
            j.Insert(c);
            caseout += j.FirstAppearingOnce();
            System.out.println(caseout);
        }


    }
}
