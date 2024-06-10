/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csacoursework.resources;

/**
 *
 * @author Ashfaq
 */

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


@ApplicationPath("api")
public class MyApplication extends Application {
 @Override
 public Set<Class<?>> getClasses() {
 Set<Class<?>> classes = new HashSet<>();
 classes.add(AppointmentResource.class);
 classes.add(PersonResource.class);
 classes.add(PatientResource.class);
 classes.add(DoctorResource.class);
 classes.add(BillingResource.class);
 classes.add(MedicalRecordsResource.class);
 classes.add(PrescriptionResource.class);
 return classes;
 }
} 
