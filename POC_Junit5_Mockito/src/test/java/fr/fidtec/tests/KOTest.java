package fr.fidtec.tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class KOTest {

    @Test
    void testOK() {
        assertFalse(true);
    }

    @Test
    void IntegerTest() {
        int nb = Integer.parseInt("10");
        assertEquals (10, nb);
        nb = Integer.parseInt("TOTO");
        assertEquals (0, nb);
    }

}
