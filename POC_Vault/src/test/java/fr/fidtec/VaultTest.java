package fr.fidtec;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.Versioned;

// https://github.com/hashicorp/vault-examples/blob/main/examples/_quick-start/java/Example.java
@Disabled("Cette classe de tests utilise une ressource externe (vault) !")
class VaultTest {

    private static final String TOKEN_VAULT = "hvs.iX4NbNE0x1UTJQdX07doz5nz"; // "00000000-0000-0000-0000-000000000000";

    @Test
    void saveAndRetrieveSecretTest() {

        VaultEndpoint vaultEndpoint = new VaultEndpoint();

        vaultEndpoint.setHost("localhost");
        vaultEndpoint.setPort(8200);
        vaultEndpoint.setScheme("http");

        // Authenticate
        VaultTemplate vaultTemplate = new VaultTemplate(vaultEndpoint, new TokenAuthentication(TOKEN_VAULT));
        System.out.println("Accès au Vault authentifié réalisé !");

        // Write a secret
        Map<String, String> credentialsMap = new HashMap<>() {{
            put("username", "Fidele2");
            put("password", "toto2");
        }};
        System.out.println("HashMap alimentée !");

        // créer par vault secrets enable -path=secret kv-v2 (Versioned) (ou kv/Not Versioned)
        // https://developer.hashicorp.com/vault/docs/secrets/kv
        // https://developer.hashicorp.com/vault/tutorials/secrets-management/versioned-kv
        // verif par vault secrets list -detailed
        Versioned.Metadata createResponse = vaultTemplate
                .opsForVersionedKeyValue("secret")
                .put("credentials", credentialsMap);
        System.out.println("Secret written successfully.");

        // Read a secret
        Versioned<Map<String, Object>> readResponse = vaultTemplate
                .opsForVersionedKeyValue("secret")
                .get("credentials");

        assertNotNull(readResponse);

        System.out.println("Username : " + readResponse.getData().get("username"));
        assertEquals("Fidele2", readResponse.getData().get("username"));

        System.out.println("Password : " + readResponse.getData().get("password"));
        assertEquals("toto2", readResponse.getData().get("password"));

    }
}
