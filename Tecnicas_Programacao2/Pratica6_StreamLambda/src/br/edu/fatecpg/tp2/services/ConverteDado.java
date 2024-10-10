package br.edu.fatecpg.tp2.services;

import br.edu.fatecpg.tp2.model.Usuario;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

public class ConverteDado{

    ObjectMapper mapper = new ObjectMapper();
    public List<Usuario> obterDato(String json, Class<List> classe) throws JsonProcessingException {
        return mapper.readValue(json, new TypeReference<List<Usuario>>() {});

    }
}
