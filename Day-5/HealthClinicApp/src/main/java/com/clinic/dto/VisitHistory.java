package com.clinic.dto;

public class VisitHistory {
    private int visitId;
    private int appointmentId;
    private String diagnosis;
    private String prescription;
    private String visitNotes;

    public VisitHistory() {}

    public VisitHistory(int appointmentId, String diagnosis, String prescription, String visitNotes) {
        this.appointmentId = appointmentId;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
        this.visitNotes = visitNotes;
    }

    public int getVisitId() { return visitId; }
    public void setVisitId(int visitId) { this.visitId = visitId; }

    public int getAppointmentId() { return appointmentId; }
    public void setAppointmentId(int appointmentId) { this.appointmentId = appointmentId; }

    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    public String getPrescription() { return prescription; }
    public void setPrescription(String prescription) { this.prescription = prescription; }

    public String getVisitNotes() { return visitNotes; }
    public void setVisitNotes(String visitNotes) { this.visitNotes = visitNotes; }

    @Override
    public String toString() {
        return "VisitHistory{id=" + visitId + ", appointmentId=" + appointmentId +
                ", diagnosis=" + diagnosis + ", prescription=" + prescription + "}";
    }
}