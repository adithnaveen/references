package com.training;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;


public class StringMethodsEx02 {

	public static void main(String[] args) throws IOException {

//		stirngOperations();
		labdaExpressions();

	}

	private static void labdaExpressions() {
		String name = "Naveen";
		Function<String, String> performOperation = (str) -> "Hello " + str.toUpperCase();
		System.out.println(performOperation.apply(name));

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		System.out.println("------------ in lambday way ------------------ ");
		numbers.forEach((Integer temp) -> System.out.println(temp));
		System.out.println("------------ in lambday way 2 ------------------ ");
//		numbers.forEach((var temp) -> {
//			System.out.println(temp);
//		});

	}

	private static void stirngOperations() {
		var word = "Welcome";

		// repeat method returns
		System.out.println(word.repeat(5) + "\n");

		var word2 = "\tMy city is \t";
		var city = "Bengaluru";
		System.out.println(word2 + city);
		System.out.println(word2.stripTrailing() + city);
		System.out.println(word2.stripLeading() + city);
		System.out.println(word2.strip() + city);

		var word3 = "  ";
		System.out.println("checking the word is empty :" + word3.isEmpty());
		System.out.println("checking the word is blank : " + word3.isBlank());

		var words = "falcon\neagle\nsky\nwood\nforest";

		words.lines().forEach(System.out::println);
		System.out.println("-------------------------- ");

		"Hello\nHow\nAre\nYou".lines().map(String::toUpperCase).forEach(System.out::println);
	}
}
