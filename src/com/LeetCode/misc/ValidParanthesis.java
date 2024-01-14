package com.LeetCode.misc;

import java.util.LinkedList;

public class ValidParanthesis {

    public static void main(String... a){
        Solution sol = new Solution();
        System.out.println(sol.checkValidString("******(()"));
    }

    //(()*
    static  class Solution {
        public boolean checkValidString(String s) {

            LinkedList<Integer> stack = new LinkedList<>();
            LinkedList<Integer> star = new LinkedList<>();
            int len = s.length();
            int starCount =0;
            for(int i=0; i<len; i++){
                char ch = s.charAt(i);
                if(ch =='('){
                    stack.add(i);
                } else if(ch == '*'){
                    starCount++;
                    star.add(i);
                }else{
                    if(!stack.isEmpty()){
                        stack.removeLast();
                    }else if(starCount>0){
                        star.removeLast();
                        starCount--;
                    }else{
                        return false;
                    }
                }
            }
            if(stack.isEmpty()){
                return true;
            }else {
                for(int i:stack){
                    if(star.size() >0){
                        while(!star.isEmpty()){
                            if(i<star.getFirst()){
                                star.removeFirst();
                                stack.removeFirst();
                                break;
                            } else{
                                star.removeFirst();

                            }
                        }
                    }else{
                        return false;
                    }



                }
                if(stack.isEmpty())
                return true;
                return false;
            }

        }
    }
}
