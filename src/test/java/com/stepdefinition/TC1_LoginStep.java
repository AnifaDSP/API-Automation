package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoint.EndPoints;
import com.global.GlobalDatas;
import com.pojo.login.Login_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class TC1_LoginStep extends BaseClass {
	Response response;
	static GlobalDatas globalDatas = new GlobalDatas();

	/**
	 * @see Use to add header for Login
	 */
	@Given("User add header")
	public void userAddHeader() {
		addHeader("accept", "application/json");
	}

	/**
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @see Perform the login by using basic auth
	 */
	@When("User add basic authentication for login")
	public void userAddBasicAuthenticationForLogin() throws FileNotFoundException, IOException {
		addBasicAuth(getPropertyFileValue("UserName"), getPropertyFileValue("Password"));
	}

	/**
	 * @see Pass the Method type
	 * @param type
	 */
	@When("User sent {string} request for login endpoint")
	public void userSentRequestForLoginEndpoint(String type) {
		response = requestType(type, EndPoints.POSTMANBASICAUTHLOGIN);
		int statusCode = getStatusCode(response);
		globalDatas.setStatusCode(statusCode);

	}

	/**
	 * @see Verify the after login success message
	 * @param expMessage
	 */
	@Then("User Verify the Login response body firstname present as {string} and get the logtoken saved")
	public void userVerifyTheLoginResponseBodyFirstnamePresentAsAndGetTheLogtokenSaved(String expMessage) {
		Login_Output_Pojo login_Output_Pojo = response.as(Login_Output_Pojo.class);
		String actFirst_Name = login_Output_Pojo.getData().getFirst_name();
		Assert.assertEquals("Verify First Name", expMessage, actFirst_Name);
		String logtoken = login_Output_Pojo.getData().getLogtoken();
		globalDatas.setLogtoken(logtoken);
		System.out.println(logtoken);

	}

}
