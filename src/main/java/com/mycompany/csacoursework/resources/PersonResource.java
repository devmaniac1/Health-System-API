/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csacoursework.resources;

import com.mycompany.csacoursework.DAO.PersonDAO;
import com.mycompany.csacoursework.modelClass.Person;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Ashfaq
 */
@Path("/user")
public class PersonResource {
    
    private final PersonDAO personDAO;

    public PersonResource() {
        this.personDAO = PersonDAO.getInstance();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllUsers() {
        return personDAO.getAllPersons();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("id") int id) {
        Person person = personDAO.findById(id);
        if (person != null) {
            return Response.ok(person).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("User not found").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(Person person) {
        personDAO.create(person);
        return Response.status(Response.Status.CREATED).entity(person).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") int id, Person updatedPerson) {
        updatedPerson.setId(id);
        personDAO.update(updatedPerson);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") int id) {
        personDAO.delete(id);
        return Response.ok().build();
    }
} 
