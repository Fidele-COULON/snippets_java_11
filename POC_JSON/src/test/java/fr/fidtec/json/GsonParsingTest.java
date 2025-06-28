package fr.fidtec.json;

import com.google.gson.Gson;
import fr.fidtec.beans.Personne;
import org.junit.jupiter.api.Test;

import org.apache.commons.lang3.StringUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Google Gson
public class GsonParsingTest {

    private final Gson gson = new Gson();

    @Test
    void generateJsonTest() {
        String jsonString = gson.toJson(new Personne( "COULON", "Fidele"));
        System.out.println("JsonString :" + jsonString);
        assertEquals("{\"nom\":\"COULON\",\"prenom\":\"Fidele\"}", jsonString);
    }

    @Test
    void generateJsonWithEmptyTest() {
        String jsonString = gson.toJson(new Personne("", "Fidele"));
        System.out.println("JsonString :" + jsonString);
        assertEquals("{\"nom\":\"\",\"prenom\":\"Fidele\"}", jsonString);
    }

    @Test
    void simpleParsingTest() {
        String jsonString = "{'nom':'COULON','prenom':'Fidele'}";

        Personne personne = gson.fromJson(jsonString, Personne.class);

        System.out.println(personne);

        assertEquals("COULON", personne.getNom());
        assertEquals("Fidele", personne.getPrenom());
    }

    @Test
    void simpleParsingWithEmptyTest() {
        String jsonString = "{'nom':'','prenom':'Fidele'}";

        Personne personne = gson.fromJson(jsonString, Personne.class);

        System.out.println(personne);

        assertEquals(StringUtils.EMPTY, personne.getNom());
        assertEquals("Fidele", personne.getPrenom());
    }
}
