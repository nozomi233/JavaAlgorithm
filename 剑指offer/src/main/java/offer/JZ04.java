package offer;

import java.util.Objects;

public class JZ04 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @return string字符串
     */
    public String replaceSpace (String s) {
        // write code here
        return s.replace(" ", "%20");
    }

    public String replaceSpace2 (String s) {
        // write code here
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (Character c : chars){
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
