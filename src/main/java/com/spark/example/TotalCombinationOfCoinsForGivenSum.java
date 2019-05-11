package com.spark.example;

import org.apache.hadoop.util.hash.Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TotalCombinationOfCoinsForGivenSum {


    public static void main(String[] args) {

     /*   int[] arr={1,3,5,2};
    System.out.println(coinCombo(arr,0,5));*/

        int[] arr={};

        Arrays.stream(solution(arr,2)).forEach(System.out::print);

    }


    static int coinCombo(int[] coins,int coinIndex,int sum){

        if(sum==0){
            return 1;
        }
        if(sum < 0 || coinIndex == coins.length){
            return 0;
        }
        int count=0;
        /*for(int i=coinIndex;i<coins.length;i++){

            count += coinCombo(coins,i,sum-coins[i]);
        }*/

        return coinCombo(coins,coinIndex,sum-coins[coinIndex]) + coinCombo(coins,coinIndex+1,sum);

    }



    static int solution(int N){

        int maxZeroLen =0,tempResult=0;
        int lastRem=0;
        while(N!=0){
            int rem = N % 2;

           lastRem = rem + lastRem;
           if(lastRem==1 && rem==0){
               tempResult++;

           }else{
               if(tempResult >maxZeroLen) maxZeroLen=tempResult;
               tempResult=0;
               lastRem=1;
           }
            N=N/2;


        }
return maxZeroLen;


        }


    static  int nonPairNo(int[] arr){



                int result =0;
                for(int element:arr){
                    result ^= element;
                }

                return result;

        }


    public static int[] solution(int[] A, int K) {

        if(A==null || A.length ==0) return A;
        int prev=0;
        for(int i=1;i<=K;i++){
            prev =A[0];
            A[0] = A[A.length-1];

            for(int j=1;j<A.length;j++){
                int temp =A[j];
                A[j]= prev;
                prev = temp;
            }


        }
        return A;
    }



}
