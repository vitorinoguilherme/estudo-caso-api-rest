package org.example.project.api.departamentos;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import java.util.List;
import java.util.stream.Collectors;

@Path("departamentos")
public class DepartamentoResource {
    private static DepartamentoRepository departamentoRepository = new DepartamentoRepository();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@Valid DepartamentoRequest request) {
        Departamento departamento = new Departamento(request.nome, request.sigla);
        departamentoRepository.save(departamento);
        return Response.status(Status.CREATED)
                .entity(new DepartamentoResponse(departamento))
                .build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response index() {
        List<DepartamentoResponse> departamentoResponses = departamentoRepository.getAll()
                .stream()
                .map(DepartamentoResponse::new)
                .collect(Collectors.toList());

        return Response.status(Status.OK)
                .entity(departamentoResponses)
                .build();
    }

    @GET
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response show(@PathParam("id") int id) {
        Departamento departamento = departamentoRepository.getById(id);

        if (departamento == null) {
            return Response.status(Status.NOT_FOUND).build();
        }

        return Response.status(Status.OK)
                .entity(new DepartamentoResponse(departamento))
                .build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, @Valid DepartamentoRequest request) {
        Departamento departamento = departamentoRepository.getById(id);

        if (departamento == null) {
            return Response.status(Status.NOT_FOUND).build();
        }

        Departamento newDepartamento = new Departamento(id, request.nome, request.sigla);
        departamentoRepository.update(newDepartamento);

        return Response.status(Status.OK)
                .entity(new DepartamentoResponse(newDepartamento))
                .build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        Departamento departamento = departamentoRepository.getById(id);

        if (departamento == null) {
            return Response.status(Status.NOT_FOUND).build();
        }

        departamentoRepository.delete(departamento);

        return Response.status(Status.NO_CONTENT).build();
    }
}
