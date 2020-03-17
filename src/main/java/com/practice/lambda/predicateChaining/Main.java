package com.practice.lambda.predicateChaining;

public class Main {

    public static void main(String[] args) {

        MyPredicate<String> myPredicate1 = s -> s.length() > 10;
        MyPredicate<String> myPredicate2 = s -> s.length() < 20;

        MyPredicate<String> myPredicate3 = myPredicate1.and(myPredicate2);

        System.out.println(myPredicate3.test("Hi"));
        System.out.println(myPredicate3.test("Hi How are you"));
        System.out.println(myPredicate3.test("Hi How are you, I am fine"));
    }
}
