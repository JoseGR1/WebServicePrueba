/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.edu.umg.webserviceprueba;

import com.edu.umg.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author jose5
 */
@Path("users")
public class GenericResource {

    @Context
    private UriInfo context;

    private static List<User> users = new ArrayList<>();
    
    static {
        users.add(new User(1, "user1", "password1"));
        users.add(new User(2, "user2", "password2"));
    }
    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
        return users;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(User user) {
        user.setId(users.size() + 1);
        users.add(user);
        return Response.status(Response.Status.CREATED).entity(user).build();
    }
}
