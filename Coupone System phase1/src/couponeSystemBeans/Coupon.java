package couponeSystemBeans;

import java.util.Date;

public class Coupon {

	private int id;
	private int companyID;
	private Category category;
	private String title;
	private String descripion;
	private Date startDate;
	private Date endDate;
	private int amount;
	private double price;
	private String image;
	
	public Coupon(int id, int companyID, Category category, String title, String descripion, Date startDate,
			Date endDate, int amount, double price, String image) {
		super();
		this.id = id;
		this.companyID = companyID;
		this.category = category;
		this.title = title;
		this.descripion = descripion;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
		this.price = price;
		this.image = image;
	}
	
	@Override
	public String toString() {
		return "Coupon [id=" + id + ", companyID=" + companyID + ", category=" + category + ", title=" + title
				+ ", descripion=" + descripion + ", startDate=" + startDate + ", endDate=" + endDate + ", amount="
				+ amount + ", price=" + price + ", image=" + image + "]";
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCompanyID() {
		return companyID;
	}
	
	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescripion() {
		return descripion;
	}
	
	public void setDescripion(String descripion) {
		this.descripion = descripion;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
