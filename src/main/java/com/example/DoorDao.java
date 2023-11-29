package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	public static ArrayList<Door> getAllDoors() throws SQLException {
		Connection con = DBHelper.getConnection();
		String query = "select * from doors";
		
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Door> doors = new ArrayList<>();
		
		while(rs.next()) {
			Door d = new Door(rs.getInt("id"), rs.getString("material"), rs.getDouble("height"), rs.getDouble("width"), rs.getDate("installationDate").toLocalDate());
			doors.add(d);
		}
		DBHelper.closeConnection();
		return doors;
	}

	public void insertDoor (Door doorParam) throws SQLException {
		Connection con = DBHelper.getConnection();
		String query = "insert into doors (material, height, width) values (??)";
		PreparedStatement prepStmt = con.prepareStatement (query);
		
		prepStmt.setString(1, doorParam.getMaterial());
		prepStmt.setDouble(2, doorParam.getHeight());
		prepStmt.setDouble(3, doorParam.getWidth());
		
		prepStmt.executeUpdate();
	}
}
