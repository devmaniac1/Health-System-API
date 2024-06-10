/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csacoursework.DAO;

import com.mycompany.csacoursework.modelClass.MedicalRecord;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ashfaq
 */
public class MedicalRecordsDAO {
    private static MedicalRecordsDAO instance;
    private List<MedicalRecord> medicalRecords;
    
    private MedicalRecordsDAO() {
        this.medicalRecords = new ArrayList<>();
    }

    public static synchronized MedicalRecordsDAO getInstance() {
        if (instance == null) {
            instance = new MedicalRecordsDAO();
        }
        return instance;
    }
    
    public void addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecords.add(medicalRecord);
        
    }

    public MedicalRecord getMedicalRecordById(int id) {
        for (MedicalRecord medicalRecord : medicalRecords) {
            if (medicalRecord.getId() == id) {
                return medicalRecord;
            }
        }
        return null;
    }

    public void updateMedicalRecord(MedicalRecord updatedMedicalRecord) {
        for (int i = 0; i < medicalRecords.size(); i++) {
            if (medicalRecords.get(i).getPatient().getId() == updatedMedicalRecord.getId()) {
                if (updatedMedicalRecord.getDiagnosis() != null) medicalRecords.get(i).setDiagnosis(updatedMedicalRecord.getDiagnosis());
                return;   
            }
        }
    }

    public void deleteMedicalRecord(int id) {
        medicalRecords.removeIf(medicalRecord -> medicalRecord.getPatient().getId() == id);
    }
    
    public List<MedicalRecord> getAllMedicalRecord() {
        return medicalRecords;
    }
    
    public MedicalRecord getMedicalByPatientId(int Id){
        
        for(MedicalRecord medicalRecord : medicalRecords){
            if (medicalRecord.getPatient().getId() == Id){
                return medicalRecord;
            }
        }
        return null;
    }
}
