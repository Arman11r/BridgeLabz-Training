package com.clinic.dao;

import com.clinic.dto.VisitHistory;
import java.util.List;

public interface VisitHistoryDAO {
    int insertVisitHistory(VisitHistory visitHistory);
    VisitHistory getVisitHistoryByAppointmentId(int appointmentId);
    List<VisitHistory> getAllVisitHistory();
}