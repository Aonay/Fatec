package br.edu.fatecpg.tp2.Pratica3_SpringSemWeb.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class ConsomeImdbApi {
    public static String obterDado(String titulo){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.omdbapi.com/?t="+titulo+"&apikey=6eff43db"))
                .build();

        return null;
    }

}
