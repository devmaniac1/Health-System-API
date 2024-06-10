/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csacoursework.resources;

import com.mycompany.csacoursework.DAO.BillingDAO;
import com.mycompany.csacoursework.modelClass.Billing;
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
@Path("/billings")
@Produces(MediaType.APPLICATION_JSON)
public class BillingResource {
    private BillingDAO billingDAO;
    private static final Logger LOGGER = Logger.getLogger(BillingResource.class.getName());
    
    public BillingResource() {
        this.billingDAO = BillingDAO.getInstance();
    }
  
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBilling(Billing billing) {
        billingDAO.addBilling(billing);
        return Response.status(Response.Status.CREATED).entity(billing).build();
    }

    @GET
    @Path("/{id}")
    public Response getBillingById(@PathParam("id") int id) {
        Billing billing = billingDAO.getBillingById(id);
        if (billing != null) {
            LOGGER.log(Level.INFO, "Billing retrieved by ID");
            return Response.ok(billing).build();
        } else {
            LOGGER.log(Level.SEVERE, "Billing could not be retrieved");
            return Response.status(Response.Status.NOT_FOUND).entity("Billing not found").build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBilling(@PathParam("id") int id, Billing updatedBilling) {
        updatedBilling.setId(id);
        updatedBilling = billingDAO.updateBilling(updatedBilling);
        if (updatedBilling == null){
            LOGGER.log(Level.SEVERE, "Billing could not be updated");
            return Response.status(Response.Status.BAD_REQUEST).entity(updatedBilling).build();
        }
        LOGGER.log(Level.INFO, "Billing updated by ID");
        return Response.ok().entity(updatedBilling).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBilling(@PathParam("id") int id) {
        billingDAO.deleteBilling(id);
        return Response.ok().entity("Deleted Billing").build();
    }

    @GET
    public List<Billing> getAllBillings() {
        List<Billing> billings = billingDAO.getAllBilling();
        return billings;
    }
}
