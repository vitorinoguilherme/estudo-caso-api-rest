package org.example.project.api.projetos;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import org.example.project.exceptions.MyApplicationException;

import java.util.List;
import java.util.stream.Collectors;

@Path("/projetos")
public class ProjetoResource {
    private static ProjetoRepository projetoRepository = new ProjetoRepository();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@Valid ProjetoRequest request) throws MyApplicationException {
        if (Boolean.TRUE.equals(request.checkIfDateIsGreaterThanAnotherDate())) {
            throw new MyApplicationException(
                    "{\n \"violations\": [\n  {" +
                    "\n   \"path\": \"arg.data_inicio\"," +
                    "\n   \"message\": \"data_inicio deve ser menor do que data_fim\" " +
                    "\n  } \n ]\n}",
                    Status.BAD_REQUEST);
        }
        
        System.out.println(request.data_inicio);
        Projeto projeto = new Projeto(
                request.titulo,
                request.data_inicio,
                request.data_fim,
                request.cod_departamento
        );
        projetoRepository.save(projeto);

        return Response.status(Status.CREATED)
                .entity(new ProjetoResponse(projeto))
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response index() {
        List<ProjetoResponse> projetoResponses = projetoRepository.getAll()
                .stream()
                .map(ProjetoResponse::new)
                .collect(Collectors.toList());

        return Response.status(Status.OK)
                .entity(projetoResponses)
                .build();
    }

    @GET
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response show(@PathParam("id") int id) {
        Projeto projeto = projetoRepository.getById(id);

        if (projeto == null) {
            return Response.status(Status.NOT_FOUND).build();
        }

        return Response.status(Status.OK)
                .entity(new ProjetoResponse(projeto))
                .build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, @Valid ProjetoRequest request) throws MyApplicationException {
        if (Boolean.TRUE.equals(request.checkIfDateIsGreaterThanAnotherDate())) {
            throw new MyApplicationException(
                    "{\n \"violations\": [\n  {" +
                    "\n   \"path\": \"arg.data_inicio\"," +
                    "\n   \"message\": \"data_inicio deve ser menor do que data_fim\" " +
                    "\n  } \n ]\n}"
                    , Status.BAD_REQUEST
            );
        }

        Projeto projeto = projetoRepository.getById(id);

        if (projeto == null) {
            return Response.status(Status.NOT_FOUND).build();
        }

        Projeto newProjeto = new Projeto(
                id,
                request.titulo,
                request.data_inicio,
                request.data_fim,
                request.cod_departamento
        );
        projetoRepository.update(newProjeto);

        return Response.status(Status.OK)
                .entity(new ProjetoResponse(newProjeto))
                .build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        Projeto projeto = projetoRepository.getById(id);

        if (projeto == null) {
            return Response.status(Status.NOT_FOUND).build();
        }

        projetoRepository.delete(projeto);

        return Response.status(Status.NO_CONTENT).build();
    }
}
