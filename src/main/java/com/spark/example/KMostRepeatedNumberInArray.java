package com.spark.example;

import jdk.internal.util.xml.impl.Pair;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class KMostRepeatedNumberInArray {


    public static void main(String[] args) {


        int[] arr = {1, 6, 2, 2,1, 6, 3,6};
        int k=2;
        Map<Integer, Long> groupOfValues = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Integer>[] buckets=new ArrayList[arr.length+1];

        for(Integer key:groupOfValues.keySet()){

                   List<Integer> temp=new ArrayList<>();
                   temp.add(key);
                   buckets[groupOfValues.get(key).intValue()]=temp;



        }


        List<Integer> results=new ArrayList<>();
        for(int i=buckets.length-1;i > 0 && results.size() < k;i--){
            if(buckets[i]!=null)
            results.addAll(buckets[i]);
        }

        results.forEach(System.out::println);

    }

}
