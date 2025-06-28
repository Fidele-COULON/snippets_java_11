package fr.fidtec.database;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Classe de tests de connexion à un serveur MariaDB.
 * La classe est Disabled car tous les TUs sont KO si le serveur est inaccessible.
 */
@Disabled
class MariaDBRawCnxTest {

    private static final String URL = "jdbc:mysql://192.168.1.3:3306/db_dev";

    /**
     * Test de connexion à un serveur Maria DB : OK avec les bons creds.
     */
    @Test
    void connexionRaw_testOK() {
        assertDoesNotThrow(() -> {
            try (Connection ignored = DriverManager.getConnection(URL + "?user=root&password=root")) {
                System.out.println("Connexion MariaDB effectuée !");
            }
        });
    }

    /**
     * Test de connexion à un serveur Maria DB : KO avec les mauvais creds.
     */
    @Test
    void connexionRaw_testKO() {
        assertThrows(SQLException.class, () -> {
            try (Connection ignored = DriverManager.getConnection(URL + "?user=toto&password=toto")) {
                System.out.println("Connexion MariaDB effectuée !");
            }
        });
    }
}
