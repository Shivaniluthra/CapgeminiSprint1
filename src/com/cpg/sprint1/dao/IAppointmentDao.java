package com.cpg.sprint1.dao;

import java.sql.Date;
import java.util.List;

import com.cpg.sprint1.entities.Appointment;

public interface IAppointmentDao {
public Appointment addAppointment(Appointment a);
public boolean removeAppointment(Double id);
public List<Appointment> appList(String app_date);
public String approveAppointment(Double id, String status);

}