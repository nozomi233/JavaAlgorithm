package offer;

public class JZ16 {
    public double Power(double base, int exponent) {
        double res = base;
        if (exponent > 0) {
            for (int i = 0; i < exponent - 1; i++) {
                res *= base;
            }
        } else if (exponent == 0) {
            res = 1;
        } else {
            for (int i = 0; i < (-exponent) - 1; i++) {
                res *= base;

            }
            res = 1 / res;
        }

        return res;
    }
}
