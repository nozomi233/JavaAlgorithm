package main.chapter03;

/**
 * @Author zhulang
 * @Date 2023-06-05
 **/
public class BitOpt {
    public static void main(String[] args) {
        int a = 1, b = 2;
        a ^= b;
        b ^= a;
        a ^= b;
        System.out.println(a);
        System.out.println(b);
    }
}
