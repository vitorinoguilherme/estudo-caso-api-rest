package org.example.project;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

import java.io.IOException;
import java.net.URI;

public class App {
  public static void main(String[] args) throws IOException {
    URI uri = URI.create("http://localhost:8080/api/");
    ResourceConfig resourceConfig = new ResourceConfig();
    resourceConfig.packages("org.example.project");

    HttpServer httpServer = GrizzlyHttpServerFactory.createHttpServer(uri, resourceConfig);
    System.out.printf("JAX-RS - Jersey App iniciado em %s", uri);
    System.in.read();
    httpServer.shutdownNow();
  }
}
