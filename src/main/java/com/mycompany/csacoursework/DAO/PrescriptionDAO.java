/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csacoursework.DAO;

import com.mycompany.csacoursework.modelClass.Prescription;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ashfaq
 */
public class PrescriptionDAO {
    private static PrescriptionDAO instance;
    private List<Prescription> prescriptions;
    
    private PrescriptionDAO() {
        this.prescriptions = new ArrayList<>();
    }

    public static synchronized PrescriptionDAO getInstance() {
        if (instance == null) {
            instance = new PrescriptionDAO();
        }
        return instance;
    }
    
    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
        
    }

    public Prescription getPrescriptionById(int id) {
        for (Prescription prescription : prescriptions) {
            if (prescription.getId() == id) {
                return prescription;
            }
        }
        return null;
    }

    public Prescription updatePrescription(Prescription updatedPrescription) {
        for (int i = 0; i < prescriptions.size(); i++) {
            if (prescriptions.get(i).getId() == updatedPrescription.getId()) {
                if (updatedPrescription.getMedication()!=null) prescriptions.get(i).setMedication(updatedPrescription.getMedication());
                if (updatedPrescription.getDosage()!=null) prescriptions.get(i).setDosage(updatedPrescription.getDosage());
                if (updatedPrescription.getInstructions()!=null) prescriptions.get(i).setInstructions(updatedPrescription.getInstructions());
                return prescriptions.get(i);
            }
        }
        return null;
    }

    public void deletePrescription(int id) {
        prescriptions.removeIf(prescription -> prescription.getId() == id);
    }
    
    public List<Prescription> getAllPrescription() {
        return prescriptions;
    }
}