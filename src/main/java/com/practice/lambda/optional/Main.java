package com.practice.lambda.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Random rd = new Random();

        List<Double> doubles = new ArrayList<>();

        for (int i = 0; i < 10; i++)
            doubles.add(rd.nextDouble());

        // adding null , Zero and negative values
        doubles.add(-313d);
        doubles.add(0d);
        doubles.add(null);

        System.out.println("Input Size "+doubles.size());
        System.out.println(doubles);

        Function<Double, Stream<Double>> sqrtInv = d -> NewMath.sqrt(d) // Optional<Double>
                .flatMap(NewMath::inv) // Optional<Double>
                .map(Stream::of) // Optional<Stream<Double>>
                .orElseGet(Stream::empty); //Stream<Double>

        List<Double> finalList = doubles.stream()
                .unordered()
                .parallel()
                .flatMap(sqrtInv)
                .collect(Collectors.toList());

        System.out.println("Output Size "+finalList.size());
        System.out.println(finalList);
    }
}
