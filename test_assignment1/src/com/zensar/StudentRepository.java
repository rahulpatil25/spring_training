package com.zensar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRepository {
	public boolean checkLogin(String userName, String password) {
		boolean result = false;
		Connection con = DBUtil.getMySqlDbConnection();
		String sql = "select * from login where username=?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, userName);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String passwordFromDb = rs.getString("password");
				if(password.equals(passwordFromDb)) {
					result = true;
				}
			}
		} catch (SQLException e) {
			System.out.println("Exception occurred: " + e);
		}
		
		return result;
	}
}
