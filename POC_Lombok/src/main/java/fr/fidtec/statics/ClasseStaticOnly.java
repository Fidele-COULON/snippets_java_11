package fr.fidtec.statics;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

// https://stackoverflow.com/questions/61979940/lombok-private-constructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClasseStaticOnly {

	public static String getMessage(String name) {
		return "HelloWorld " + name + " !";
	}
}
