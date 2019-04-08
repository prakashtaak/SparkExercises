package com.spark.example;

import java.util.HashMap;
import java.util.Map;

public class TrieExercises {

    Trie root;
    TrieExercises(){
        this.root = new Trie(new HashMap<>(),false);
    }

    public static void main(String[] args) {


        String str1 = "peter", str2 = "pet", str3 = "pickoo";
        TrieExercises trieExercises=new TrieExercises();
        trieExercises.insert(str1);
        trieExercises.displayTrie();


    }

    Trie insertStringToTrie(String str,Trie node) {

        if(str.length()==0) return new Trie(null,true);
        Map<Character,Trie> nodeMap = new HashMap<Character, Trie>();

        if(node.mapOfChars.containsKey(str.charAt(0))){
          Trie trie=   node.mapOfChars.get(str.charAt(0));

        }

        Trie result =  node.mapOfChars.computeIfAbsent(str.charAt(0),(ch) -> insertStringToTrie(str.substring(1),node));
        return result;

    }

    void insert(String str){
        insertStringToTrie(str,root);

    }

    void displayTrie(){

        for(Map.Entry<Character,Trie> entry :root.mapOfChars.entrySet()){

            System.out.print(entry.getKey());
            displayTrie(entry.getValue());

        }
    }

    void displayTrie(Trie trie){

        if(trie.isEndOfString) {
            System.out.println();
            return;
        }
        for(Map.Entry<Character,Trie> entry :trie.mapOfChars.entrySet()){

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