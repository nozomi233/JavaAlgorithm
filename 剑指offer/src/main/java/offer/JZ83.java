package offer;

/**
 * @Author Nozomi
 * @Date 2024/4/26 10:09
 */

public class JZ83 {
    private long mod = 998244353;
    //快速乘法
    private long fast(long x, long y){
        long res = 0;
        x %= mod;
        y %= mod;
        while(y != 0){
            if((y & 1L) != 0){
                //加法代替乘法，防止越界
                res += x;
                if(res >= mod)
                    res -= mod;
            }
            y = y >> 1;
            x = x << 1;
            if(x >= mod)
                x -= mod;
        }
        return res;
    }
    //快速幂
    long Pow(long x, long y){
        long res = 1;
        while(y != 0){
            //可以再往上乘一个
            if((y & 1L) != 0)
                res = fast(res, x);
            //叠加
            x = fast(x, x);
            //减少乘次数
            y = y >> 1;
        }
        return res;
    }
    public long cutRope (long number) {
        //不超过3直接计算
        if(number <= 3)
            return number - 1;
        //能整除3
        if(number % 3 == 0)
            return Pow(3, number / 3);
            //最后剩余1
        else if(number % 3 == 1)
            //4*3^{n-1}
            return fast(Pow(3, number / 3 - 1), 4);
            //最后剩余2
        else
            //2*3^n
            return fast(Pow(3, number / 3), 2);
    }
}
