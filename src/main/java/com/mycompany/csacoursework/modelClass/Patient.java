/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csacoursework.modelClass;
/**
 *
 * @author Ashfaq
 */

public class Patient extends Person {
    private MedicalRecord medicalRecord;
    private String currentHealthStatus;

    public Patient() {
        super();
        setId(IDGenerator.generatePatientID());
    }

    public Patient(String name, String contactInfo, String address){
        super(IDGenerator.generatePatientID(), name, contactInfo, address);
    }
    
    public Patient(String name, String contactInfo, String address, MedicalRecord medicalRecord, String currentHealthStatus) {
        super(IDGenerator.generatePatientID(), name, contactInfo, address);
        this.medicalRecord = medicalRecord;
        this.currentHealthStatus = currentHealthStatus;
    }

    public MedicalRecord getMedicalRecord() {
        return this.medicalRecord;
    }

    public void setMedicalHistory(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public String getCurrentHealthStatus() {
        return this.currentHealthStatus;
    }

    public void setCurrentHealthStatus(String currentHealthStatus) {
        this.currentHealthStatus = currentHealthStatus;
    } 
}
