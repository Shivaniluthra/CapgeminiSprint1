package com.cpg.sprint1.dao;

import java.sql.Date;

import com.cpg.sprint1.entities.User;

public interface IUser {
	public User validateUser(String user_id,String user_password);
	public User register(User user);
}