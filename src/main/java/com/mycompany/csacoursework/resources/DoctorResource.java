/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csacoursework.resources;

import com.mycompany.csacoursework.DAO.DoctorDAO;
import com.mycompany.csacoursework.modelClass.Doctor;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

@Path("/doctors")
@Produces(MediaType.APPLICATION_JSON)
public class DoctorResource {
    private DoctorDAO doctorDAO;
    private static final Logger LOGGER = Logger.getLogger(DoctorResource.class.getName());
    
    public DoctorResource() {
        this.doctorDAO = DoctorDAO.getInstance();
    }
  
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDoctor(Doctor doctor) {
        doctorDAO.addDoctor(doctor);
        return Response.status(Response.Status.CREATED).entity(doctor).build();
    }

    @GET
    @Path("/{id}")
    public Response getDoctorById(@PathParam("id") int id) {
        Doctor doctor = doctorDAO.getDoctorById(id);
        if (doctor != null) {
            LOGGER.log(Level.INFO, "Doctor retrived by ID");
            return Response.ok(doctor).build();
        } else {
            LOGGER.log(Level.SEVERE, "Doctor could not be retrived by ID");
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Doctor not found").build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDoctor(@PathParam("id") int id, Doctor updatedDoctor) {
        updatedDoctor.setId(id);
        updatedDoctor = doctorDAO.updateDoctor(updatedDoctor);
        
        if (updatedDoctor == null) return Response.status(Response.Status.NOT_FOUND)
                .entity("Doctor could not be updated").build();
        LOGGER.log(Level.INFO, "Doctor updated by ID");
        return Response.ok().entity(updatedDoctor).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteDoctor(@PathParam("id") int id) {
        doctorDAO.deleteDoctor(id);
        
        return Response.ok().build();
    }

    @GET
    public List<Doctor> getAllDoctors() {
        List<Doctor> doctors = doctorDAO.getAllDoctor();
        return doctors;
    }
}
