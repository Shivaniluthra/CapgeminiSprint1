package com.cpg.sprint1.DaoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.cpg.sprint1.ServiceImpl.AppointmentServiceImpl;
import com.cpg.sprint1.connection.MyDBConnection;
import com.cpg.sprint1.dao.IUser;
import com.cpg.sprint1.entities.User;
import com.cpg.sprint1.services.IAppointmentService;

public class UserDao implements IUser{
	private Connection con = MyDBConnection.getConnection();
	/**
	 * For the connection.
	 */
	public User validateUser(String user_id, String user_password) {
		User u = null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from user_ where user_id=? and user_password=?");
			ps.setString(1, user_id);
			ps.setString(2, user_password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				u = new User(rs.getString(2),rs.getString(3),rs.getString(4),rs.getLong(5),rs.getString(6), rs.getInt(7),rs.getString(8));
				return u;
			}
		} catch (SQLException e) {
			return u;
		}
		return u;
		
	}
	@Override
	public User register(User user) {
		try { String sql="insert into user_(user_id,username,user_email,user_password,contact_no,gender,age,user_role)"+"values(?,?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, user.getUserId());
			pst.setString(2, user.getUserName());
			pst.setString(3, user.getEmailId());
			pst.setString(4, user.getUserPassword());
			pst.setLong(5, user.getContactNo());
			pst.setString(6, user.getGender());
			pst.setInt(7, user.getAge());
			pst.setString(8, user.getUser_role());
			int a= pst.executeUpdate();
			if(a>0) 
				System.out.println("Welcome to the healthcare system. Your UserId is "+user.getUserId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}