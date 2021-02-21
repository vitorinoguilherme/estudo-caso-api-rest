package org.example.project.api.users;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("users")
public class UserResource {
    private static UserRepository userRepository = new UserRepository();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@Valid UserRequest request) {
        User user = new User(request.name, request.email, request.password);
        userRepository.save(user);
        return Response.status(Status.CREATED)
                .entity(new UserResponse(user.getId(), user.getName(), user.getEmail()))
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response index() {
        List<UserResponse> userResponses = userRepository.getAll().stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());

        return Response.status(Status.OK)
                .entity(userResponses)
                .build();
    }

    @GET
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response show(@PathParam("id") int id) {
        User user = userRepository.getById(id);

        if (user == null) {
            return Response.status(Status.NOT_FOUND).build();
        }

        return Response.status(Status.OK)
                .entity(new UserResponse(user))
                .build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, @Valid UserRequest request) {
        User user = userRepository.getById(id);

        if (user == null) {
            return Response.status(Status.NOT_FOUND).build();
        }

        User newUser = new User(id, request.name, request.email, request.password);
        userRepository.update(newUser);
        return Response.status(Status.OK)
                .entity(new UserResponse(newUser))
                .build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        User user = userRepository.getById(id);

        if (user == null) {
            return Response.status(Status.NOT_FOUND).build();
        }

        userRepository.delete(user);
        return Response.status(Status.NO_CONTENT)
                .build();
    }
}
