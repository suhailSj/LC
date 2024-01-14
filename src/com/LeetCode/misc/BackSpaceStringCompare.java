package com.LeetCode.misc;

public class BackSpaceStringCompare {




    static class Solution {
        public boolean backspaceCompare(String S, String T) {
            int slen = S.length();
            int tlen = T.length();
            StringBuilder sb = new StringBuilder();
            StringBuilder tb = new StringBuilder();
            char ch ='a';

            if(slen > tlen){
                loopTroughMin(S, T, tlen, sb, tb);
                for(int i= tlen;i<slen;i++){
                    ch = S.charAt(i);
                    appen(sb, ch);
                }
            }else{
                loopTroughMin(S, T, slen, sb, tb);
                for(int i= slen;i<tlen;i++){
                    ch = T.charAt(i);
                    appen(tb, ch);
                }
            }
            if(sb.toString().equals(tb.toString())){
                return true;
            }
            return false;
        }

        private void loopTroughMin(String S, String T, int tlen, StringBuilder sb, StringBuilder tb) {
            char ch;
            for(int i = 0; i<tlen; i++) {
                ch = S.charAt(i);
                appen(sb, ch);
                ch = T.charAt(i);
                appen(tb, ch);
            }
        }

        private void appen(StringBuilder sb, char ch) {
            if(ch != '#'){
                sb.append(ch);
            } else{
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
