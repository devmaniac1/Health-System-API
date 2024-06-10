/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csacoursework.DAO;

import com.mycompany.csacoursework.modelClass.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Ashfaq
 */
public class PersonDAO {
    private static PersonDAO instance;
    private List<Person> persons = new ArrayList<>();

    public static synchronized PersonDAO getInstance() {
        if (instance == null) {
            instance = new PersonDAO();
        }
        return instance;
    }
    
    public void create(Person person) {
        persons.add(person);
    }

    public Person findById(int id) {
         for(Person person : persons){
             if(person.getId() == id) return person;
         }
         return null;
    }

    public Person update(Person updatedPerson) {
        for(Person person : persons){
             if(person.getId() == updatedPerson.getId()){
                 if(updatedPerson.getName() != null) person.setName(updatedPerson.getName());
                 if(updatedPerson.getContactInfo() != null) person.setContactInfo(updatedPerson.getContactInfo());
                 if(updatedPerson.getAddress() != null) person.setAddress(updatedPerson.getAddress());
                 return person;
             }
         }
         return null;
    }

    public void delete(int id) {
        persons.removeIf(person -> person.getId() == id);
    }
    
    public List<Person> getAllPersons(){
        return persons;
    }
}
