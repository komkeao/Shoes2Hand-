package model;

public class Bill {
	private int bid;
	private String bookingTime;
	private String payTime;
	private int userID;
	private String sendAddress;public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	private String photo;
	public String getSendAddress() {
		return sendAddress;
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
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
}
