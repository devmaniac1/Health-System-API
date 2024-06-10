/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csacoursework.modelClass;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Ashfaq
 */
public class MedicalRecord {
    private int id;
    private Patient patient;
    private Doctor doctor;
    private String diagnosis;
    private List<Prescription> treatments;
    private List<Appointment> appointments;
    
    public MedicalRecord(){
        this.treatments = new ArrayList<>();
        this.appointments = new ArrayList<>();
    }

    public MedicalRecord(Patient patient, String diagnosis,Doctor doctor,Appointment appointment) {
        this.id = IDGenerator.generateMedicalRecordID();
        this.patient = patient;
        this.diagnosis = diagnosis;
        this.doctor = doctor;
        this.treatments = new ArrayList<>();
        this.appointments = new ArrayList<>();
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public List<Appointment> getAppointment() {
        return appointments;
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDiagnosis() {
        return this.diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public List<Prescription> getTreatment() {
        return this.treatments;
    }

    public void addTreatment(Prescription prescription) {
        treatments.add(prescription);
    }
    

    // Getters and setters
}