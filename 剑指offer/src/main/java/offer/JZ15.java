package offer;

public class JZ15 {
    public int NumberOf1 (int n) {
        // write code here
        int res = 0;
        //遍历32位
        for (int i = 0; i < 32; i++) {
            //按位比较
            if ((n & (1 << i)) != 0)
                res++;
        }
        return res;
    }
}
