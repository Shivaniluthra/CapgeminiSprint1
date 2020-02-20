package com.cpg.sprint1.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cpg.sprint1.connection.MyDBConnection;
import com.cpg.sprint1.dao.ITestDao;
import com.cpg.sprint1.entities.Test;

public class TestDaoImpl implements ITestDao {

	Connection con = MyDBConnection.getConnection();

	@Override
	public String addTest(Test test) {

		PreparedStatement ps;
		try {
			ps = con.prepareStatement("insert into test values(?,?,?)");
			ps.setString(1, test.getTestId());
			ps.setString(2, test.getTestName());
			ps.setString(3, test.getCenter_id());
			int a = ps.executeUpdate();
			if (a > 0)
				return "Test added successfully Your test id = "+test.getTestId();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return "Unable to add test";
	}

	@Override
	public boolean removeTest(String testId) {

		String sql = "delete from test where test_id = ?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, testId);
			int a = ps.executeUpdate();
			if (a > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Test> testList(String center_id) {

		List<Test> testList = new ArrayList<>();
		PreparedStatement s;
		try {
			s = con.prepareStatement("select test_id,test_name from test where center_id=? ");
			s.setString(1,center_id);
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
				Test center = new Test();
				center.setTestId(rs.getString(1));
				center.setTestName(rs.getString(2));
				testList.add(center);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return testList;
	}

}