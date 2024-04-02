package br.com.alura.screenmatch.service;

import br.com.alura.screenmatch.model.DadosSerie;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

// Esta classe é responsável por converter dados de JSON para objetos Java
public class ConverteDados implements IconverteDados{
    private ObjectMapper mapper = new ObjectMapper();



    // Método para obter dados de JSON e convertê-los para o tipo desejado
    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        try {
            // Converte a string JSON para um objeto Java da classe fornecida
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

