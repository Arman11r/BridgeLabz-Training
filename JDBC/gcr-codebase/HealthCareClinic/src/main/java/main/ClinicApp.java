package main;

import dao.*;
import model.*;

import java.sql.Date;
import java.util.*;

public class ClinicApp {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        PatientDAO patientDAO = new PatientDAO();
        DoctorDAO doctorDAO = new DoctorDAO();
        AppointmentDAO appointmentDAO = new AppointmentDAO();

        while(true) {

            System.out.println("\n===== CLINIC SYSTEM =====");
            System.out.println("1 Add Patient");
            System.out.println("2 View Patients");
            System.out.println("3 Add Doctor");
            System.out.println("4 View Doctors");
            System.out.println("5 Book Appointment");
            System.out.println("6 Exit");

            int ch = sc.nextInt();

            switch(ch) {

                case 1:
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Phone: ");
                    String phone = sc.nextLine();

                    patientDAO.addPatient(new Patient(name, phone));
                    System.out.println("Patient added!");
                    break;

                case 2:
                    patientDAO.getAll().forEach(
                            p -> System.out.println(p.getId()+" "+p.getName())
                    );
                    break;

                case 3:
                    sc.nextLine();
                    System.out.print("Doctor Name: ");
                    String dn = sc.nextLine();
                    System.out.print("Specialization: ");
                    String sp = sc.nextLine();

                    doctorDAO.addDoctor(new Doctor(dn, sp));
                    break;

                case 4:
                    doctorDAO.getAll().forEach(
                            d -> System.out.println(d.getId()+" "+d.getName())
                    );
                    break;

                case 5:
                    System.out.print("Patient ID: ");
                    int pid = sc.nextInt();
                    System.out.print("Doctor ID: ");
                    int did = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Date (yyyy-mm-dd): ");
                    String date = sc.nextLine();

                    appointmentDAO.bookAppointment(
                            new Appointment(pid, did, Date.valueOf(date))
                    );

                    System.out.println("Appointment booked!");
                    break;

                case 6:
                    return;
            }
        }
    }
}