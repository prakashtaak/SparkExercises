package com.spark.example;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ClosureInJava {

    static List<Discount> discounts = Arrays.asList(amount -> amount.multiply(BigDecimal.valueOf(0.9)));


    static Function<Employee, String> getname = Employee::getName;

    public static void main(String[] args) {
        Discount distcount = discounts.stream().reduce(v -> v, Discount::combine);
        System.out.println(distcount.apply(BigDecimal.valueOf(1000)));
        Comparator<Employee> nameCompartor = null;

        if ("name" == "name")
            nameCompartor = Comparator.comparing(Employee::getAge);

        nameCompartor.thenComparing(Employee::getGender);


    }
}

interface Discount extends UnaryOperator<BigDecimal> {

    default Discount combine(Discount after) {
        return value -> after.apply(this.apply(value));
    }


}

class Employee {
    String name;
    int age;
    String gender;

    public Employee(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}