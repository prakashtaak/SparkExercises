package com.spark.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TrieExercises {

    Trie root;

    TrieExercises() {
        this.root = new Trie(new HashMap<>(), false);
    }

    public static void main(String[] args) {


        String str1 = "peter", str2 = "pet", str3 = "kumar";
        TrieExercises trieExercises = new TrieExercises();
        trieExercises.insert(str1, str2, str3);
        trieExercises.displayTrie();


    }


    Trie insertStringToTrie(String str, Trie node) {
        Trie newTrie = new Trie(new HashMap<Character, Trie>(), false);
        if (str.length() == 0){
            node.isEndOfString=true;
            return node;
        }
        Character ch= str.charAt(0);
        if (node.mapOfChars.containsKey(ch)) {

            newTrie =  node.mapOfChars.get(ch);
       //  return    insertStringToTrie(str.substring(1), node.mapOfChars.get(str.charAt(0)));
        }else{
            node.mapOfChars.put(str.charAt(0),newTrie);
          //return   insertStringToTrie(str.substring(1),newTrie);
        }

        return    insertStringToTrie(str.substring(1), newTrie);
    }

    void insert(String... words) {
        Arrays.stream(words).forEach(word -> {
            insertStringToTrie(word, root);
        });
    }

    void displayTrie() {

        for (Map.Entry<Character, Trie> entry : root.mapOfChars.entrySet()) {

            System.out.print(entry.getKey());
            displayTrie(entry.getValue());
            System.out.println();

        }
    }

    void displayTrie(Trie trie) {

        if (trie.isEndOfString) {
            System.out.print("|");

        }
        for (Map.Entry<Character, Trie> entry : trie.mapOfChars.entrySet()) {

            System.out.print(entry.getKey());
            displayTrie(entry.getValue());


        }

    }


}

class Trie {
    Map<Character, Trie> mapOfChars;
    boolean isEndOfString = false;

    public Trie(Map<Character, Trie> mapOfChars, boolean isEndOfString) {
        this.mapOfChars = mapOfChars;
        this.isEndOfString = isEndOfString;
    }
}