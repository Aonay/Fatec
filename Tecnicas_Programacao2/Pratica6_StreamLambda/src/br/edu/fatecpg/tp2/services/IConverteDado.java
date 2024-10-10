package br.edu.fatecpg.tp2.services;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IConverteDado {
    <T> T obterDato(String json,Class<T> classe)throws JsonProcessingException;
}
