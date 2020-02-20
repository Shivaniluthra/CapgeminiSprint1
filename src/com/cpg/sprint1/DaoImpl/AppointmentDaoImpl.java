package com.cpg.sprint1.DaoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.cpg.sprint1.connection.MyDBConnection;
import com.cpg.sprint1.dao.IAppointmentDao;
import com.cpg.sprint1.entities.Appointment;

public class AppointmentDaoImpl implements IAppointmentDao {
	Connection con = MyDBConnection.getConnection();
	public static List<Appointment> appList = new ArrayList<>();

	/**
	 * inserting appointment in database
	 */
	@Override
	public Appointment addAppointment(Appointment a) {
		try {
			PreparedStatement ps = con.prepareStatement("insert into appointment values(id_seq.nextval,null,?,?,?)");
			ps.setString(1, a.getCenter_id());
			ps.setString(2, a.getTest_id());
			ps.setString(3, a.getApp_date());
			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println("Appointment added successfully");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return a;
	}

	@Override
	public boolean removeAppointment(Double id) {
		try {
			PreparedStatement ps = con.prepareStatement("delete from appointment where appointment_id=?");
			ps.setDouble(1, id);
			int i = ps.executeUpdate();
			if (i > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Appointment> appList(String app_date) {
		try {
			PreparedStatement s = con.prepareStatement("select * from appointment where app_date=?");
			s.setString(1, app_date);
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
				Appointment ap = new Appointment();
				ap.setAppointmentId(rs.getDouble(1));
				ap.setStatus(rs.getString(2));
				ap.setCenter_id(rs.getString(3));
				ap.setTest_id(rs.getString(4));
				ap.setApp_date(rs.getString(5));
				appList.add(ap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return appList;
	}

	@Override
	public String approveAppointment(Double id, String status) {
		try {
			PreparedStatement ps = con.prepareStatement("update appointment set appointment_status=? where appointment_id=?");
			ps.setString(1, status);
			ps.setDouble(2, id);
			int i = ps.executeUpdate();
			if (i > 0)
				return "Updated successfully";

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Not updated";
	}
}