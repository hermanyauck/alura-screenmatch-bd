package com.hermanyauck.screenmatch.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumirAPI implements IConvertDatos{
    private String url;
    private String json;
    private ObjectMapper objectMapper;

    public ConsumirAPI(String url) {
        this.url = url;
        this.consultarAPI();
    }

    public void consultarAPI() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.url))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.json = response.body();
    }

    @Override
    public <T> T obtenerDatos(Class<T> clase) {
        this.consultarAPI();
        objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(this.json, clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
