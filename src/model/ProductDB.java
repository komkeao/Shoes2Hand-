package model;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

public class ProductDB {
	private Connection con;
	public ProductDB() {
		con = ConnectDatabase.getConnection();
	}
	public void insert(Product product,InputStream photo){
		System.out.println(photo);
		try {
			PreparedStatement pStatement = con
					.prepareStatement("INSERT INTO product ( pname, price, status, description,typeID,photo) VALUES (?,?,?,?,?,?)");
			pStatement.setString(1, product.getpName());
			pStatement.setInt(2, product.getPrice());
			pStatement.setInt(3, product.getStatus());
			pStatement.setString(4, product.getDescription());
			pStatement.setInt(5, product.getTypeID());
			pStatement.setBlob(6, photo);
			pStatement.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
		
		
	}
	public void removeProductById(int pid) {
		try {
			PreparedStatement pStatement = con.prepareStatement("DELETE FROM product WHERE pid = ?");
			pStatement.setInt(1, pid);
			pStatement.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
	}
	
	public void updateStatusById(int pid,int status) {
		try {
			PreparedStatement pStatement = con.prepareStatement("UPDATE product SET status = ? WHERE pid = ?");
			pStatement.setInt(1, status);
			pStatement.setInt(2, pid);
			pStatement.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
	}
	
	public Product getProductById(int pid) {
		Product product = new Product();
		try {
			PreparedStatement pStatement = con.prepareStatement("SELECT * FROM product WHERE pid=?");
			pStatement.setInt(1, pid);
			ResultSet resultSet = pStatement.executeQuery();
			if (resultSet.next()) {
				product.setPid(pid);
				product.setpName(resultSet.getString("pname"));
				product.setPrice(resultSet.getInt("price"));
				product.setStatus(resultSet.getInt("status"));
				product.setDescription(resultSet.getString("description"));
				product.setTypeID(resultSet.getInt("typeID"));
				String imgDataBase64 = new String(Base64.getEncoder().encode(resultSet.getBytes("photo")));
	        	String src = "data:image/jpg;base64,";
	        	src = src.concat(imgDataBase64);
	        	product.setPhoto(src);
				try {
					PreparedStatement pStatement1 = con.prepareStatement("SELECT * FROM producttype WHERE typeID=?");
					pStatement1.setInt(1, resultSet.getInt("typeID"));
					ResultSet resultSet1 = pStatement1.executeQuery();
					if (resultSet.next()) {
						product.setTypeName(resultSet1.getString("typeName"));
					}
				} catch (SQLException e) {
					product.setPid(0);
					System.err.println("Error: " + e);
				}
			}
		} catch (SQLException e) {
			product.setPid(0);
			System.err.println("Error: " + e);
		}
		return product;
	}
	public ArrayList<Product> getProductListByType(int type) {
		ArrayList<Product> productList = new ArrayList<Product>();

		try {
			PreparedStatement pStatement = con.prepareStatement("SELECT * FROM product WHERE type = ?");
			pStatement.setInt(1, type);
			ResultSet resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				Product product = new Product();
				product.setPid(resultSet.getInt("pid"));
				product.setpName(resultSet.getString("pname"));
				product.setPrice(resultSet.getInt("price"));
				product.setStatus(resultSet.getInt("status"));
				product.setDescription(resultSet.getString("description"));
				product.setTypeID(resultSet.getInt("typeID"));
				String imgDataBase64 = new String(Base64.getEncoder().encode(resultSet.getBytes("photo")));
	        	String src = "data:image/jpg;base64,";
	        	src = src.concat(imgDataBase64);
	        	product.setPhoto(src);
				try {
					PreparedStatement pStatement1 = con.prepareStatement("SELECT * FROM producttype WHERE typeID=?");
					pStatement1.setInt(1, resultSet.getInt("typeID"));
					ResultSet resultSet1 = pStatement1.executeQuery();
					if (resultSet.next()) {
						product.setTypeName(resultSet1.getString("typeName"));
					}
				} catch (SQLException e) {
					product.setPid(0);
					System.err.println("Error: " + e);
				}
				productList.add(product);
			}
		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
		return productList;
	}
	public ArrayList<Product> getProductListByStatus(int status) {
		ArrayList<Product> productList = new ArrayList<Product>();

		try {
			PreparedStatement pStatement = con.prepareStatement("SELECT * FROM product WHERE status = ?");
			pStatement.setInt(1, status);
			ResultSet resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				Product product = new Product();
				product.setPid(resultSet.getInt("pid"));
				product.setpName(resultSet.getString("pname"));
				product.setPrice(resultSet.getInt("price"));
				product.setStatus(resultSet.getInt("status"));
				product.setDescription(resultSet.getString("description"));
				product.setTypeID(resultSet.getInt("typeID"));
				String imgDataBase64 = new String(Base64.getEncoder().encode(resultSet.getBytes("photo")));
	        	String src = "data:image/jpg;base64,";
	        	src = src.concat(imgDataBase64);
	        	product.setPhoto(src);
				try {
					PreparedStatement pStatement1 = con.prepareStatement("SELECT * FROM producttype WHERE typeID=?");
					pStatement1.setInt(1, resultSet.getInt("typeID"));
					ResultSet resultSet1 = pStatement1.executeQuery();
					if (resultSet.next()) {
						product.setTypeName(resultSet1.getString("typeName"));
					}
				} catch (SQLException e) {
					product.setPid(0);
					System.err.println("Error: " + e);
				}
				productList.add(product);
			}
		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
		return productList;
	}
	
	public ArrayList<Product> getProductListLimitsOrderByPID(int num) {
		ArrayList<Product> productList = new ArrayList<Product>();

		try {
			PreparedStatement pStatement = con.prepareStatement("SELECT * FROM product ORDER BY pid DESC LIMIT ?");
			pStatement.setInt(1, num);
			ResultSet resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				Product product = new Product();
				product.setPid(resultSet.getInt("pid"));
				product.setpName(resultSet.getString("pname"));
				product.setPrice(resultSet.getInt("price"));
				product.setStatus(resultSet.getInt("status"));
				product.setDescription(resultSet.getString("description"));
				product.setTypeID(resultSet.getInt("typeID"));
				String imgDataBase64 = new String(Base64.getEncoder().encode(resultSet.getBytes("photo")));
	        	String src = "data:image/jpg;base64,";
	        	src = src.concat(imgDataBase64);
	        	product.setPhoto(src);
				try {
					PreparedStatement pStatement1 = con.prepareStatement("SELECT * FROM producttype WHERE typeID=?");
					pStatement1.setInt(1, resultSet.getInt("typeID"));
					ResultSet resultSet1 = pStatement1.executeQuery();
					if (resultSet1.next()) {
						product.setTypeName(resultSet1.getString("typeName"));
					}
				} catch (SQLException e) {
					product.setPid(0);
					System.err.println("Error: " + e);
				}
				productList.add(product);
			}
		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
		return productList;
	}
	
	public ArrayList<Product> getProductListByTypeAndStatus(int type,int status) {
		ArrayList<Product> productList = new ArrayList<Product>();

		try {
			PreparedStatement pStatement = con.prepareStatement("SELECT * FROM product WHERE type =? AND status = ?");
			pStatement.setInt(1, type);
			pStatement.setInt(2, status);
			ResultSet resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				Product product = new Product();
				product.setPid(resultSet.getInt("pid"));
				product.setpName(resultSet.getString("pname"));
				product.setPrice(resultSet.getInt("price"));
				product.setStatus(resultSet.getInt("status"));
				product.setDescription(resultSet.getString("description"));
				product.setTypeID(resultSet.getInt("typeID"));
				String imgDataBase64 = new String(Base64.getEncoder().encode(resultSet.getBytes("photo")));
	        	String src = "data:image/jpg;base64,";
	        	src = src.concat(imgDataBase64);
	        	product.setPhoto(src);
				try {
					PreparedStatement pStatement1 = con.prepareStatement("SELECT * FROM producttype WHERE typeID=?");
					pStatement1.setInt(1, resultSet.getInt("typeID"));
					ResultSet resultSet1 = pStatement1.executeQuery();
					if (resultSet.next()) {
						product.setTypeName(resultSet1.getString("typeName"));
					}
				} catch (SQLException e) {
					product.setPid(0);
					System.err.println("Error: " + e);
				}
				productList.add(product);
			}
		} catch (SQLException e) {
			System.err.println("Error: " + e);
		}
		return productList;
	}
	
	
	
}
