/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csacoursework.resources;

import com.mycompany.csacoursework.DAO.MedicalRecordsDAO;
import com.mycompany.csacoursework.DAO.PatientDAO;
import com.mycompany.csacoursework.modelClass.MedicalRecord;
import com.mycompany.csacoursework.modelClass.Prescription;
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
@Path("/medicalRecords")
@Produces(MediaType.APPLICATION_JSON)
public class MedicalRecordsResource {
    private MedicalRecordsDAO medicalRecordsDAO;
    private PatientDAO patientDAO;
    
    public MedicalRecordsResource() {
        this.medicalRecordsDAO = MedicalRecordsDAO.getInstance();
    }
  
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMedicalRecords(MedicalRecord medicalRecords) {
        medicalRecordsDAO.addMedicalRecord(medicalRecords);
        return Response.status(Response.Status.CREATED)
                .entity(medicalRecords).build();
    }

    @GET
    @Path("/{id}")
    public Response getMedicalRecordsById(@PathParam("id") int id) {
        MedicalRecord medicalRecords = medicalRecordsDAO
                .getMedicalByPatientId(id);
        if (medicalRecords != null) {
            
            List<Prescription> prescriptions = medicalRecords.getTreatment();
            StringBuilder jsonTreatmentBuilder = new StringBuilder();
            StringBuilder jsonResponseBuilder = new StringBuilder();

            for(int i=0;i<prescriptions.size();i++){
                jsonTreatmentBuilder = buildTreatment(prescriptions.get(i),
                        jsonTreatmentBuilder);

                if (i != prescriptions.size()-1){
                    jsonTreatmentBuilder.append(",");
                }
            }
            
            jsonResponseBuilder.append("[");
            jsonResponseBuilder = bulidMedicalPatient(medicalRecords,
                    jsonResponseBuilder,jsonTreatmentBuilder);
            jsonResponseBuilder.append("]");                                 
            String jsonResponse = jsonResponseBuilder.toString();
            return Response.status(Response.Status.OK).entity(jsonResponse)
                    .build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("MedicalRecords not found").build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMedicalRecords(@PathParam("id") int id, 
            MedicalRecord updatedMedicalRecords) {
        MedicalRecord medicalRecord = medicalRecordsDAO.getMedicalByPatientId(id);
        if (medicalRecord == null){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Could not find patient ID").build();
        }
        updatedMedicalRecords.setId(id);
        medicalRecordsDAO.updateMedicalRecord(updatedMedicalRecords);
        
        return Response.ok().entity("Record Updated").build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteMedicalRecords(@PathParam("id") int id) {
        MedicalRecord medicalRecord = medicalRecordsDAO.getMedicalByPatientId(id);
        if (medicalRecord == null){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Could not find patient ID").build();
        }
        medicalRecordsDAO.deleteMedicalRecord(id);
        return Response.ok().entity("Medical Record Deleted").build();
    }


    @GET
    public Response getAllMedicalRecords() {
        List<MedicalRecord> medicalRecords = medicalRecordsDAO.getAllMedicalRecord();

        StringBuilder jsonResponseBuilder = new StringBuilder();
        jsonResponseBuilder.append("[");

        for (int i = 0; i < medicalRecords.size(); i++) {
            MedicalRecord medicalRecord = medicalRecords.get(i);
            StringBuilder jsonTreatmentBuilder = new StringBuilder();

            for(int j=0;j<medicalRecord.getTreatment().size();j++){
                Prescription prescription = medicalRecord.getTreatment().get(j);
                jsonTreatmentBuilder = buildTreatment(prescription, jsonTreatmentBuilder);

                if (j != medicalRecord.getTreatment().size()-1){
                    jsonTreatmentBuilder.append(",");
                }
            }

            jsonResponseBuilder = bulidMedicalPatient(medicalRecord,jsonResponseBuilder,
                    jsonTreatmentBuilder);
            
            if (i < medicalRecords.size() - 1) {
                jsonResponseBuilder.append(",");
            }
        }
        
        jsonResponseBuilder.append("]"); 

        String jsonResponse = jsonResponseBuilder.toString();

        return Response.status(Response.Status.OK)
            .entity(jsonResponse)
            .type(MediaType.APPLICATION_JSON)
            .build();
    }
    
    public StringBuilder buildTreatment(Prescription prescription, StringBuilder jsonTreatmentBuilder){
        jsonTreatmentBuilder.append("{")
            .append("\"id\": ").append(prescription.getId()).append(",")
            .append("\"medication\": ").append(prescription.getMedication()).append(",")
            .append("\"dosage\": ").append(prescription.getDosage()).append(",")
            .append("\"instructions\": ").append(prescription.getInstructions()).append("\n")
        .append("}");
        
        return jsonTreatmentBuilder;
    }

    public StringBuilder bulidMedicalPatient(MedicalRecord medicalRecord,StringBuilder jsonResponseBuilder,
            StringBuilder jsonTreatmentBuilder){
        jsonResponseBuilder.append("{")
            .append("\"id\": ").append(medicalRecord.getId()).append(",")
            .append("\"patient\": {")
                .append("\"id\": ").append(medicalRecord.getPatient().getId()).append(",")
                .append("\"name\": \"").append(medicalRecord.getPatient().getName()).append("\",")
                .append("\"contactInfo\": \"").append(medicalRecord.getPatient().getContactInfo()).append("\",")
                .append("\"address\": \"").append(medicalRecord.getPatient().getAddress())
            .append("\"},")
            .append("\"diagnosis\": ").append(medicalRecord.getDiagnosis()).append(",")
            .append("\"treatment\": {")
                .append("\"prescription\": {")
                    .append(jsonTreatmentBuilder)
                .append("}")
            .append("}")
        .append("}");
        
        return jsonResponseBuilder;
    }
}