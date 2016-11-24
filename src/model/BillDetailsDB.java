package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

public class BillDetailsDB {
	private Connection con;

	public BillDetailsDB() {
		con = ConnectDatabase.getConnection();
	}

	//

	public ArrayList<BillDetails> getBillList() {
		ArrayList<BillDetails> BillDetailList = new ArrayList<BillDetails>();

		try {
			PreparedStatement pStatement = con
					.prepareStatement("SELECT * FROM Bill Order By bid DESC");
			ResultSet resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				BillDetails billDetail = new BillDetails();
				int billDetailID = resultSet.getInt("bid");
				String bookingtime = resultSet.getString("bookingTime");
				String payTime = resultSet.getString("payTime");
				String sendaddress = resultSet.getString("sentaddress");
				int userID = resultSet.getInt("userID");
				billDetail.setBid(billDetailID);
				billDetail.setBookingTime(bookingtime);
				billDetail.setPayTime(payTime);
				billDetail.setSendAddress(sendaddress);
				billDetail.setUserID(userID);
				String imgDataBase64 = new String(Base64.getEncoder().encode(
						resultSet.getBytes("photo")));
				String src = "data:image/jpg;base64,";
				src = src.concat(imgDataBase64);
				billDetail.setPhoto(src);
				PreparedStatement subPStatementUser = con
						.prepareStatement("SELECT username FROM User WHERE UserID = ?");
				subPStatementUser.setInt(1, userID);
				ResultSet subReuultSet = subPStatementUser.executeQuery();
				if (subReuultSet.next()) {
					String username = subReuultSet.getString("username");
					billDetail.setUsername(username);
				}
				PreparedStatement tPStatementUser = con
						.prepareStatement("SELECT SUM(product.price) FROM orderlist,product "
								+ " WHERE bid=? AND orderlist.pid=product.pid");
				tPStatementUser.setInt(1, billDetailID);
				ResultSet tReuultSet = tPStatementUser.executeQuery();
				if (tReuultSet.next()) {
					billDetail.setPrice(tReuultSet.getString(1));
				}
				BillDetailList.add(billDetail);
			}
		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
		return BillDetailList;
	}
}
