package model;
import java.sql.Date;

public class Appointment {

    private int patientId;
    private int doctorId;
    private Date date;

    public Appointment(int patientId, int doctorId, Date date) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
    }

    public int getPatientId() { return patientId; }
    public int getDoctorId() { return doctorId; }
    public Date getDate() { return date; }
}