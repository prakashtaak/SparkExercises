package com.spark.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class SubSetProblem {

    Queue<Subset> queue=new LinkedList<>();
    public static void main(String[] args) {
        int no[] = {1,2,3,4};

        SubSetProblem obj=new SubSetProblem();
        obj.createSubsets(no);


    }

    void createSubsets(int[] no){
        List<Integer> initailValues = new ArrayList<>();
        Subset obj=new Subset(new IndexRange(0,no.length),initailValues);

        queue.add(obj);

        while (!queue.isEmpty()){
            Subset data = queue.poll();

           // System.out.println(no[data.processed.startI]);
            for(int i=data.remaing.startI;i<data.remaing.endI;i++){

                int newStartI = Math.min(i+1,data.remaing.endI);

                List<Integer> doanValues = new ArrayList<>(data.doneIndexes);
                doanValues.add(no[i]);
                System.out.println(doanValues.stream().map(x -> x.toString()).collect(Collectors.joining(",")));
                Subset temp=new Subset(new IndexRange(newStartI,data.remaing.endI),doanValues);
                queue.add(temp);
            }

        }

    }
}

class Subset{
    List<Integer> doneIndexes;
    IndexRange remaing;

    public Subset(IndexRange remaing, List<Integer> processed) {
        this.remaing = remaing;
        this.doneIndexes = processed;
    }
}

class IndexRange{
    int startI;
    int endI;

    public IndexRange(int startI, int endI) {
        this.startI = startI;
        this.endI = endI;
    }
}
