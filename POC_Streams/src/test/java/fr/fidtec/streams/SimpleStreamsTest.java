package fr.fidtec.streams;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class SimpleStreamsTest {

    private static final List<String> prenoms = new ArrayList<>() {{
        add("Jesus");
        add("Hans");
        add("Hubert");
    }};

    @Test
    void streamMapTest() {

        List <String> result = prenoms.stream()
                .map(value -> value + " Form")
                .toList();

        result.forEach(System.out::println);

        assertNotNull(result);
    }

    @Test
    void streamAnymatchtest() {

        boolean resultTrue = prenoms
                .stream()
                .anyMatch(p -> p.equals("Hans"));

        assertTrue(resultTrue);

        boolean resultFalse = prenoms
                .stream()
                .anyMatch(p -> p.equals("Hansel"));

        assertFalse(resultFalse);

    }

    @Test
    void arrayStringStreamTest() {
        String[] digits = {"1", "2", "3", "4", "5"};

        // Ajout le caractère "+" sur toutes les lignes sauf la dernière
        System.out.println(String.join("+" + System.lineSeparator(), digits) );

        System.out.println(
                Arrays.stream(digits)
                        .map(s -> '+' + s + System.lineSeparator())
                        .collect(Collectors.joining()));

    }

}
