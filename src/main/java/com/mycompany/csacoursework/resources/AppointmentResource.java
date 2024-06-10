/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csacoursework.resources;

/**
 *
 * @author Ashfaq
 */

import com.mycompany.csacoursework.DAO.AppointmentDAO;
import com.mycompany.csacoursework.DAO.BillingDAO;
import com.mycompany.csacoursework.DAO.DoctorDAO;
import com.mycompany.csacoursework.DAO.MedicalRecordsDAO;
import com.mycompany.csacoursework.DAO.PatientDAO;
import com.mycompany.csacoursework.DAO.PrescriptionDAO;
import com.mycompany.csacoursework.modelClass.Appointment;
import com.mycompany.csacoursework.modelClass.Billing;
import com.mycompany.csacoursework.modelClass.Doctor;
import com.mycompany.csacoursework.modelClass.MedicalRecord;
import com.mycompany.csacoursework.modelClass.Patient;
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


@Path("/appointments")
@Produces(MediaType.APPLICATION_JSON)
public class AppointmentResource {
    private AppointmentDAO appointmentDAO;
    private DoctorDAO doctorDAO;
    private PatientDAO patientDAO;
    private BillingDAO billingDAO;
    private MedicalRecordsDAO medicalRecordDAO;
    private PrescriptionDAO prescriptionDAO;

    
    public AppointmentResource() {
        this.appointmentDAO = AppointmentDAO.getInstance();
        this.doctorDAO = DoctorDAO.getInstance();
        this.patientDAO = PatientDAO.getInstance();
        this.billingDAO = BillingDAO.getInstance();
        this.medicalRecordDAO = MedicalRecordsDAO.getInstance();
        this.prescriptionDAO = PrescriptionDAO.getInstance();
    }
  
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAppointment(Appointment appointment) {
        Doctor doctor = doctorDAO.getDoctorById(appointment.getDoctor().getId());
        if (doctor == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Doctor does not exist").build();
        }
        
        appointmentDAO.addAppointment(appointment);
        
        Patient patient = patientDAO.getPatientById(appointment.getPatient().getId());
        if (patient == null) {
            patient = appointment.getPatient();
            patientDAO.addPatient(patient);
        }
        
        updateFields(appointment,patient,doctor);

        return Response.status(Response.Status.CREATED).entity(appointment).build();

    }

    @GET
    @Path("/{id}")
    public Response getAppointmentById(@PathParam("id") int id) {
        Appointment appointment = appointmentDAO.getAppointmentById(id);
        if (appointment != null) {
            return Response.ok(appointment).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Appointment not found").build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAppointment(@PathParam("id") int id, Appointment updatedAppointment) {
        updatedAppointment.setId(id);
        updatedAppointment = appointmentDAO.updateAppointment(updatedAppointment);
        
        if (updatedAppointment == null) 
            return Response.status(Response.Status.BAD_REQUEST)
                .entity("Appointment not found").build();
        return Response.status(Response.Status.OK).entity(updatedAppointment).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteAppointment(@PathParam("id") int id) {
        appointmentDAO.deleteAppointment(id);
        return Response.ok().build();
    }

    @GET
    public List<Appointment> getAllAppointments() {
        List<Appointment> appointments = appointmentDAO.getAllAppointment();
        return appointments;
    }
    
    public void updateFields(Appointment appointment, Patient patient, Doctor doctor){
        
        Billing billing = new Billing();
        billing.setAppointmentId(appointment.getId());
        billing.setPatientId(patient.getId());
        billing.setAmount(2900);
        billingDAO.addBilling(billing);
        
        
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setBilling(billing);
        
        Prescription prescription = new Prescription();
        prescription.setDoctor(doctor);
        prescription.setPatient(patient);
        prescriptionDAO.addPrescription(prescription);
//        
//        
        MedicalRecord medicalRecord = medicalRecordDAO.getMedicalByPatientId(patient.getId());
        if (medicalRecord == null){
            medicalRecord = new MedicalRecord();
            medicalRecordDAO.addMedicalRecord(medicalRecord);
        }
        medicalRecord.addAppointment(appointment);
        medicalRecord.setDoctor(doctor);
        medicalRecord.setPatient(patient);
        medicalRecord.addTreatment(prescription); 
    }
}
