package com.practice.lambda.merging;

import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main2 {
    public static void main(String[] args) throws URISyntaxException {

        String uri1 = Paths.get(ClassLoader.getSystemResource("Docker Notes.txt").toURI()).toString();
        String uri2 = Paths.get(ClassLoader.getSystemResource("Spring Security Notes.txt").toURI()).toString();

        try (Stream<String> stream1 = Files.lines(Paths.get(uri1));
             Stream<String> stream2 = Files.lines(Paths.get(uri2))) {

            Stream<Stream<String>> stream4 = Stream.of(stream1, stream2);

            Stream<String> streamLines = stream4.flatMap(stream -> stream);

            Stream<String> wordStream = streamLines.flatMap(line -> Stream.of(line.split(" ")));

            wordStream.distinct().forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
