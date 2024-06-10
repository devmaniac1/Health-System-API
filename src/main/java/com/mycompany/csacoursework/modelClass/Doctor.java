/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csacoursework.modelClass;

/**
 *
 * @author Ashfaq
 */

public class Doctor extends Person {
    private String specialization;

    public Doctor(){
        super();
        setId(IDGenerator.generateDoctorID());
    }
    
    public Doctor(String name, String contactInfo, String address, String specialization) {
        super(IDGenerator.generateDoctorID(), name, contactInfo, address);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return this.specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

}
