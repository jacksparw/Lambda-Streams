package com.practice.lambda.comparator;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        Person p1 = new Person(10, "A", "B");
        Person p2 = new Person(20, "X", "Y");

        Comparator<Person> compare = Comparator.comparing(Person::getAge)
                .thenComparing(Person::getFirstName)
                .thenComparing(Person::getLastName);

        System.out.println(compare.compare(p1, p2));
    }
}

