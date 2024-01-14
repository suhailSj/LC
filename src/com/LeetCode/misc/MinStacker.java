package com.LeetCode.misc;

import java.util.LinkedList;
import java.util.Stack;

public class MinStacker {

    public static void main(String... a){
        MinStack stack = new MinStack();
    }

    static class MinStack {

        /** initialize your data structure here. */
        LinkedList<Integer> list;
        Stack<Integer> stack;
        public MinStack() {
            list = new LinkedList<>();
            stack = new Stack<>();
        }

        public void push(int x) {
            list.add(x);
            if(stack.isEmpty()) {
                stack.push(x);
            } else{
                if(stack.peek()> x){
                    stack.push(x);
                }
            }
        }

        public void pop() {
            int x = list.removeLast();
            if(stack.peek() == x) {
                stack.pop();
            }
        }

        public int top() {
            return list.getLast();
        }

        public int getMin() {
            if(!stack.isEmpty()) {
                return stack.peek();
            }
            return 0;
        }
    }

}
