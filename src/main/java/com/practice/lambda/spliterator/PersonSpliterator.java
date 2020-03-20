package com.practice.lambda.spliterator;

import java.util.Spliterator;
import java.util.function.Consumer;

public class PersonSpliterator implements Spliterator<Person> {

    private Spliterator<String> lineSpliterator;
    private String name;
    private int age;
    private String country;

    public PersonSpliterator(Spliterator<String> stringSpliterator) {
        this.lineSpliterator = stringSpliterator;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Person> action) {

        if (lineSpliterator.tryAdvance(line -> this.name = line) &&
                lineSpliterator.tryAdvance(line -> this.age = Integer.parseInt(line)) &&
                lineSpliterator.tryAdvance(line -> this.country = line)) {

            Person person = new Person(name, age, country);

            action.accept(person);

            return true;
        }

        return false;
    }

    @Override
    public Spliterator<Person> trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        return lineSpliterator.estimateSize() / 3;
    }

    @Override
    public int characteristics() {
        return lineSpliterator.characteristics();
    }
}
