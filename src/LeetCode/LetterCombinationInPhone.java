//package LeetCode;
//
//import java.util.*;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class LetterCombinationInPhone {
//
//    public static void main(String... a) {
//        Solution sol = new Solution();
//        sol.letterCombinations("02345");
//    }
//    public static class Solution{
//        public List<String> letterCombinations(String digits) {
//            List<String> result = new ArrayList<String>();
//            HashMap<Integer, String> mapper = new HashMap<>();
//            mapper.put(2, "abc");
//            mapper.put(3, "def");
//            mapper.put(4, "ghi");
//            mapper.put(5, "jkl");
//            mapper.put(6, "mno");
//            mapper.put(7, "pqrs");
//            mapper.put(8, "tuv");
//            mapper.put(9, "wxyz");
//
////            map.put('3', Arrays.asList('d','e','f'));
////            map.put('4', Arrays.asList('g','h','i'));
////            map.put('5', Arrays.asList('j','k','l'));
////            map.put('6', Arrays.asList('m','n','o'));
////            map.put('7', Arrays.asList('p','q','r', 's'));
////            map.put('8', Arrays.asList('t','u','v'));
////            map.put('9', Arrays.asList('w','x','y', 'z'));
////            map.put('0', Arrays.asList('\0'));
////            map.put('1', Arrays.asList('\0'));
////            char[] arr = { "Geeks", "for", "Geeks" };
////
////            // Using Arrays.stream() to convert
////            // array into Stream
////            Stream<String> stream = Arrays.stream(arr);
////            String str;
////            char[] ch = digits.toCharArray();;
////            Arrays.stream(ch)
////                    .map(digit -> map.get(digit))
////                    .
////            for(char ch : digits.toCharArray()) {
////
////            }
//            List<String> ans = new LinkedList<>();
//            for(char ch :digits.toCharArray()) {
//                int num  = (int)ch - 48;
//                for(char alpha: mapper.get(num).toCharArray()) {
//                    List<String> temp = ans;
//                    for(String str : ans) {
//                        String s = str + alpha;
//                        ans.add(s);
//                    }
//                }
//            }
//        }
//    }
//}
