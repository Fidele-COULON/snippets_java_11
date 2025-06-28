package fr.fidtec.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Classe de tests de connexion à un serveur H2.
 * La classe est Disabled car tous les TUs sont KO si le serveur est inaccessible.
 */
class H2DBRawCnxTest {

    private static final String URL = "jdbc:h2:mem:";

    /**
     * Test de connexion à un serveur H2 : OK syntaxe correcte.
     */
    @Test
    void connexionRaw_testOK() {
        assertDoesNotThrow(() -> {
            try (Connection ignored = DriverManager.getConnection(URL)) {
                System.out.println("Connexion H2 effectuée !");
            }
        });
    }

    /**
     * Test de connexion à un serveur Maria DB : KO syntaxe incorrecte.
     */
    @Test
    void connexionRaw_testKO() {
        assertThrows(SQLException.class, () -> {
            try (Connection ignored = DriverManager.getConnection("toto")) {
                System.out.println("Connexion H2 effectuée !");
            }
        });
    }
}
