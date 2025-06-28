package fr.fidtec.runnables;

import fr.fidtec.concepts.DeprecatedClass;

public class DeprecatedClassRunner {

    public static void main(String[] args) {

        System.out.println("Nous sommes en " + DeprecatedClass.getYearV1()); // NOSONAR

        System.out.println("Nous sommes en " + DeprecatedClass.getYearV2()); // NOSONAR

        System.out.println("Nous sommes en " + DeprecatedClass.getYearv3()); // NOSONAR

        System.out.println("Nous sommes en " + DeprecatedClass.getYearv4()); // NOSONAR

        System.out.println("Nous sommes en " + DeprecatedClass.getYearv5()); // NOSONAR

        System.out.println("Nous sommes en " + DeprecatedClass.getYearv6()); // NOSONAR
    }
}
