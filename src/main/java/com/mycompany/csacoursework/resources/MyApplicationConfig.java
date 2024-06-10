/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csacoursework.resources;

/**
 *
 * @author Ashfaq
 */
import org.glassfish.jersey.server.ResourceConfig;


public class MyApplicationConfig extends ResourceConfig {
 public MyApplicationConfig() {
 register(AppointmentResource.class);
 register(PersonResource.class);
 register(PatientResource.class);
 register(DoctorResource.class);
 register(BillingResource.class);
 register(MedicalRecordsResource.class);
 register(PrescriptionResource.class);
 }
} 