package com.practice.lambda.collector;

import com.practice.lambda.spliterator.Person;
import com.practice.lambda.spliterator.PersonSpliterator;

import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Main {

    public static void main(String[] args) throws URISyntaxException {

        String uri = Paths.get(ClassLoader.getSystemResource("Person.txt").toURI()).toString();

        try{
            
            List<Person> personList = StreamSupport
                    .stream(new PersonSpliterator(Files.lines(Paths.get(uri)).spliterator()), false)
                    .collect(Collectors.toList());
            System.out.println("Person List: "+personList);

            Set<Person> personSet = StreamSupport
                    .stream(new PersonSpliterator(Files.lines(Paths.get(uri)).spliterator()), false)
                    .collect(Collectors.toSet());
            System.out.println("Person Set: "+personSet);

            TreeSet<Person> personTreeSet = StreamSupport
                    .stream(new PersonSpliterator(Files.lines(Paths.get(uri)).spliterator()), false)
                    .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Person::getName))));
            System.out.println("Person personTreeSet: "+personTreeSet);

            HashSet<Person> personHashSet = StreamSupport
                    .stream(new PersonSpliterator(Files.lines(Paths.get(uri)).spliterator()), false)
                    .collect(Collectors.toCollection(HashSet::new));
            System.out.println("Person personHashSet: "+personHashSet);

            Map<Boolean, List<Person>> booleanListMap = StreamSupport
                    .stream(new PersonSpliterator(Files.lines(Paths.get(uri)).spliterator()), false)
                    .collect(Collectors.partitioningBy(person -> person.getAge() > 20));
            System.out.println("Person booleanListMap: "+booleanListMap);

            Map<String, List<Person>> nameListMap = StreamSupport
                    .stream(new PersonSpliterator(Files.lines(Paths.get(uri)).spliterator()), false)
                    .collect(Collectors.groupingBy(Person::getName));
            System.out.println("Person nameListMap: "+nameListMap);

            Map<String, Set<Person>> nameSetMap = StreamSupport
                    .stream(new PersonSpliterator(Files.lines(Paths.get(uri)).spliterator()), false)
                    .collect(Collectors.groupingBy(Person::getName,
                    Collectors.mapping(Function.identity(),
                            Collectors.toSet())));
            System.out.println("Person nameSetMap: "+nameSetMap);

            TreeMap<String, TreeSet<Person>> treeSetTreeMap = StreamSupport
                    .stream(new PersonSpliterator(Files.lines(Paths.get(uri)).spliterator()), false)
                    .collect(Collectors.groupingBy(Person::getName,
                            ()->new TreeMap<>(),
                    Collectors.mapping(Function.identity(),
                            Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Person::getName))))));
            System.out.println("Person treeSetTreeMap: "+treeSetTreeMap);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
