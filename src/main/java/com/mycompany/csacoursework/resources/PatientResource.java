/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csacoursework.resources;

import com.mycompany.csacoursework.DAO.MedicalRecordsDAO;
import com.mycompany.csacoursework.DAO.PatientDAO;
import com.mycompany.csacoursework.modelClass.Patient;
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


@Path("/patients")
@Produces(MediaType.APPLICATION_JSON)
public class PatientResource {
    private PatientDAO patientDAO;
    private MedicalRecordsDAO medicalRecordsDAO;
    private static final Logger LOGGER = Logger.getLogger(PatientResource.class.getName());
    
    public PatientResource() {
        this.patientDAO = PatientDAO.getInstance();
    }
  
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPatient(Patient patient) {
        try{
            patientDAO.addPatient(patient);
            LOGGER.log(Level.INFO, "Patient Created");
            return Response.status(Response.Status.CREATED).entity(patient).build();
            
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, "Error in creating patient",e);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Cannot Create Patient (name,contactInfo,address required)").build();
        }    
    }

    @GET
    @Path("/{id}")
    public Response getPatientById(@PathParam("id") int id) {
        Patient patient = patientDAO.getPatientById(id);
        if (patient != null) {
            LOGGER.log(Level.INFO, "Patient Retrieved by ID");
            return Response.ok(patient).build();
        } else {
            LOGGER.log(Level.SEVERE, "Could not retrieve patient");
            return Response.status(Response.Status.NOT_FOUND).entity("Patient not found").build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePatient(@PathParam("id") int id, Patient updatedPatient) {
        try{
            updatedPatient.setId(id);
            updatedPatient = patientDAO.updatePatient(updatedPatient);
            
            if (updatedPatient == null) return Response.status(Response.Status.BAD_REQUEST)
                    .entity("No Patient found by id").build(); 
            LOGGER.log(Level.INFO, "Patient Updated");
            return Response.ok("Patient Updated").build();
        } catch(Exception e){
            LOGGER.log(Level.SEVERE, "Patient Could not be updated",e);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Could not update patient").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deletePatient(@PathParam("id") int id) {
        try{
            patientDAO.deletePatient(id);
            LOGGER.log(Level.INFO, "Patient Deleted");
            return Response.ok("Patient Deleted").build();
        } catch(Exception e){
            LOGGER.log(Level.SEVERE, "Patient Could not be deleted",e);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Could not delete patient").build();
        }
    }

    @GET
    public List<Patient> getAllPatients() {
        List<Patient> patients = patientDAO.getAllPatients();
        return patients;
    }
}
