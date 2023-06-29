package com.zhulang.chapter01;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author zhulang
 * @Date 2023-06-14
 **/
public class Evaluate {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) { // 读取字符，如果是运算符则压入栈
            String s = in.nextLine();
            if (s.equals("(")) {
                continue;
            } else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("sqrt")) {
                ops.push(s);
            } else if (s.equals(")")) { // 如果字符为 ")"，弹出运算符和操作数，计算结果并压入栈
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+")) {
                    v = vals.pop() + v;
                } else if (op.equals("-")) {
                    v = vals.pop() - v;
                } else if (op.equals("*")) {
                    v = vals.pop() * v;
                } else if (op.equals("/")) {
                    v = vals.pop() / v;
                } else if (op.equals("sqrt")) {
                    v = Math.sqrt(v);
                }
                vals.push(v);
            } // 如果字符既非运算符也不是括号，将它作为 double 值压入栈
            else {
                vals.push(Double.parseDouble(s));
            }
        }
        System.out.println(vals.pop());
    }
}