package br.edu.fatecpg.tp2.services;

import br.edu.fatecpg.tp2.model.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public class Lista {
    public static String extrairEmail(List<Usuario> usuarios){
        List<String> emails = usuarios.stream()
                .map(Usuario::getEmail)
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        return emails.toString();
    }
}
