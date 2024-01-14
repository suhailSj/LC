package com.LeetCode.year2020.november;

/**
 * created by suhail.jahangir on 22/11/20
 */

import java.util.HashSet;

/**
 * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
 *
 * For convenience, the full table for the 26 letters of the English alphabet is given below:
 *
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cab" can be written as "-.-..--...", (which is the concatenation "-.-." + ".-" + "-..."). We'll call such a concatenation, the transformation of a word.
 *
 * Return the number of different transformations among all words we have.
 */
public class UniqueMorseCode {

    static class Solution {
        public int uniqueMorseRepresentations(String[] words) {
            String[] arr = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
            HashSet<String> set = new HashSet<>(words.length);
            StringBuilder sb = new StringBuilder();
            for(String str : words){
                sb = new StringBuilder();
                for(char ch : str.toCharArray()){
                    sb.append(arr[ch - 'a']);
                }
                set.add(sb.toString());
            }
            return set.size();
        }
    }
}
