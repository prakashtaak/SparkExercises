package com.spark.example;

import java.util.PriorityQueue;
import java.util.Queue;

public class NonAdjacentCharacterInString {

    public static void main(String[] args) {
        String s1="aaabca";



        Queue<Pair> charQueue=new PriorityQueue<>();
        int[] counts =new int[26];


        for (char c : s1.toCharArray()) {
            counts[c - 'a']++;
        }

        for (int i='a';i<'z';i++) {
            if(counts[i - 'a']>0){
                charQueue.add(new Pair((char)i,counts[i-'a']));
            }
        }
        Pair prev=new Pair('$',0);
        String result ="";
        while(!charQueue.isEmpty()){

            Pair topMaxChar = charQueue.peek();
            charQueue.poll();
            result+=topMaxChar.ch;

            if(prev.count > 0){
                charQueue.add(prev);
            }

            topMaxChar.count--;
            prev =topMaxChar;

        }

        if(result.length()==s1.length()) System.out.println(result); else System.out.println("Invalid");

    }
}
class Pair implements Comparable<Pair>{
    char ch;
    int count;

    public Pair(char ch, int count) {
        this.ch = ch;
        this.count = count;
    }


    @Override
    public int compareTo(Pair o) {
        return o.count - this.count;
    }
}