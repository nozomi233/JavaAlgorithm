package offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author zhulang
 * @Date 2021-11-22
 **/
public class Offer09 {
    static class Solution {
        Deque<Integer> inStack;
        Deque<Integer> outStack;
        public void CQueue() {
            inStack = new ArrayDeque<Integer>();
            outStack = new ArrayDeque<Integer>();
        }

        public void appendTail(int value) {
            inStack.push(value);
        }

        public int deleteHead() {
            if (outStack.isEmpty()) {
                if (inStack.isEmpty()) {
                    return -1;
                }
                in2out();
            }
            return outStack.pop();
        }
        private void in2out() {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}
