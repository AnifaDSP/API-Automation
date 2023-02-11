package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoint.EndPoints;
import com.payload.address.AddressPayload;

import com.pojo.address.AddUserAddress_Input_Pojo;
import com.pojo.address.AddUserAddress_Output_Pojo;
import com.pojo.address.DeleteUserAddress_Input_Pojo;
import com.pojo.address.DeleteUserAddress_Output_Pojo;
import com.pojo.address.GetUserAddress_Output_Pojo;
import com.pojo.address.UptateUserAddress_Input_Pojo;
import com.pojo.address.UptateUserAddress_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC4_AddressStep extends BaseClass {
	static AddressPayload addressPayLoad = new AddressPayload();
	Response response;
	String address_Id;

	/**
	 * @see User should enter the Header in Address page
	 * 
	 */
	@Given("User add header and Bearrer Authorizarion for accessing address endpoint")
	public void userAddHeaderAndBearrerAuthorizarionForAccessingAddressEndpoint() {
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("accept", "appilication/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.globalDatas.getLogtoken());
		Header h3 = new Header("Content-Type", "application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);
		Headers headers = new Headers(listHeader);
		addHeaders(headers);
	}

	/**
	 * @see User should perform add address by using API
	 * @param first_name
	 * @param last_name
	 * @param mobile
	 * @param apartment
	 * @param state
	 * @param city
	 * @param country
	 * @param zipcode
	 * @param address
	 * @param addresstype
	 */
	@When("User add requestbody for add new address {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void userAddRequestbodyForAddNewAddress(String first_name, String last_name, String mobile, String apartment,
			String state, String city, String country, String zipcode, String address, String address_type) {
		int country_id = Integer.parseInt(country);
		AddUserAddress_Input_Pojo addUserAddress_Input_Pojo = addressPayLoad.addUserAddressPayload(first_name,
				last_name, mobile, apartment, TC1_LoginStep.globalDatas.getStateIdNum(),
				TC1_LoginStep.globalDatas.getCity_Id(), country_id, zipcode, address, address_type);
		addBody(addUserAddress_Input_Pojo);

	}

	/**
	 * @see User should pass the method type
	 * @param type
	 */
	@When("User sent {string} request for addUserAddress endpoint")
	public void userSentRequestForAddUserAddressEndpoint(String type) {
		response = requestType(type, EndPoints.ADDUSERADDRESS);
	}

	/**
	 * @see user verify after address added success message
	 * @param expMessage
	 */
	@Then("User Verify the addUserAddress response message matches {string}")
	public void userVerifyTheAddUserAddressResponseMessageMatches(String expMessage) {

		AddUserAddress_Output_Pojo addAddress_Output_Pojo = response.as(AddUserAddress_Output_Pojo.class);
		String actMessage = addAddress_Output_Pojo.getMessage();
		Assert.assertEquals("Verify Add Address Success Message", expMessage, actMessage);
		int address_idNum = addAddress_Output_Pojo.getAddress_id();
		address_Id = String.valueOf(address_idNum);
		TC1_LoginStep.globalDatas.setAddress_Id(address_Id);
		System.out.println(address_Id);

	}

	/**
	 * @see User should perform to uptate address by using API
	 * @param address_Id
	 * @param first_name
	 * @param last_name
	 * @param mobile
	 * @param apartment
	 * @param state
	 * @param city
	 * @param country
	 * @param zipcode
	 * @param address
	 * @param address_type
	 */
	@When("User add requestbody for Uptate new address {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void userAddRequestbodyForUptateNewAddress(String first_name, String last_name,
			String mobile, String apartment, String state, String city, String country, String zipcode, String address,
			String address_type) {
		int country_id = Integer.parseInt(country);
		UptateUserAddress_Input_Pojo uptateUserAddress_Input_Pojo = addressPayLoad.uptateUserAddressPayload(TC1_LoginStep.globalDatas.getAddress_Id(),
				first_name, last_name, mobile, apartment, TC1_LoginStep.globalDatas.getStateIdNum(),
				TC1_LoginStep.globalDatas.getCity_Id(), country_id, zipcode, address, address_type);
		addBody(uptateUserAddress_Input_Pojo);

	}

	/**
	 * @see User should pass the method type
	 * @param type
	 */
	@When("User sent {string} request for UptateUserAddress endpoint")
	public void userSentRequestForUptateUserAddressEndpoint(String type) {
		response = requestType(type, EndPoints.UPTATEUSERADDRESS);
	}

	/**
	 * @see User should verify the after uptate address success message
	 * @param string
	 */
	@Then("User Verify the UpdateUserAddress response message matches {string}")
	public void userVerifyTheUpdateUserAddressResponseMessageMatches(String expMessage) {
		UptateUserAddress_Output_Pojo uptateUserAddress_Output_Pojo = response.as(UptateUserAddress_Output_Pojo.class);
		String actMessage = uptateUserAddress_Output_Pojo.getMessage();
		System.out.println(actMessage);
		Assert.assertEquals("Verify After Uptate Address Success Message", expMessage, actMessage);
	}

	/**
	 * @see User should enter the Header in get Address page
	 */
	@Given("User add header and Bearrer Authorizarion for accessing get address endpoint")
	public void userAddHeaderAndBearrerAuthorizarionForAccessingGetAddressEndpoint() {
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("accept", "appilication/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.globalDatas.getLogtoken());
		listHeader.add(h1);
		listHeader.add(h2);
		Headers headers = new Headers(listHeader);
		addHeaders(headers);
	}

	/**
	 * @see User should pass the method type
	 * @param type
	 */
	@When("User sent {string} request for GetUserAddress endpoint")
	public void userSentRequestForGetUserAddressEndpoint(String type) {
		response = requestType(type, EndPoints.GETUSERADDRESS);
	}

	/**
	 * @see User should verify the after get address success message
	 * @param string
	 */
	@Then("User Verify the GetUserAddress response message matches {string}")
	public void userVerifyTheGetUserAddressResponseMessageMatches(String expMessage) {
		GetUserAddress_Output_Pojo getUserAddress_Output_Pojo = response.as(GetUserAddress_Output_Pojo.class);
		String actMessage = getUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals("Verify Get Address Success Message", expMessage, actMessage);
	}

	/**
	 * @see User should enter the Header in delete Address page
	 */

	@Given("User add header and Bearrer Authorizarion for accessing delete address endpoint")
	public void userAddHeaderAndBearrerAuthorizarionForAccessingDeleteAddressEndpoint() {

		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("accept", "appilication/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.globalDatas.getLogtoken());
		Header h3 = new Header("Content-Type", "application/json");// 4423
		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);
		Headers headers = new Headers(listHeader);
		addHeaders(headers);
	}

	/**
	 * @see User should add the request body
	 * @param string
	 */
	@When("User add requestbody for Delete user address add address_id")
	public void userAddRequestbodyForDeleteUserAddress() {
		DeleteUserAddress_Input_Pojo deleteUserAddress_Input_Pojo = addressPayLoad.deleteUserAddressPayload(TC1_LoginStep.globalDatas.getAddress_Id());
		addBody(deleteUserAddress_Input_Pojo);
	}

	/**
	 * @see User should pass the method type
	 * @param string
	 */
	@When("User sent {string} request for DeleteUserAddress endpoint")
	public void userSentRequestForDeleteUserAddressEndpoint(String text) {
		response = requestType(text, EndPoints.DELETEADDRESS);
	}

	/**
	 * @see User should verify after delete success message
	 * @param string
	 */
	@Then("User Verify the DeleteUserAddress response message matches {string}")
	public void userVerifyTheDeleteUserAddressResponseMessageMatches(String expMessage) {
		DeleteUserAddress_Output_Pojo deleteUserAddress_Output_Pojo = response.as(DeleteUserAddress_Output_Pojo.class);
		String actMessage = deleteUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals("Verify Delete Address Success Message", expMessage, actMessage);
	}

}
