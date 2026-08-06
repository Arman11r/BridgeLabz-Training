package com.clinic;

import com.clinic.dao.PatientDAO;
import com.clinic.dao.PatientDAOImpl;
import com.clinic.dto.Patient;

public class TestPatientDAO {
    public static void main(String[] args) {
        PatientDAO dao = new PatientDAOImpl();

        int newId = dao.insertPatient(new Patient("Arman", "Test", "arman.test@email.com"));
        System.out.println("Inserted with ID: " + newId);

        Patient found = dao.getPatientById(newId);
        System.out.println("Fetched back: " + found);
    }
}