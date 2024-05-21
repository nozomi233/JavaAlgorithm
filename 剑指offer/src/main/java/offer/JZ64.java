package offer;

/**
 * @Author Nozomi
 * @Date 2024/4/26 10:33
 */

public class JZ64 {
    public int Sum_Solution(int n) {
        boolean flag = (n > 1) && ((n += Sum_Solution(n - 1)) > 0);
        return n;
    }
}
