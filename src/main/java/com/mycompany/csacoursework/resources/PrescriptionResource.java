/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csacoursework.resources;

import com.mycompany.csacoursework.DAO.PrescriptionDAO;
import com.mycompany.csacoursework.modelClass.Prescription;
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
@Path("/prescriptions")
@Produces(MediaType.APPLICATION_JSON)
public class PrescriptionResource {
    private PrescriptionDAO prescriptionDAO;
    private static final Logger LOGGER = Logger.getLogger(PrescriptionResource.class.getName());
    
    public PrescriptionResource() {
        this.prescriptionDAO = PrescriptionDAO.getInstance();
    }
  
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPrescription(Prescription prescription) {
        prescriptionDAO.addPrescription(prescription);
        return Response.status(Response.Status.CREATED).entity(prescription).build();
    }

    @GET
    @Path("/{id}")
    public Response getPrescriptionById(@PathParam("id") int id) {
        Prescription prescription = prescriptionDAO.getPrescriptionById(id);
        if (prescription != null) {
            LOGGER.log(Level.INFO, "Prescription recieved with ID");
            return Response.ok(prescription).build();
        } else {
            LOGGER.log(Level.INFO, "Prescription could not be recieved with ID");
            return Response.status(Response.Status.NOT_FOUND).entity("Prescription not found").build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePrescription(@PathParam("id") int id, Prescription updatedPrescription) {
        updatedPrescription.setId(id);
        updatedPrescription = prescriptionDAO.updatePrescription(updatedPrescription);
        
        if (updatedPrescription == null) return Response.status(Response.Status.NOT_FOUND)
                .entity("Prescription not found").build();
        return Response.ok(updatedPrescription).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletePrescription(@PathParam("id") int id) {
        prescriptionDAO.deletePrescription(id);
        return Response.ok().build();
    }

    @GET
    public List<Prescription> getAllPrescriptions() {
        List<Prescription> prescriptions = prescriptionDAO.getAllPrescription();
        return prescriptions;
    }
}
