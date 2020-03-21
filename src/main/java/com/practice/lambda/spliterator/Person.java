package com.practice.lambda.spliterator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@AllArgsConstructor
@Getter
public class Person implements Serializable {
    private String name;
    private int age;
    private String country;
}
