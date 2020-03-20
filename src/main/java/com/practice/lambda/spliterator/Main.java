package com.practice.lambda.spliterator;

import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Main {

    public static void main(String[] args) throws URISyntaxException {

        String uri = Paths.get(ClassLoader.getSystemResource("Person.txt").toURI()).toString();

        try(Stream<String> stream = Files.lines(Paths.get(uri))){
            PersonSpliterator personSpliterator = new PersonSpliterator(stream.spliterator());

            Stream<Person> streamPerson = StreamSupport.stream(personSpliterator, false);
            streamPerson.forEach(System.out::println);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
