package com.practice.lambda.merging;

import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main1 {

    public static void main(String[] args) throws URISyntaxException {
        String uri1 = Paths.get(ClassLoader.getSystemResource("vocab.enron.txt").toURI()).toString();
        String uri2 = Paths.get(ClassLoader.getSystemResource("vocab.kos.txt").toURI()).toString();
        String uri3 = Paths.get(ClassLoader.getSystemResource("vocab.nips.txt").toURI()).toString();

        try (Stream<String> stream1 = Files.lines(Paths.get(uri1));
             Stream<String> stream2 = Files.lines(Paths.get(uri2));
             Stream<String> stream3 = Files.lines(Paths.get(uri3))) {

            Stream<Stream<String>> stream4 = Stream.of(stream1, stream2, stream3);

            Stream<String> flatStream = stream4.flatMap(stream -> stream);

            System.out.println("Total Distinct Words : " + flatStream.distinct().count());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
