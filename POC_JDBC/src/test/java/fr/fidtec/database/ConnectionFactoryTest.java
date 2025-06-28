package fr.fidtec.database;

import fr.fidtec.database.enums.SGBDR;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Classe de tests de la classe ConnectionFactory.
 */
class ConnectionFactoryTest {

    /**
     * Crée une connexion à un SGBDR H2DB - cas OK.
     */
    @Test
    void ConnectionFactoryH2TestOK() {
        ConnectionFactory factory = new ConnectionFactory(SGBDR.H2DB);
        assertNotNull(factory.getConnection());
    }

    /**
     * Crée une connexion à un SGBDR MARIADB - cas OK.
     * Disabled car tous les TUs sont KO si le serveur est inaccessible.
     */
    @Test
    @Disabled
    void ConnectionFactoryMariaTestOK() {
        ConnectionFactory factory = new ConnectionFactory(SGBDR.MARIADB);
        assertNotNull(factory.getConnection());
    }

    /**
     * Crée 2 connexions depuis la factory à un SGBDR MARIADB et vérifie que la connexion est la même.
     */
    @Test
    void ConnectionFactorySingletonTestOK() {
        ConnectionFactory factory = new ConnectionFactory(SGBDR.MARIADB);
        Connection c1 = factory.getConnection();
        Connection c2 = factory.getConnection();
        assertEquals(c1,c2);
    }
}
