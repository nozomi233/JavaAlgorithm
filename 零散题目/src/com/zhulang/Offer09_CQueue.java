package com.zhulang;

import java.util.LinkedList;

/**
 * @Author zhulang
 * @Date 2022-12-19
 **/
public class Offer09_CQueue {
    static class CQueue {
        LinkedList<Integer> stack1, stack2;
        public CQueue() {
            stack1 = new LinkedList<>();
            stack2 = new LinkedList<>();
        }

        public void appendTail(int value) {
            stack1.add(value);
        }

        public int deleteHead() {
            if(!stack2.isEmpty()){
                return stack2.removeLast();
            }
            if(!stack1.isEmpty()){
                while (!stack1.isEmpty()){
                    stack2.add(stack1.removeLast());
                }
                return stack2.removeLast();
            }
            return -1;
        }
    }

    // LinkedList
    // add:boolean = addLast:void, pop:E = remove:E =  removeFirst:E 移除第一个元素, removeLast:E 移除最后一个元素

}
