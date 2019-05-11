package com.spark.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{

    enum Sample{
        A1(A1.class),
        B1(B1.class);

        Class<?> someClass;
        Sample(Class<?> cls){
            this.someClass=cls;
        }



    }
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        List<Integer> ints = Arrays.asList(1,2,3,4,5);

        int result =  ints.stream().collect(Collectors.summingInt(value -> value));
      int result2 =  ints.stream().reduce(Integer::sum).get();
      System.out.println(result2);
       /* List<String> strs = Arrays.asList("abc","pqr","xyz","dfg","wer","qwe","asd","asd");
            strs.stream().reduce(String::concat);*/
      /*  Map<String,Long> countOfString = strs.stream().collect(Collectors.groupingBy(x -> x,Collectors.counting()));
        countOfString.forEach((x,y) -> System.out.println(x +" "+y));*/
        /*
        System.out.println(Sample.valueOf("A1").someClass.newInstance());
        for (Sample value : Sample.values()) {

            System.out.println(value.name());
            if (value == Sample.A1) {
                try {
                    A1 obj = (A1) Sample.A1.someClass.newInstance();
                    obj.display();
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        String remaninfStr = "abc";
        for (int i = 0; i < remaninfStr.length(); i++) {
            System.out.println(remaninfStr.substring(0, i) + remaninfStr.substring(i + 1, remaninfStr.length())+"  "+String.valueOf(remaninfStr.charAt(i)));

        }*/
    }
}
class A1{ void display(){System.out.println("A1 class");}}
class B1{ void display(){System.out.println("B1 class");}}
