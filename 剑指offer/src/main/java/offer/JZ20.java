package offer;

public class JZ20 {
    //遍历字符串的下标
    private int index = 0;
    //有符号判断
    private boolean integer(String s){
        if(index < s.length() && (s.charAt(index) == '-' || s.charAt(index) == '+'))
            index++;
        return unsigned_integer(s);
    }
    //无符号数判断
    private boolean unsigned_integer(String s){
        int temp = index;
        while(index < s.length() && (s.charAt(index) >= '0' && s.charAt(index) <= '9')) {
            index++;
        }
        return index > temp;
    }
    public boolean isNumeric (String str) {
        //先判断空串
        if(str == null || str.isEmpty())
            return false;
        //去除前面的空格
        while(index < str.length() && str.charAt(index) == ' ') {
            index++;
        }
        int n = str.length() - 1;
        //去除字符串后面的空格
        while(n >= 0 && str.charAt(n) == ' ') {
            n--;
        }
        //限制的长度比下标1
        n++;
        //全是空格情况
        if(n < index)
            return false;
        //判断前面的字符是否是有符号的整数
        boolean flag = integer(str);
        //如果有小数点
        if(index < n && str.charAt(index) == '.'){
            index++;
            //小数点前后有无数字可选
            flag = unsigned_integer(str) || flag;
        }
        //如果有e
        if(index < n && (str.charAt(index) == 'e' || str.charAt(index) == 'E')){
            index++;
            //e后面必须全是整数
            flag = flag && integer(str);
        }
        //是否字符串遍历结束
        return flag && (index == n);
    }
}
