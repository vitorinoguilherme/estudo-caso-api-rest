package org.example.project.api.funcionarios;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import org.example.project.exceptions.MyApplicationException;

import java.util.List;
import java.util.stream.Collectors;

@Path("funcionarios")
public class FuncionarioResource {
    private static FuncionarioRepository funcionarioRepository = new FuncionarioRepository();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@Valid FuncionarioRequest request) throws MyApplicationException {
        Funcionario funcionario = new Funcionario(
                request.CPF,
                request.nome,
                request.email,
                request.cod_departamento
        );

        if (funcionarioRepository.checkFuncionarioCPF(funcionario) != null) {
            throw new MyApplicationException("{\n \"violations\": [\n  {" +
                            "\n   \"path\": \"arg.CPF\"," +
                            "\n   \"message\": \"Funcionario cadastrado com o CPF definido\" " +
                            "\n  } \n ]\n}", Status.CONFLICT);
        }

        funcionarioRepository.save(funcionario);
        return Response.status(Status.CREATED)
                .entity(new FuncionarioResponse(funcionario))
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response index() {
        List<FuncionarioResponse> funcionarioResponses = funcionarioRepository.getAll()
                .stream()
                .map(FuncionarioResponse::new)
                .collect(Collectors.toList());

        return Response.status(Status.OK)
                .entity(funcionarioResponses)
                .build();
    }

    @GET
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response show(@PathParam("id") int id) {
        Funcionario funcionario = funcionarioRepository.getById(id);

        if (funcionario == null) {
            return Response.status(Status.NOT_FOUND).build();
        }

        return Response.status(Status.OK)
                .entity(new FuncionarioResponse(funcionario))
                .build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, @Valid FuncionarioRequest request) throws MyApplicationException {
        Funcionario funcionario = funcionarioRepository.getById(id);

        if (funcionario == null) {
            return Response.status(Status.NOT_FOUND).build();
        }

        Funcionario newFuncionario = new Funcionario(
                id,
                request.CPF,
                request.nome,
                request.email,
                request.cod_departamento
        );
        if (funcionarioRepository.checkFuncionarioCPF(newFuncionario) != null) {
            throw new MyApplicationException("{\n \"violations\": [\n  {" +
                            "\n   \"path\": \"arg.CPF\"," +
                            "\n   \"message\": \"Funcionario cadastrado com o CPF definido\" " +
                            "\n  } \n ]\n}", Status.CONFLICT);
        }
        funcionarioRepository.update(newFuncionario);

        return Response.status(Status.OK)
                .entity(new FuncionarioResponse(newFuncionario))
                .build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        Funcionario funcionario = funcionarioRepository.getById(id);

        if (funcionario == null) {
            return Response.status(Status.NOT_FOUND).build();
        }

        funcionarioRepository.delete(funcionario);

        return Response.status(Status.NO_CONTENT).build();
    }
}
