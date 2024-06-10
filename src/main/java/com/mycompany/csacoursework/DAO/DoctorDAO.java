/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csacoursework.DAO;


import com.mycompany.csacoursework.modelClass.Doctor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ashfaq
 */
public class DoctorDAO {
    private static DoctorDAO instance;
    private List<Doctor> doctors;
    
    private DoctorDAO() {
        this.doctors = new ArrayList<>();
    }

    public static synchronized DoctorDAO getInstance() {
        if (instance == null) {
            instance = new DoctorDAO();
        }
        return instance;
    }
    
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        
    }

    public Doctor getDoctorById(int id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        return null;
    }

    public Doctor updateDoctor(Doctor updatedDoctor) {
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getId() == updatedDoctor.getId()) {
                if (updatedDoctor.getName() != null) doctors.get(i).setName(updatedDoctor.getName());
                if (updatedDoctor.getAddress() != null) doctors.get(i).setAddress(updatedDoctor.getAddress());
                if (updatedDoctor.getContactInfo() != null) doctors.get(i).setContactInfo(updatedDoctor.getContactInfo());
                if (updatedDoctor.getSpecialization() != null) doctors.get(i).setSpecialization(updatedDoctor.getSpecialization());
                return doctors.get(i);
            }
        }
        return null;
    }

    public void deleteDoctor(int id) {
        doctors.removeIf(doctor -> doctor.getId() == id);
    }
    
    public List<Doctor> getAllDoctor() {
        return doctors;
    }
}