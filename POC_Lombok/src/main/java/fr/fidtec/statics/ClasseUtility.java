package fr.fidtec.statics;

import lombok.experimental.UtilityClass;

// https://projectlombok.org/features/experimental/UtilityClass
@UtilityClass
public class ClasseUtility {

	public String getMessage(String name) {
		return "HelloWorld " + name + " !";
	}
}
