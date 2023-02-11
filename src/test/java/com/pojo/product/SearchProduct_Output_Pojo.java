package com.pojo.product;

import java.util.ArrayList;



/**
 * @see Get Address Response body Output POJO
 * @author Mohamed Anifa S
 *
 */
public class SearchProduct_Output_Pojo {
	private int status;
	private String message;
	private ArrayList<SearchProduct> data;
	private String currency;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ArrayList<SearchProduct> getData() {
		return data;
	}

	public void setData(ArrayList<SearchProduct> data) {
		this.data = data;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
