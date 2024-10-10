package br.edu.fatecpg.tp2.view;

import br.edu.fatecpg.tp2.model.Usuario;
import br.edu.fatecpg.tp2.services.ConsomeApi;
import br.edu.fatecpg.tp2.services.ConverteDado;
import br.edu.fatecpg.tp2.services.Lista;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        String json = ConsomeApi.consomeApi();
        ConverteDado dado = new ConverteDado();
        List<Usuario> usuarios = dado.obterDato(json,List.class);
        String emails = Lista.extrairEmail(usuarios);
        System.out.println(emails);









    }
}
