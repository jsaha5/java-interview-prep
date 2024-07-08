package org.jp.streams.example;

import org.jp.models.Employee;
import org.jp.models.Transaction;
import org.jp.models.TransactionType;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AdvancedStreamOperation {

    //Given a list of integers, find the most frequent element. If there are multiple elements with the same highest frequency, return any one of them.
    @Test
    public void problem1() {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4);
        Map<Integer, Long> collect = numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);

        System.out.println(collect.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey());
    }

    //Given a sentence, find the longest word. If there are multiple words with the same length, return any one of them.
    @Test
    public void problem2() {
        // find the length of all distinct words
        String sentence = "The quick brown fox jumps over the lazy dog44444444";
        Arrays.stream(sentence.split(" "))
                .map(String::toLowerCase)
                .distinct()
                .collect(Collectors.toMap(Function.identity(), String::length))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(entry -> System.out.println(entry.getKey()));

        Arrays.stream(sentence.split("\\s+"))
                .max(Comparator.comparingInt(String::length))

                .ifPresent(System.out::println);

    }

    //    Given a list of lists of integers, calculate the sum of all integers.
    @Test
    public void problem3() {

        List<List<Integer>> nestedLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9),
                Arrays.asList(10)
        );

        int sum = nestedLists.stream().flatMap(Collection::stream).mapToInt(Integer::intValue).sum();
        System.out.println(sum);

    }

    // Given a list of strings, group them by their length and count the number of strings in each group":
    @Test
    public void problem4() {

        List<String> strings = Arrays.asList(
                "apple", "banana", "cherry", "date", "fig", "grape", "kiwi", "lemon", "mango"
        );
        Map<Integer, Long> collect = strings.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));

        System.out.println(collect);

    }

    //Given a list of Transaction objects, group them by type (CREDIT/DEBIT) and calculate the total amount for each type.
    @Test
    public void problem5() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("TXN001", 150.0, LocalDate.of(2023, 6, 1), TransactionType.CREDIT),
                new Transaction("TXN002", 200.0, LocalDate.of(2023, 6, 2), TransactionType.DEBIT),
                new Transaction("TXN003", 350.0, LocalDate.of(2023, 6, 3), TransactionType.CREDIT),
                new Transaction("TXN004", 50.0, LocalDate.of(2023, 6, 4), TransactionType.DEBIT),
                new Transaction("TXN005", 100.0, LocalDate.of(2023, 6, 5), TransactionType.CREDIT)
        );

        Map<TransactionType, Double> collect = transactions.stream()
                .collect(
                        Collectors.groupingBy(Transaction::type, Collectors.summingDouble(Transaction::amount))
                );

        System.out.println(collect);

    }

    //Stream partition
    @Test
    public void problem6() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("TXN001", 150.0, LocalDate.of(2023, 6, 1), TransactionType.CREDIT),
                new Transaction("TXN002", 200.0, LocalDate.of(2023, 6, 2), TransactionType.DEBIT),
                new Transaction("TXN003", 350.0, LocalDate.of(2023, 6, 3), TransactionType.CREDIT),
                new Transaction("TXN004", 50.0, LocalDate.of(2023, 6, 4), TransactionType.DEBIT),
                new Transaction("TXN005", 100.0, LocalDate.of(2023, 6, 5), TransactionType.CREDIT)
        );

        Map<Boolean, List<Transaction>> collect = transactions.stream()
                .collect(Collectors.partitioningBy(transaction -> transaction.type() == TransactionType.CREDIT));

        System.out.println(collect);

    }

    // Partitioning numbers into prime and nonprime
    @Test
    public void problem7() {
        Map<Boolean, List<Integer>> collect = IntStream.range(1, 50).boxed()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));

        System.out.println(collect);

    }

    // Given a list of integers, partition the list into even and odd numbers and calculate the sum of the numbers in each partition.
    @Test
    public void problem8() {
        Map<Boolean, Integer> collect = IntStream.range(1, 11).boxed()
                .peek(System.out::println)
                .collect(Collectors.partitioningBy(num -> num % 2 == 0, Collectors.reducing(0, (i, j) -> i + j)));

        System.out.println(collect);
    }
    //Given a list of strings, find all the elements that appear more than once.
    @Test
    public void problem9() {
        List<String> strings = Arrays.asList(
                "apple", "banana", "cherry", "date", "apple", "banana", "banana", "elderberry", "fig", "grape", "cherry"
        );
        strings.stream()
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting())
                ).entrySet().stream().filter(entry-> entry.getValue()> 1)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);
    }

    // Given a list of employees, each with a name and a salary, find the names of the employee with the highest and the lowest salary.

    @Test
    public void problem10() {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 70000),
                new Employee("Bob", 50000),
                new Employee("Charlie", 90000),
                new Employee("David", 60000),
                new Employee("Eve", 80000)
        );

        employees.stream().sorted(Comparator.comparing(Employee::Salary).reversed());
    }

}
