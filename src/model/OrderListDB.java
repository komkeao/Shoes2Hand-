package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderListDB {
	private Connection con;
	public OrderListDB() {
		con = ConnectDatabase.getConnection();
	}
	////////////
	public void Insert(OrderList orderlist){
		String sql = "INSERT INTO OrderList(bid,pid) "
				+ "VALUES (?,?)";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, orderlist.getBid());
			statement.setInt(2, orderlist.getPid());
			statement.executeUpdate();

		} catch (SQLException e) {
			System.err.println("Error Insert data :" + e);
		}
		
		
	}
}
