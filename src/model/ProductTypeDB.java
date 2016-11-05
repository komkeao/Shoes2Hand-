package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductTypeDB {
	private Connection con;
	public ProductTypeDB(){
		con = ConnectDatabase.getConnection();
	}
	public void insert(ProductType productType){
		try {

			PreparedStatement pStatement = con
					.prepareStatement("INSERT INTO producttype (typeName) VALUES (?)");
			pStatement.setString(1, productType.getTypeName());
			pStatement.execute();
			
		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
		
		
	}
	public void removeTypeById(int pid) {
		try {
			PreparedStatement pStatement = con.prepareStatement("DELETE FROM producttype WHERE typeID = ?");
			pStatement.setInt(1, pid);
			pStatement.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
	}
	public ArrayList<ProductType> getListType() {
		ArrayList<ProductType> productList = new ArrayList<ProductType>();

		try {
			PreparedStatement pStatement = con.prepareStatement("SELECT * FROM producttype");
			ResultSet resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				ProductType productType = new ProductType();
				productType.setTypeID(resultSet.getInt("typeID"));
				productType.setTypeName(resultSet.getString("typeName"));
				productList.add(productType);
			}
		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
		return productList;
	}

}
