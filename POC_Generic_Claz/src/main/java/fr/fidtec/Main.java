package fr.fidtec;

import fr.fidtec.generic.ListeTableau;

// https://stackoverflow.com/questions/4837190/java-generics-get-class
// https://www.baeldung.com/java-generic-type-find-class-runtime
public class Main {

    public static void main(String[] args) {

        System.out.println("HelloWorld!");

        ListeTableau<Integer> foo1 = new ListeTableau<>(Integer.class);
        foo1.add(99);
        System.out.println("Foo1 : " + foo1.count());
        System.out.println("Foo1 Class : " + foo1.getClazz());

        ListeTableau<String> foo2 = new ListeTableau<>(String.class);
        foo2.add("Fidele");
        System.out.println("Foo2 : " + foo2.count());
        System.out.println("Foo2 Class : " + foo2.getClazz());
    }
}