package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BillDetailsDB {
	private Connection con;
	public BillDetailsDB() {
		con = ConnectDatabase.getConnection();
	}
//

	public ArrayList<BillDetails> getBookingDetailList(int bid) {
		ArrayList<BillDetails> BillDetailList = new ArrayList<BillDetails>();
		BillDetails billDetail = new BillDetails();
		try {
			PreparedStatement pStatement = con.prepareStatement("SELECT * FROM Bill WHERE bid = ?");
			pStatement.setInt(1, bid);
			ResultSet resultSet = pStatement.executeQuery();
			if (resultSet.next()) {
				int billDetailID = resultSet.getInt("bid");
				String bookingtime = resultSet.getString("bookingTime");
				String payTime = resultSet.getString("payTime");
				String sendaddress = resultSet.getString("sendaddress");
				int userID = resultSet.getInt("userID");
				billDetail.setBid(billDetailID);
				billDetail.setBookingTime(bookingtime);
				billDetail.setPayTime(payTime);
				billDetail.setSendAddress(sendaddress);
				billDetail.setUserID(userID);
				PreparedStatement subPStatementUser = con.prepareStatement("SELECT username FROM User WHERE UserID = ?");
				subPStatementUser.setInt(1, userID);
				ResultSet subReuultSet = subPStatementUser.executeQuery();
				if (subReuultSet.next()) {
					String username = subReuultSet.getString("username");
					billDetail.setUsername(username);
				}
				PreparedStatement tPStatementUser = con.prepareStatement("SELECT pname,price,description FROM Product "
						+ " WHERE bid=?");
				tPStatementUser.setInt(1, bid);
				ResultSet tReuultSet = tPStatementUser.executeQuery();
				if (tReuultSet.next()) {
					billDetail.setPname(tReuultSet.getString("pname"));
					billDetail.setPrice(tReuultSet.getString("price"));
					billDetail.setDescription(tReuultSet.getString("description"));
				}
				BillDetailList.add(billDetail);
			}
		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
		return BillDetailList;
	}
}
