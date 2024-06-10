/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csacoursework.DAO;

import com.mycompany.csacoursework.modelClass.Patient;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Ashfaq
 */

public class PatientDAO {
    private List<Patient> patients;
    private static PatientDAO instance;

    public PatientDAO() {
        this.patients = new ArrayList<>();
    }
    
    public static synchronized PatientDAO getInstance() {
        if (instance == null) {
            instance = new PatientDAO();
        }
        return instance;
    }

    public Patient addPatient(Patient patient) {
        patients.add(patient);
        return patient;
    }

    public Patient getPatientById(int id) {
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }

    public Patient updatePatient(Patient updatedPatient) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getId() == updatedPatient.getId()) {
                if (updatedPatient.getName() != null) patients.get(i).setName(updatedPatient.getName());
                if (updatedPatient.getAddress() != null) patients.get(i).setAddress(updatedPatient.getAddress());
                if (updatedPatient.getContactInfo() != null) patients.get(i).setContactInfo(updatedPatient.getContactInfo());
                if (updatedPatient.getCurrentHealthStatus()!= null) patients.get(i).setCurrentHealthStatus(updatedPatient.getCurrentHealthStatus());
                return patients.get(i);
            }
        }
        return null;
    }

    public void deletePatient(int id) {
        patients.removeIf(patient -> patient.getId() == id);
    }

    public List<Patient> getAllPatients() {
        return patients;
    }
}