package LeetCode.august;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * created by suhail.jahangir on 19/08/20
 */
public class GoatLatin {

    static class Solution {
        StringBuilder a = null;
        public String toGoatLatin(String str) {
            HashSet<Character> set = new HashSet<>();
            set.add('a');
            set.add('e');
            set.add('i');
            set.add('o');
            set.add('u');
            set.add('A');
            set.add('E');
            set.add('I');
            set.add('O');
            set.add('U');
            a = new StringBuilder();
            String[] arr = str.split(" ");
//            StringBuilder sb = new StringBuilder();
            return Arrays.stream(arr)
                    .map(st -> {
                        if(set.contains(st.charAt(0))){
                            return attachMa(st,'\0');
                        } else{
                            return attachMa(st.substring(1), st.charAt(0));
                        }
                    }).collect(Collectors.joining(" "));

        }

        private String attachMa(String substring, char charAt) {
            a.append("a");
            return substring+charAt+a.toString();

        }
    }
}
