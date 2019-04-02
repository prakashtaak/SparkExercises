package com.spark.example;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {

        try {
            for (int i = 0; i < 15; i++) {


                if (i == 7) {
                    throw new Exception("fsdfds");
                }
                System.out.println("value i "+i);
            }
        }
        catch (Exception e){

        }
        StringBuilder ananlyticsVariableLogLine = new StringBuilder();
        System.out.println(ananlyticsVariableLogLine.length() > 0);
    }
}
