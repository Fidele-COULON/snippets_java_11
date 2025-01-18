package fr.fidtec.streams;

import fr.fidtec.enums.Erreur;
import org.junit.jupiter.api.Test;

import static fr.fidtec.enums.Erreur.ERREUR2;
import static fr.fidtec.enums.Erreur.INCONNUE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EnumTest {

    @Test
    void erreursEnumTest() {
        Erreur erreur = Erreur.getErreur(2);
        assertEquals(ERREUR2, erreur);

        erreur = Erreur.getErreur(5);
        assertEquals(INCONNUE, erreur);
    }
}
