package com.spark.example;

import java.util.LinkedList;
import java.util.Queue;

public class StringPermutationIterative {

    static Queue<PermutaionData> queue = new LinkedList<>();

    public static void main(String[] args) {
        permute("abcd");
    }

    static void permute(String str) {
        queue.add(new PermutaionData(str, ""));
        while (!queue.isEmpty()) {

            PermutaionData data = queue.poll();

            String remaninfStr = data.remainingChars.charAt(0) + data.doneChars;
            if (remaninfStr.length() == str.length()) {
                System.out.println(remaninfStr);
                continue;

            }
            for (int i = 0; i < data.remainingChars.length(); i++) {
                String leftChars = data.remainingChars.substring(0, i) + data.remainingChars.substring(i + 1, data.remainingChars.length());

                queue.add(new PermutaionData(leftChars, data.remainingChars.charAt(i) + data.doneChars));
            }
        }

    }
}

class PermutaionData {
    String remainingChars;
    String doneChars;

    public PermutaionData(String remainingChars, String doneChars) {
        this.remainingChars = remainingChars;
        this.doneChars = doneChars;
    }

}
