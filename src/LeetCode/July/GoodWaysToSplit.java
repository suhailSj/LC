package LeetCode.July;

public class GoodWaysToSplit {

    public static void main(String... a){
        Solution sol = new Solution();
        System.out.println(sol.numSplits("aabbaa"));
    }

    static class Solution {
        public int numSplits(String s) {
            String first = s.substring(0,1);
            String second = s.substring(1, s.length());
            int[] start = new int[26];
            int[] end = new int[26];
            int uni=0;int endi=0;
            for(char ch:first.toCharArray()){
                start[ch-'a']++;
            }
            for(char ch:second.toCharArray()){
                end[ch-'a']++;
            }
            for(int i=0;i<26;i++){
                if(start[i] != 0){
                    uni++;
                }
                if(end[i] != 0){
                    endi++;
                }
            }
            int result =0;
            if(uni == endi){
                result++;
            }

            for(int i =1; i<s.length()-1; i++){
                char ch = s.charAt(i);
                if(start[ch-'a'] == 0){
                    uni++;
                    start[ch-'a']++;
                }
                if(end[ch-'a'] -1 == 0){
                    endi--;

                }
                end[ch-'a']--;
                if(uni == endi){
                    result++;
                }
            }
            return result;
        }
    }
}
