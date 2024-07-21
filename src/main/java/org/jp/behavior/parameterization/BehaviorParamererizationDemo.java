package org.jp.behavior.parameterization;

import org.jp.models.Apple;
import org.jp.models.Colors;
import org.jp.models.Size;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;

public class BehaviorParamererizationDemo {

    public static void main(String[] args) {

        var apples = getApples();
        // printing apple colors
        prettyPrintApple(getApples(), (apple) -> System.out.println(apple.color()));
        // printing apple color and  sizes
        prettyPrintApple(getApples(), (apple) -> System.out.println("""
                apple color: """ + apple.color() + """
                \napple size: """ + apple.size() + """
                """));
        // apples.forEach(System.out::println);
        // sorting apples based on weight
        System.out.println("sorting apples based on weight");
        apples.sort((a, b) -> b.weight().compareTo(a.weight()));
        apples.forEach(System.out::println);

        // sorting apples based on size
        System.out.println("sorting apples based on size");
        apples.sort(comparing(Apple::size).reversed());
        apples.forEach(System.out::println);

        //   sorting apples based on weight if they are same weight sort by size
        apples.sort(comparing(Apple::weight).thenComparing(Apple::size));
        apples.forEach(System.out::println);


        // filtering red and green apples
        Predicate<Apple> redApple = a -> a.color() == Colors.RED;
        Predicate<Apple> redOrGreenApple = redApple.or(a -> a.color() == Colors.GREEN);
        Predicate<Apple> redOrGreenAndHugeApple = redOrGreenApple.or(a -> a.size() == Size.HUGE);
        getApples().stream()
                .filter(redOrGreenAndHugeApple)
                .forEach(System.out::println);
    }

    public static void prettyPrintApple(List<Apple> apples, Consumer<Apple> printBehavior) {
        apples.forEach(printBehavior);
    }


    public static List<Apple> getApples() {
        // add apples 10 apples with different values to the list and return
        var apple = new Apple(2.1F, Colors.BLUE, Size.SMALL);
        var apple5 = new Apple(2.1F, Colors.BLUE, Size.SMALL);
        var apple1 = new Apple(3.1F, Colors.GREEN, Size.MEDIUM);
        var apple2 = new Apple(4.1F, Colors.PINK, Size.HUGE);
        var apple3 = new Apple(1.1F, Colors.RED, Size.SMALL);
        var apple4 = new Apple(1.1F, Colors.RED, Size.HUGE);
        return Arrays.asList(apple, apple1, apple2, apple3, apple4, apple5);
    }
}
