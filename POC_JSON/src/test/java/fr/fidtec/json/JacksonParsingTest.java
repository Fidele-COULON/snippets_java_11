package fr.fidtec.json;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import fr.fidtec.beans.Person;
import fr.fidtec.beans.Personne;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class JacksonParsingTest {

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void generateJsonTest() throws IOException {
        StringWriter stringWriter = new StringWriter();
        objectMapper.writeValue(stringWriter, new Personne("COULON", "Fidele"));
        System.out.println("stringWriter :" + stringWriter);
        assertEquals("{\"nom\":\"COULON\",\"prenom\":\"Fidele\"}", stringWriter.toString());
    }

    @Test
    void generateJsonWithEmptyTest() throws IOException {
        StringWriter stringWriter = new StringWriter();
        objectMapper.writeValue(stringWriter, new Personne("", "Fidele"));
        System.out.println("JsonString :" + stringWriter);
        assertEquals("{\"nom\":\"\",\"prenom\":\"Fidele\"}", stringWriter.toString());
    }

    @Test
    void simpleParsingTest() throws IOException {
        String jsonString = "{\"nom\":\"COULON\",\"prenom\":\"Fidele\"}";

        Personne personne = objectMapper.readValue(jsonString, Personne.class);

        System.out.println(personne);

        assertEquals("COULON", personne.getNom());
        assertEquals("Fidele", personne.getPrenom());
    }

    @Test
    void simpleParsingWithEmptyTest() throws IOException {
        String jsonString = "{\"nom\":\"\",\"prenom\":\"Fidele\"}";

        Personne personne = objectMapper.readValue(jsonString, Personne.class);

        System.out.println(personne);

        assertEquals(StringUtils.EMPTY, personne.getNom());
        assertEquals("Fidele", personne.getPrenom());
    }

    @Test
    void simpleParsingWithJsonProperty() throws IOException {
        String jsonString = "{\"nom\":\"COULON\",\"prenom\":\"Fidele\"}";

        Person person = objectMapper.readValue(jsonString, Person.class);

        System.out.println(person);

        assertEquals("COULON", person.getLastName());
        assertEquals("Fidele", person.getFirstName());
    }

    @Test
    void simpleParsingWithJsonPropertyNotExist() throws IOException {
        Assertions.assertThrows( UnrecognizedPropertyException.class, () -> {
            String jsonString = "{\"nom\":\"COULON\",\"prenom2\":\"Fidele\"}";
            Personne personne = objectMapper.readValue(jsonString, Personne.class);
        });
    }

    @Test
    void simpleParsingWithJsonPropertyNotExistWithIgnore() throws IOException {
        String jsonString = "{\"nom\":\"COULON\",\"prenom2\":\"Fidele\"}";
        Person person = objectMapper.readValue(jsonString, Person.class);

        System.out.println(person);

        assertEquals("COULON", person.getLastName());
        assertNull(person.getFirstName());
    }
}
