package fr.fidtec.streams;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class SimpleStreamsTest {

    @Test
    void addFamilyNameTest() {
        List<String> prenoms = new ArrayList<>() {{
          add("Jesus");
          add("Hans");
          add("Hubert");
        }};

        List <String> result = prenoms.stream()
                .map(value -> value + " Form")
                .toList();

        result.forEach(System.out::println);
    }
}
