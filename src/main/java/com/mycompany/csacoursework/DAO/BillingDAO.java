/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csacoursework.DAO;


import com.mycompany.csacoursework.modelClass.Billing;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ashfaq
 */
public class BillingDAO {
    private static BillingDAO instance;
    private List<Billing> billings;
    
    private BillingDAO() {
        this.billings = new ArrayList<>();
    }

    public static synchronized BillingDAO getInstance() {
        if (instance == null) {
            instance = new BillingDAO();
        }
        return instance;
    }
    
    public void addBilling(Billing billing) {
        billings.add(billing);
        
    }

    public Billing getBillingById(int id) {
        for (Billing billing : billings) {
            if (billing.getId() == id) {
                return billing;
            }
        }
        return null;
    }

    public Billing updateBilling(Billing updatedBilling) {
        for (int i = 0; i < billings.size(); i++) {
            if (billings.get(i).getId() == updatedBilling.getId()) {
                if (updatedBilling.getPaid() == true || false ) billings.get(i).setPaid(updatedBilling.getPaid());
                if (updatedBilling.getAmount() != 0 ) billings.get(i).setAmount(updatedBilling.getAmount());
                
                return billings.get(i);
            }
        }
        return null;
    }

    public void deleteBilling(int id) {
        billings.removeIf(billing -> billing.getId() == id);
    }
    
    public List<Billing> getAllBilling() {
        return billings;
    }
}