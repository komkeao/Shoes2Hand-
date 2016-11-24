package model;

import java.util.ArrayList;

public class BillDetails {
	private int bid;
	private String bookingTime;
	private String payTime;
	private String sendAddress;	
	private int userID;
	private String username;
	private String photo;
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	private String price;
	
	//private User user;
	
	public ArrayList<Product> getProduct() {
		return product;
	}
	public void setProduct(ArrayList<Product> product) {
		this.product = product;
	}
	private ArrayList<Product> product=new ArrayList<Product>();

	public String getSendAddress() {
		return sendAddress;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public void setSendAddress(String sendAddress) {
		this.sendAddress = sendAddress;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBookingTime() {
		return bookingTime;
	}
	public void setBookingTime(String bookingTime) {
		this.bookingTime = bookingTime;
	}
	public String getPayTime() {
		return payTime;
	}
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
}
