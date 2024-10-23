package br.edu.fatecpg.jpaApiCep.service;
import com.fasterxml.jackson.core.JsonProcessingException;
public interface IConvertJson {
    <T> T obterDado(String json,Class <T> classe) throws JsonProcessingException;
}
