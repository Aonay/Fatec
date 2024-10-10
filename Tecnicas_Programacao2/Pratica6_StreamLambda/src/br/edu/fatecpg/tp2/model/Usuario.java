package br.edu.fatecpg.tp2.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Usuario (
        @JsonAlias("postId") String idPost,
        String id,
        @JsonAlias("name") String nome,
        String email,
        @JsonAlias("body") String comentario

){
 public String getEmail() {
  return this.email;
 }

}
