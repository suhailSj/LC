package LeetCode.august;

import java.util.*;

/**
 * created by suhail.jahangir on 14/08/20
 */
public class combinationIterator {

    public static void main(String... a){
        CombinationIterator c = new CombinationIterator("abcdefgh",3);

    }

    static class CombinationIterator {

        public CombinationIterator(String characters, int combinationLength) {
            process(characters, 0,combinationLength,"");
            Collections.sort(set);
        }
        LinkedList<String> set = new LinkedList<>();

        private void process(String word, int start,int length, String sofar) {
            if(length == 0){
                set.add(sofar);
                return;
            }
            if(start >= word.length()){
                return;
            }

            process(word, start+1, length-1,sofar+word.charAt(start));
            process(word, start+1, length, sofar);
        }

        public String next() {
            return set.remove();
        }

        public boolean hasNext() {
            return !set.isEmpty();
        }
    }
}
