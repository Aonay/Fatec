package br.edu.fatecpg.tp2.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConverterDado {
    static ObjectMapper objectMapper = new ObjectMapper();

    public static JsonNode listaObjetos(String json) throws JsonProcessingException {
        JsonNode jsonNode = objectMapper.readTree(json);
        return jsonNode;
    }
    public static List<JsonNode> jsonList(JsonNode jsonNode){
        List <JsonNode> jsonList = new ArrayList<>();
        jsonNode.forEach(jsonList::add);
        return jsonList;
    }

    public static List<String> buscarFaixaPreco(List<JsonNode> jsonList, double valor){
        List<String> listaBusca = jsonList.stream()
                .filter(node -> node.get("price").asDouble() <=valor)
                .map(node -> node.get("title").asText())
                .collect(Collectors.toList());
        return listaBusca;
    }



}
