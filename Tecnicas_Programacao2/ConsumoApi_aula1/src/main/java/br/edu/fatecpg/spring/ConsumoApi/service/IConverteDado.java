package br.edu.fatecpg.spring.ConsumoApi.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IConverteDado {
    <T> T obterDado(String json,Class <T> classe) throws JsonProcessingException;
}
