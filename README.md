# Health System API

## Overview

This repository contains the implementation of a RESTful API for a Health System. The API is designed to manage various entities in a healthcare system, including patients, doctors, appointments, medical records, billing, and prescriptions. It follows the principles of REST architecture and is built using the JAX-RS framework.

## Introduction

Representational State Transfer (REST) has become the accepted architectural model for networked application architecture in modern web development. Based on REST principles, this Health System API provides a standardized method for developing web services that enable communication across different software systems.

## Principles of REST Architecture

Client-Server Architecture: Separation of client and server roles to promote scalability.
Statelessness: Each client request contains all the information needed for the server to fulfill that request.
Resource-Based Interactions: Resources are uniquely identified using URIs and are manipulated using standard HTTP methods (GET, POST, PUT, DELETE).
State Transfer: Use of representations (XML or JSON) to transfer the state between client and server.

## JAX-RS Framework

The API is built using JAX-RS (Java API for RESTful Web Services), which provides a standard way to create RESTful web services in Java.

## Features

- CRUD operations for healthcare system entities.
- Entity management through DAO (Data Access Object) classes.
- RESTful resources for each entity.
- Comprehensive testing with Postman.

## Installation

Clone the repository: (git clone https://github.com/username/health-system-api.git)
Navigate to the project directory: (cd health-system-api)
Build the project and Run the application: Access the API at (http://localhost:8080/api)

## API Endpoints

### Person Resource
- GET /persons: Retrieve all persons.
- GET /persons/{id}: Retrieve a person by ID.
- POST /persons: Create a new person.
- PUT /persons/{id}: Update a person by ID.
- DELETE /persons/{id}: Delete a person by ID.

### Doctor Resource
- GET /doctors: Retrieve all doctors.
- GET /doctors/{id}: Retrieve a doctor by ID.
- POST /doctors: Create a new doctor.
- PUT /doctors/{id}: Update a doctor by ID.
- DELETE /doctors/{id}: Delete a doctor by ID.

### Patient Resource
- GET /patients: Retrieve all patients.
- GET /patients/{id}: Retrieve a patient by ID.
- POST /patients: Create a new patient.
- PUT /patients/{id}: Update a patient by ID.
- DELETE /patients/{id}: Delete a patient by ID.

### Appointment Resource
- GET /appointments: Retrieve all appointments.
- GET /appointments/{id}: Retrieve an appointment by ID.
- POST /appointments: Create a new appointment.
- PUT /appointments/{id}: Update an appointment by ID.
- DELETE /appointments/{id}: Delete an appointment by ID.

### Medical Record Resource
- GET /medical-records: Retrieve all medical records.
- GET /medical-records/{id}: Retrieve a medical record by ID.
- POST /medical-records: Create a new medical record.
- PUT /medical-records/{id}: Update a medical record by ID.
- DELETE /medical-records/{id}: Delete a medical record by ID.

### Billing Resource
- GET /billings: Retrieve all billings.
- GET /billings/{id}: Retrieve a billing by ID.
- POST /billings: Create a new billing.
- PUT /billings/{id}: Update a billing by ID.
- DELETE /billings/{id}: Delete a billing by ID.

### Prescription Resource
- GET /prescriptions: Retrieve all prescriptions.
- GET /prescriptions/{id}: Retrieve a prescription by ID.
- POST /prescriptions: Create a new prescription.
- PUT /prescriptions/{id}: Update a prescription by ID.
- DELETE /prescriptions/{id}: Delete a prescription by ID.

## Conclusion

The implementation of the Health System API demonstrates the application of RESTful principles using the JAX-RS framework. This API offers a robust and scalable solution for healthcare management, ensuring ease of use and integration with various systems.
