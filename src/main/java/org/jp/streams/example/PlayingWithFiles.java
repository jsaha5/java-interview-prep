package org.jp.streams.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class PlayingWithFiles {
    public static void main(String[] args) {
        try {
            Stream<String> lines = Files.lines(Path.of("file.txt"));
            // print all the lines in the file
//            lines.forEach(System.out::println);

            // print all the works in the file
/*            Predicate<String> checkBlank  = String::isBlank;
            lines.peek(System.out::println)
                    .flatMap(line -> Stream.of(line.split(" ")))
                    .filter(checkBlank.negate())
                    .forEach(System.out::println);*/

            // print all the unique works

            lines.map(line-> line.split(" "))
                    .flatMap(Arrays::stream)
                    .distinct()
                    .sorted()
                    .forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
