/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csacoursework.modelClass;

/**
 *
 * @author Ashfaq
 */
public class Appointment {
    private int id;
    private String dateTime;
    private Patient patient;
    private Doctor doctor;
    private Billing billing;
    

    public Appointment(){}
    
    public Appointment(String dateTime, Patient patient, Doctor doctor,Billing billing) {
        this.id = IDGenerator.generateAppointmentID();
        this.dateTime = dateTime;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateTime() {
        return this.dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return this.doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
    public Billing getBilling() {
        return this.billing;
    }

    public void setBilling(Billing billing) {
        this.billing = billing;
    }
    
}