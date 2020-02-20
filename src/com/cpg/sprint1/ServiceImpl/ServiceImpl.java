package com.cpg.sprint1.ServiceImpl;

import java.sql.Date;

import com.cpg.sprint1.DaoImpl.UserDao;
import com.cpg.sprint1.dao.IUser;
import com.cpg.sprint1.entities.User;
import com.cpg.sprint1.exceptions.NullArgumentException;
import com.cpg.sprint1.services.IService;

public class ServiceImpl implements IService{

	IUser dao = new UserDao();
	public ServiceImpl(IUser dao) {
		this.dao=dao;
	}
	@Override
	public User register(User user) {
		if(user== null) {
			throw new NullArgumentException("Null argument entered");
		}
		long n = user.getContactNo(); int count=0;
		while(n!=0)
		{
			count++;
			n=n/10;
		}
		if(user.getUserName().length()>0 && user.getUserName().matches("^([A-Z]+)([A-Za-z]+)") && !(user.getUserName().matches("^[!@#$%^&*]"))) {
			Double num=Math.random();
			String id=user.getUserName().substring(0,3)+num.toString().substring(2,6);
			if(user.getEmailId().matches("([A-Za-z0-9\\._]+)@([A-Za-z]{2,8}).([a-zA-Z]{2,3}).([a-zA-Z]{2})?")) {
				if(user.getUserPassword().matches("([A-Za-z0-9!@#$%^&*_]{8,14})+")) {
					if(count==10) {
						user.setUserId(id);
						return dao.register(user);
					}
					else {
						System.out.println("Enter 10 digit contact number");
					}
				}
				else {
					System.out.println("Password must contain one number,one alphabet,"
							+ "one special character and size should be at least 8 characters and not more than 14 characters.");
				}
			}
		else {
			System.out.println("Email invalid");
			}	
		}
		else {
			System.out.println("Name should not start with special characters and should not be blank. First letter should be capital");
		}
		return user;
	}

	@Override
	public User validateUser(String user_id, String user_password) {
		if(user_id.length()>2 && user_password.length()>=3 || user_password.length()<9) {
			return dao.validateUser(user_id, user_password);
		}
		return null;
	}
}


