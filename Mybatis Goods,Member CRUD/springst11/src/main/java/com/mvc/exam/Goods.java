package com.mvc.exam;

import java.sql.Date;

public class Goods {

	 private String code;
	 private String name;
	 private int price;
	 private String color;
	 private Date now_date;
	 
	 
	public Date getNow_date() {
		return now_date;
	}
	public void setNow_date(Date now_date) {
		this.now_date = now_date;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	 
	 
}
