package org.jp.streams.example;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.Scanner;

public class CallTwoApiParalleryAndExecuteLogicOnceTheyResolve {
    public static void main(String[] args) {
        Flux<Tuple2<String, String>> zip = Flux.zip(api1(), api2());
        zip.subscribe(resp -> {
            String t1 = resp.getT1();
            String t2 = resp.getT2();
            System.out.println(t1 + t2);
        });
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();
    }

    public static Mono<String> api1() {
        return Mono.just("api1").delayElement(Duration.ofSeconds(1));
    }

    public static Mono<String> api2() {
        return Mono.just("api2").delayElement(Duration.ofSeconds(3));
    }
}
