package com.LeetCode.august;

/**
 * created by suhail.jahangir on 23/08/20
 */
public class TrieImpl {


    static class StreamChecker {

        Trie root = null;
        StringBuilder sb = null;
        public StreamChecker(String[] words) {
            root = new Trie();
            sb = new StringBuilder();
            for(String str : words){
                insert(str);
            }
        }

        private void insert(String word){
            Trie curr = root;
            char ch = 'a';
            for(int i=word.length()-1; i>=0; i--){
                ch = word.charAt(i);
                if(curr.child[ch - 'a'] == null){
                    Trie t = new Trie();
                    curr.child[ch - 'a'] = t;
                }
                curr = curr.child[ch -'a'];
            }
            curr.eow = true;
        }

        public boolean query(char letter) {
            sb.append(letter);
            Trie curr = root;
            char ch = 'a';
            for(int i= sb.length()-1; i>=0; i--){
                ch = sb.charAt(i);
                if(curr.child[ch - 'a'] == null){
                    return false;
                }
                curr = curr.child[ch - 'a'];
                if(curr.eow){
                    return true;
                }
            }
            return false;
        }

         class Trie{
            Trie[] child;
            boolean eow;
            public Trie(){
                this.child = new Trie[26];
                this.eow = false;
            }
        }
    }
}
