package LeetCode;

import java.util.HashMap;
import java.util.Stack;

public class BalanceParanthesis {
    public static void main(String... a) {
        Solution sol = new Solution();
        sol.isValid("{}[]}");
    }
    public static class Solution{
        public boolean isValid(String s) {
            HashMap<Character, Character> map = new HashMap<>();
            map.put('{','}');
            map.put('(',')');
            map.put('[',']');
            Stack<Character> stack = new Stack();
            for(char ch: s.toCharArray()) {
                if(map.containsKey(ch)) {
                    stack.push(ch);
                }else {
                    if(!stack.isEmpty()){
                        char pop = stack.pop();
                        if(map.get(pop) != ch) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }
            if(stack.isEmpty())
                return true;
            else
                return false;
        }
    }
}
