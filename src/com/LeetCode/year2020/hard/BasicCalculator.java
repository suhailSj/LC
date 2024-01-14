package com.LeetCode.year2020.hard;

/**
 * created by suhail.jahangir on 05/10/20
 */

import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 *
 * Example 1:
 *
 * Input: "1 + 1"
 * Output: 2
 * Example 2:
 *
 * Input: " 2-1 + 2 "
 * Output: 3
 * Example 3:
 *
 * Input: "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 */
public class BasicCalculator {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.calculate("1 + 1"));
//        System.out.println(solution.calculate(" 2-1 + 2 "));
//        System.out.println(solution.calculate("(1+(4+5+2)-3)+(6+8)"));
//        System.out.println(solution.calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(solution.calculate("(7)-(0)+(4)"));
    }
    static class Solution {

        static class Dummy{
            public int val;
            public char ch;
            public boolean isDigit;

            public Dummy(int val, char ch, boolean isDigit) {
                this.val = val;
                this.ch = ch;
                this.isDigit = isDigit;
            }
        }
        public int calculate(String s) {
            Stack<Dummy> stack= new Stack<>();
            Integer ans = 0;
            int multiplier = 1;
            int number =0;
            boolean num = false;
            for(int i = s.length()-1; i >=0; i--) {
                char ch = s.charAt(i);
                if(ch == ' '){
                    if(num){
                        stack.push(new Dummy(number, 'a', true));
                        number = 0;
                        multiplier =1;
                        num = false;
                    }
                    continue;
                }if(ch ==')' || ch == '+' || ch == '-'){
                    if(num){
                        stack.push(new Dummy(number, 'a', true));
                        number = 0;
                        multiplier =1;
                        num = false;
                    }
                    stack.push(new Dummy(0,ch, false));
                    continue;
                }
                if(ch == '('){
                    if(num){
                        stack.push(new Dummy(number, 'a', true));
                        number = 0;
                        multiplier =1;
                        num = false;
                    }
                    ans = processStack(stack);
                    stack.push(new Dummy(ans, 'o', true));
                    ans = 0;
                }else{
                    number = ((int)(ch -'0'))*multiplier + number;
                    multiplier *=10;
                    num = true;
                }
            }
            if(num){
                stack.push(new Dummy(number, 'a', true));
                number = 0;
                multiplier =1;
            }
            ans += processStack(stack);
            return ans;
        }

        private Integer processStack(Stack<Dummy> stack) {
            int ans = 0;
            while (!stack.isEmpty()){
                Dummy o = stack.pop();
                if(!o.isDigit){
                    if( o.ch == '+'){
                        ans += stack.pop().val;
                        continue;
                    }
                    if(o.ch == '-'){
                        ans -= stack.pop().val;
                        continue;
                    }
                    if( o.ch == ')'){
                        return ans;
                    }
                } else{
                    ans =  o.val;
                }
            }
            return ans;
        }
    }
}
