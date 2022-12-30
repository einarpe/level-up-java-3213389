package com.linkedin.javacodechallenges;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws Exception {
        // TODO: Call https://icanhazdadjoke.com/ API and display joke

        // first way
        var url = "https://icanhazdadjoke.com/";
        var endpoint = new URL(url);
        var conn = endpoint.openConnection();
        conn.addRequestProperty("Accept", "text/plain");

        try (var br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            System.out.println(br.readLine());
        }

        // second way
        var client = HttpClient.newHttpClient();
        var request = HttpRequest
                .newBuilder(endpoint.toURI())
                .header("Accept", "text/plain")
                .build();
        var response = client.send(request, BodyHandlers.ofString());
        System.out.println(response.body());

    }
}
