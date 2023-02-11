package com.global;
/**
 * @see Maintain commonly used variable as POJO class
 * @author Mohamed Anifa S
 *
 */
public class GlobalDatas {

	private int StatusCode;
	private String logtoken;
	private int stateIdNum;
	private String state_Id;
	private int city_Id;
	private String cityIdNum;
	private String address_Id;

	public String getAddress_Id() {
		return address_Id;
	}

	public void setAddress_Id(String address_Id) {
		this.address_Id = address_Id;
	}

	public String getCityIdNum() {
		return cityIdNum;
	}

	public void setCityIdNum(String cityIdNum) {
		this.cityIdNum = cityIdNum;
	}

	public int getStatusCode() {
		return StatusCode;
	}

	public void setStatusCode(int statusCode) {
		StatusCode = statusCode;
	}

	public String getLogtoken() {
		return logtoken;
	}

	public void setLogtoken(String logtoken) {
		this.logtoken = logtoken;
	}

	public int getStateIdNum() {
		return stateIdNum;
	}

	public void setStateIdNum(int stateIdNum) {
		this.stateIdNum = stateIdNum;
	}

	public String getState_Id() {
		return state_Id;
	}

	public void setState_Id(String state_Id) {
		this.state_Id = state_Id;
	}

	public int getCity_Id() {
		return city_Id;
	}

	public void setCity_Id(int city_Id) {
		this.city_Id = city_Id;
	}

}
