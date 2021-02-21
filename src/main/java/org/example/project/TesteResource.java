package org.example.project;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("teste")
public class TesteResource {
  @GET
  public String teste() {
    return "teste teste 2";
  }

  @GET
  @Path("{nome}")
  public String teste2(@PathParam("nome") String nome) {
    return "Ola " + nome;
  }
}
