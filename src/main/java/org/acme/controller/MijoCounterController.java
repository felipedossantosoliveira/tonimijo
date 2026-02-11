package org.acme.controller;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.MijoCounterDTO;
import org.acme.service.MijoCounterService;

import java.util.Optional;

@Path("/counter")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MijoCounterController {

    @Inject
    private MijoCounterService mijoCounterService;

    @POST
    @RolesAllowed({"user", "admin"})
    public final Response save(MijoCounterDTO dto) {
        try {
            mijoCounterService.save(dto);
            return Response.ok().build();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return Response.status(Response.Status.PRECONDITION_FAILED.getStatusCode(), e.getMessage()).build();
        }
    }

    @GET
    @RolesAllowed({"user", "admin"})
    public final Response findByName(@QueryParam("name") String name) {
        Optional<MijoCounterDTO> optional = mijoCounterService.findByName(name);
        if (optional.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(optional).build();
    }
}
