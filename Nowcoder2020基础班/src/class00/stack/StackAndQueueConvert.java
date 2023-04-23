package class00.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author zhulang
 * @Date 2023-04-23
 **/
public class StackAndQueueConvert {
    public static class TwoStackQueue{
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public TwoStackQueue() {
            this.stackPush = new Stack<>();
            this.stackPop = new Stack<>();
        }

        public int pop(){
            if (!stackPop.isEmpty()) {
                return stackPop.pop();
            }
            if (stackPush.isEmpty()){
                return -1;
            }
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
            return stackPop.pop();
        }

        public void push(Integer i){
            stackPush.push(i);
        }
    }

    public static class TwoQueueStack{
        private Queue<Integer> queueOne;
        private Queue<Integer> queueTwo;

        public TwoQueueStack(){
            queueOne = new LinkedList<>();
            queueTwo = new LinkedList<>();
        }

        public void add(int i){
            if (!queueOne.isEmpty()){
                queueOne.add(i);
            } else {
                queueTwo.add(i);
            }
        }

        public int remove(){

            if (queueOne.isEmpty()){
                while (!queueTwo.isEmpty()){
                    Integer i = queueTwo.poll();
                    if (queueTwo.isEmpty()){
                        return i;
                    }
                    queueOne.add(i);
                }
            }
            if (queueTwo.isEmpty()){
                while (!queueOne.isEmpty()){
                    Integer i = queueTwo.poll();
                    if (queueOne.isEmpty()){
                        return i;
                    }
                    queueTwo.add(i);
                }
            }
            return -1;
        }
    }

    /**
     * LeetCode版，两队列实现优秀
     */
    public static class MyStack{
        Queue<Integer> queue1;
        Queue<Integer> queue2;

        /** Initialize your data structure here. */
        public MyStack() {
            queue1 = new LinkedList<Integer>();
            queue2 = new LinkedList<Integer>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue2.offer(x);
            while (!queue1.isEmpty()) {
                queue2.offer(queue1.poll());
            }
            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue1.poll();
        }

        /** Get the top element. */
        public int top() {
            return queue1.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue1.isEmpty();
        }

    }

    /**
     * 一队列实现
     */
    class MyStack2 {
        Queue<Integer> queue;

        /** Initialize your data structure here. */
        public MyStack2() {
            queue = new LinkedList<Integer>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            int n = queue.size();
            queue.offer(x);
            for (int i = 0; i < n; i++) {
                queue.offer(queue.poll());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue.poll();
        }

        /** Get the top element. */
        public int top() {
            return queue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

}
