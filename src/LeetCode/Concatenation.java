package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Concatenation {
    public static void main(String... a) {
        Concatenation.Solution sol = new Concatenation.Solution();
        sol.findSubstring(null, null);
    }

    public static class Solution{
        public List<Integer> findSubstring(String s, String[] words) {
            HashMap<String, Integer> map = new HashMap<>(words.length);
            for(String str: words) {
                if(map.containsKey(str)) {
                    map.put(str, map.get(str)+1);
                } else{
                    map.put(str, 1);
                }
            }

            int len = 0;
            if(words != null) {
                len = words[0].length();
            }
            int maxIndex = len;
            HashMap<String, Integer> tmpMap = new HashMap<>(words.length);
            tmpMap.putAll(map);
            List<Integer> list = new ArrayList<>();
            int index = 0;
            while(s.length() != 0 && s.length() > maxIndex) {
                    if(tmpMap.containsKey(s.substring(index, maxIndex))) {
                        if(tmpMap.get(s.substring(0,maxIndex)) != 1) {
                            tmpMap.put(s.substring(0,maxIndex), tmpMap.get(s.substring(0,maxIndex)) -1);
                        } else {
                            tmpMap.remove(s.substring(0, maxIndex));
                        }
                    } else{
                        if(tmpMap.size() ==0) {
                            list.add(index);
                        }
                        index = maxIndex;
                        tmpMap.clear();
                        tmpMap.putAll(map);
                    }
                    maxIndex = maxIndex+len;

            }
            return null;
        }
    }
}
