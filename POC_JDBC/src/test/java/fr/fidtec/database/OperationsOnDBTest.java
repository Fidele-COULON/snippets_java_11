package fr.fidtec.database;

import fr.fidtec.database.enums.SGBDR;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Classe de tests d'operation sur les SGBDRs.
 */
class OperationsOnDBTest {

    /**
     * Lance une série d'opérations SQL sur une instance H2DB.
     */
    @Test
    void operationsOnH2DBTest() throws SQLException {
        ConnectionFactory factory = new ConnectionFactory(SGBDR.H2DB);
        createTableUsers(factory.getConnection());
        assertEquals(1, createUser(factory.getConnection(), "COULON", "Fidele"));
        assertEquals(1, createUser(factory.getConnection(),"COULON", "Laurence"));
    }

    /**
     * Lance une série d'opérations SQL sur une instance MariaDB.
     */
    @Test
    void operationsOnMariaDBTest() throws SQLException {
        ConnectionFactory factory = new ConnectionFactory(SGBDR.MARIADB);
        createTableUsers(factory.getConnection());
        assertEquals(1, createUser(factory.getConnection(), "COULON", "Fidele"));
        assertEquals(1, createUser(factory.getConnection(),"COULON", "Laurence"));
    }

    /**
     * Crée une table users sur la connexion fournie en entrée.
     * @param connection Un {@link Connection} la connexion sur laquelle porte l'action.
     */
    private void createTableUsers(final Connection connection) throws SQLException {
        try (PreparedStatement prepare = connection.prepareStatement("CREATE TABLE users(id INT PRIMARY KEY AUTO_INCREMENT, nom VARCHAR(255), prenom  VARCHAR(255));")) {
            prepare.executeUpdate();
        }
    }

    /**
     * Crée un utilisateur dans la table users sur la connexion fournie en entrée.
     * @param connection Un {@link Connection} la connexion sur laquelle porte l'action.
     * @param nom Le nom de l'utlisateur.
     * @param prenom Le prénom de l'utilisateur.
     * @return le nombre de lignes ajoutées en base (1=OK, 0 = KO).
     */
    private int createUser(final Connection connection, final String nom, final String prenom) throws SQLException {

        try(PreparedStatement prepare  = connection.prepareStatement("INSERT INTO users(nom, prenom) VALUES(?,?)")) {
            prepare.setString(1, nom);
            prepare.setString(2, prenom);
            return prepare.executeUpdate();
        }
    }
}
