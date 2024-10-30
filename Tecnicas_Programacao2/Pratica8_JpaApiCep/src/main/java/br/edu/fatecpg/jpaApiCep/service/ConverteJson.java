package br.edu.fatecpg.jpaApiCep.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteJson implements IConvertJson{
    ObjectMapper mapper = new ObjectMapper();
    @Override
    public  <T> T  obterDado(String json, Class<T> classe) throws JsonProcessingException {
        return mapper.readValue(json,classe);
    }
}
