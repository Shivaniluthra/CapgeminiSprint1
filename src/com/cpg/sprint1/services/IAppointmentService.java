package com.cpg.sprint1.services;

import java.sql.Date;
import java.util.List;

import com.cpg.sprint1.entities.Appointment;

public interface IAppointmentService {
public Appointment addAppointment(Appointment a);
public boolean removeAppointment(Double id);
public List<Appointment> appList(String date);
public String approveAppointment(Double id, String status);
}