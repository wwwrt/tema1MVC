package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoorDao {
	
	public Door getById(int id) throws SQLException {
		Connection con = DBHelper.getConnection();
		String query = "select * from doors where id=?";
		PreparedStatement ps = con.prepareStatement(query);
		
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		

		while (rs.next()) {
			Door d = new Door(rs.getInt("id"), rs.getString("material"), rs.getDouble("height"), rs.getDouble("width"), rs.getDate("installationDate").toLocalDate());
			DBHelper.closeConnection();
			return d;
		}
		DBHelper.closeConnection();
		
		return null;
	}

}
