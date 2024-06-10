/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csacoursework.DAO;

import com.mycompany.csacoursework.modelClass.Appointment;
import com.mycompany.csacoursework.modelClass.IDGenerator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ashfaq
 */
public class AppointmentDAO {
    private static AppointmentDAO instance;
    private List<Appointment> appointments;
    
    private AppointmentDAO() {
        this.appointments = new ArrayList<>();
    }

    public static synchronized AppointmentDAO getInstance() {
        if (instance == null) {
            instance = new AppointmentDAO();
        }
        return instance;
    }
    
    public void addAppointment(Appointment appointment) {
        appointment.setId(IDGenerator.generateAppointmentID());
        appointments.add(appointment);
        
    }

    public Appointment getAppointmentById(int id) {
        for (Appointment appointment : appointments) {
            if (appointment.getId() == id) {
                return appointment;
            }
        }
        return null;
    }

    public Appointment updateAppointment(Appointment updatedAppointment) {
        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).getId() == updatedAppointment.getId()) {
                if (updatedAppointment.getDateTime()!=null) appointments.get(i).setDateTime(updatedAppointment.getDateTime());
                return appointments.get(i);
            }
        }
        return null;
    }

    public void deleteAppointment(int id) {
        appointments.removeIf(appointment -> appointment.getId() == id);
    }
    
    public List<Appointment> getAllAppointment() {
        return appointments;
    }
}