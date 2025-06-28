package fr.fidtec.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

// https://www.baeldung.com/introduction-to-wiremock
class WiremockTest {

    @Test
    void simplewireMockServerTest() throws IOException {

        // If no port is supplied, the server port will default to 8080
        WireMockServer wireMockServer = new WireMockServer(8080);
        wireMockServer.start();

        stubFor(get(urlEqualTo("/welcome"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("Welcome to Baeldung!")));

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet request = new HttpGet("http://localhost:8080/welcome");
        CloseableHttpResponse httpResponse = httpClient.execute(request);

        String responseString = convertResponseToString(httpResponse);

        System.out.println("Reponse : " + responseString);

        verify(getRequestedFor(urlEqualTo("/welcome")));

        assertEquals(200, httpResponse.getCode());
        assertEquals("application/json", httpResponse.getFirstHeader("Content-Type").getValue());
        assertEquals("Welcome to Baeldung!", responseString);

        stubFor(get(urlPathEqualTo("/error"))
                .withHeader("Accept", matching("text/.*"))
                .willReturn(aResponse()
                        .withStatus(503)
                        .withHeader("Content-Type", "text/html")
                        .withBody("!!! Service Unavailable !!!")));

        // Header incorrect
        request = new HttpGet("http://localhost:8080/error");
        httpResponse = httpClient.execute(request);
        assertEquals(404, httpResponse.getCode());

        // Header correct
        request.addHeader("Accept", "text/html");
        httpResponse = httpClient.execute(request);
        assertEquals(503, httpResponse.getCode());

        wireMockServer.stop();

    }

    private String convertResponseToString(CloseableHttpResponse response) throws IOException {
        InputStream responseStream = response.getEntity().getContent();
        Scanner scanner = new Scanner(responseStream, "UTF-8");
        String responseString = scanner.useDelimiter("\\Z").next();
        scanner.close();
        return responseString;
    }

}
