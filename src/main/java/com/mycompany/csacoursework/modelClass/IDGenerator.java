/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csacoursework.modelClass;

/**
 *
 * @author Ashfaq
 */
public class IDGenerator {
    private static int doctorCounter = 1;
    private static int patientCounter = 1;
    private static int appointmentCounter = 1;
    private static int medicalRecordCounter = 1;
    private static int prescriptionCounter = 1;
    private static int billingCounter = 1;
    

    public static synchronized int generateDoctorID() {
        return doctorCounter++;
    }
    public static synchronized int generatePatientID() {
        return patientCounter++;
    }
    public static synchronized int generateAppointmentID() {
        return appointmentCounter++;
    }
    public static synchronized int generateMedicalRecordID() {
        return medicalRecordCounter++;
    }
    public static synchronized int generatePrescriptionID() {
        return prescriptionCounter++;
    }
    public static synchronized int generateBillingID() {
        return billingCounter++;
    }
    
}
