package com.dy.core.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamsWork {

	public static void main(String[] args) {
		List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

		myList.stream().filter(s -> s.startsWith("c")).map(String::toUpperCase).sorted().forEach(System.out::println);

		Arrays.asList("a1", "a2", "a3").stream().findFirst().ifPresent(System.out::println);

		Stream.of("a1", "a2", "a3").map(s -> s.substring(1)).mapToInt(Integer::parseInt).max()
				.ifPresent(System.out::println); // 3

		Stream.of(1.0, 2.0, 3.0).mapToInt(Double::intValue).mapToObj(i -> "a" + i).forEach(System.out::println);

		// When executing this code snippet, nothing is printed to the console. That is
		// because intermediate operations will only be executed when a terminal
		// operation is present.

		Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> {
			System.out.println("filter: " + s);
			return true;
		});

		// extend the above example by the terminal operation forEach:
		Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> {
			System.out.println("filter: " + s);
			return true;
		}).forEach(s -> System.out.println("forEach: " + s));

		// A naive approach would be to execute the operations horizontally one after
		// another on all elements of the stream. But instead each element moves along
		// the chain vertically. The first string "d2" passes filter then forEach, only
		// then the second string "a2" is processed.
		// behavior can reduce the actual number of operations performed on each
		// element,
		Stream.of("d2", "a2", "b1", "b3", "c").map(s -> {
			System.out.println("map: " + s);
			return s.toUpperCase();
		}).anyMatch(s -> {
			System.out.println("anyMatch: " + s);
			return s.startsWith("A");
		});

	}

}
