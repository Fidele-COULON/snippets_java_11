package fr.fidtec.database;

import fr.fidtec.database.enums.SGBDR;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;

@RequiredArgsConstructor
@Log
public class ConnectionFactory {

    private final SGBDR sgbdr;

    private Connection connexion = null;

    public Connection getConnection() {
        if (connexion == null) {
            try {
                connexion = computeConnexion();
            } catch (Exception e) {
                log.log(Level.SEVERE, e.getMessage());
            }
        }
        return connexion;
    }
    /**
     * Crée la connexion au SGBDR.
     * @return L'object {@link Connection} associé.
     */
    private Connection computeConnexion() throws IOException, SQLException {

        Properties properties = readProperties();

        String strConnexion = properties.getProperty("url");

        if (sgbdr.getUseCredentials()) {
            strConnexion += "?user=" + properties.getProperty("user") + "&password=" + properties.getProperty("password") ;
        }

       return DriverManager.getConnection(strConnexion);
    }

    /**
     * Lit le fichier des propriétés du SGBDR.
     * @return l'objet {@link Properties} associé.
     */
    private Properties readProperties() throws IOException {

        final String connectionConfigurationFile = sgbdr.getDatabaseName() + ".properties";

        // Lecture des propriétés de connexion
        Properties properties = new Properties();

        properties.load(ClassLoader.getSystemResourceAsStream(connectionConfigurationFile));

        return properties;
    }

}
