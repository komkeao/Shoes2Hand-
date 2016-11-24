package model;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BillDB {
	private Connection con;
	public BillDB() {
		con = ConnectDatabase.getConnection();
	}
	
	//////////
	public void add (Bill bill,InputStream inps){
		System.out.println("2");
		String sql = "INSERT INTO Bill(sentAddress,userID,photo,bookingTime,payTime) "
				+ "VALUES (?,?,?,now(),now())";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, bill.getSendAddress());
			statement.setInt(2, bill.getUserID());
			statement.setBlob(3, inps);
			statement.executeUpdate();
			System.out.println("3");

		} catch (SQLException e) {
			System.err.println("Error Insert data :" + e);
			System.out.println("4");
		}
	}
	public int getLastIndex(){
		int res=0;
		String sql = "SELECT bid From Bill Order By bid DESC";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet tReuultSet = statement.executeQuery();
			if(tReuultSet.next()){
				res=tReuultSet.getInt("bid");
			}
		} catch (SQLException e) {
			System.err.println("Error Insert data :" + e);
		}
		return res;
	}
		//REMOVE 
		public void Billdelete (Bill bill){
			String sql = "DELETE FROM Bill WHERE bid=?";
					try {
				PreparedStatement statement = con.prepareStatement(sql);
				statement.setString(1, bill.getBookingTime());
				statement.setString(2, bill.getPayTime());
				statement.setString(3, bill.getSendAddress());
				statement.setInt(4, bill.getUserID());
				
				statement.executeUpdate();

			} catch (SQLException e) {
				System.err.println("Error Insert data :" + e);
			}
		
		
	}
}
