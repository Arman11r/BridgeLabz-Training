package com.clinic.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Billing {
    private int billId;
    private int appointmentId;
    private BigDecimal amount;
    private String paymentStatus; // Pending, Paid, Refunded
    private LocalDateTime billingDate;

    public Billing() {}

    public Billing(int appointmentId, BigDecimal amount) {
        this.appointmentId = appointmentId;
        this.amount = amount;
        this.paymentStatus = "Pending";
    }

    public int getBillId() { return billId; }
    public void setBillId(int billId) { this.billId = billId; }

    public int getAppointmentId() { return appointmentId; }
    public void setAppointmentId(int appointmentId) { this.appointmentId = appointmentId; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }

    public LocalDateTime getBillingDate() { return billingDate; }
    public void setBillingDate(LocalDateTime billingDate) { this.billingDate = billingDate; }

    @Override
    public String toString() {
        return "Billing{id=" + billId + ", appointmentId=" + appointmentId +
                ", amount=" + amount + ", status=" + paymentStatus + ", date=" + billingDate + "}";
    }
}