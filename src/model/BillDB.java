package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BillDB {
	private Connection con;
	public BillDB() {
		con = ConnectDatabase.getConnection();
	}
	
	//////////
	public void Billinsert (Bill bill){
		String sql = "INSERT INTO Bill(bookingTime, playTime, sendAddress,userID) "
				+ "VALUES (?,?,?,?)";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, bill.getBookingTime());
			statement.setString(2, bill.getPayTime());
			statement.setString(3, bill.getSendAddress());
			statement.setString(4, bill.getUserID());
			
			statement.executeUpdate();

		} catch (SQLException e) {
			System.err.println("Error Insert data :" + e);
		}
	}
		//REMOVE 
		public void Billdelete (Bill bill){
			String sql = "DELETE FROM Bill WHERE bid=?";
					try {
				PreparedStatement statement = con.prepareStatement(sql);
				statement.setString(1, bill.getBookingTime());
				statement.setString(2, bill.getPayTime());
				statement.setString(3, bill.getSendAddress());
				statement.setString(4, bill.getUserID());
				
				statement.executeUpdate();

			} catch (SQLException e) {
				System.err.println("Error Insert data :" + e);
			}
		
		
	}
}
