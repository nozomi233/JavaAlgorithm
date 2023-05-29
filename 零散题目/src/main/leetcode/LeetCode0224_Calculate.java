package main.leetcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author zhulang
 * @Date 2023-05-10
 **/
public class LeetCode0224_Calculate {
    public int calculate(String s) {
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++){
            list.add(s.charAt(i));
        }
        return calculate(list);

    }

    public int calculate(LinkedList<Character> list) {
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
}
