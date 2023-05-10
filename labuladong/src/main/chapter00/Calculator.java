package main.chapter00;

import java.util.*;

/**
 * @Author zhulang
 * @Date 2023-05-10
 **/
public class Calculator {

    /**
     * 有括号版本：这段代码和下面无括号代码完全相同，唯一的区别是，不是从左到右遍历字符串，
     * 而是不断从左边pop出字符，缩短子问题，用于递归，本质还是一样的。
     * @param s
     * @return
     */
    public static int calculate(String s) {
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++){
            list.add(s.charAt(i));
        }
        return calculate(list);

    }

    public static int calculate(LinkedList<Character> list) {
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        int sign = '+';
        while (list.size() > 0){
            Character c = list.pop();
            if (Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }

            // 遇到左括号递归
            if (c == '('){
                num = calculate(list);
            }

            if ((!Character.isDigit(c) && c != ' ') || list.size() == 0){
                switch (sign){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                sign = c;
                num = 0;
            }
            if (c == ')'){
                break;
            }
        }
        int res = 0;
        while (!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }

    /**
     * 字符串转整型
     * (c - '0')的这个括号不能省略，否则可能造成整型溢出。
     *
     * @param s
     * @return
     */
    public static int strToInt(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            num = num * 10 + (s.charAt(i) - '0');
        }
        return num;
    }

    /**
     * 只包含加减法，不包含括号，如计算 1-12+3
     *
     * @param s
     * @return
     */
    public static int plusAndMinusWithoutParenthesis(String s) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                num = num * 10 + (s.charAt(i) - '0');
            }
            // 注意，这里不能用else，否则会跳过 i == s.length() - 1 即结束数字的入栈
            // 若第一个字符为'-'时，先push num ，即0入栈，结果不变
            if (!Character.isDigit(c) || i == s.length() - 1){
                switch (sign){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                }
                sign = c;
                num = 0;
            }
        }

        int res = 0;
        while (!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }

    /**
     * 加减乘除空格，不包含括号，如计算 2 - 3 * 4 + 5
     *
     * @param s
     * @return
     */
    public static int calculateWithoutParenthesis(String s) {
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        int sign = '+';
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1){
                switch (sign){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }

                sign = c;
                num = 0;
            }
        }

        int res = 0;
        while (!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }



    public static void main(String[] args) {
//        String s = "da dwr";
//        System.out.println(s.replaceAll(" ", ""));
//        System.out.println(3 * (2 - 6 / (3 - 7)));
//        System.out.println(strToInt("458"));
//        System.out.println(plusAndMinusWithoutParenthesis("-1-12+3"));
        System.out.println(calculateWithoutParenthesis("2 - 3 * 4 + 5"));
        System.out.println(calculate("2 - 3 * 4 + 5"));
    }
}
