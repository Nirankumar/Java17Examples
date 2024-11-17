package com.examples;

import com.examples.classes.Triangle;

public class Java17Example {

	public static void main(String... str) {
		System.out.println(checkObject(new Triangle(3)));
	}

	public static String checkObject(Object obj) {
		return switch (obj) {
			case Triangle t -> "Number of sides: "+t.numberOfSides();
			default -> "It is none of the known data types";
		};
	}
}
