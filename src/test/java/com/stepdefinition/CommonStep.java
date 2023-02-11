package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClass;

import io.cucumber.java.en.Then;
import io.restassured.response.Response;

public class CommonStep extends BaseClass {
	Response response;

	/**
	 * @see User should verify status code
	 * @param expStatusCode
	 */
	@Then("User Verify the status code is {int}")
	public void userVerifyTheStatusCodeIs(int expStatusCode) {
		int actStatusCode = TC1_LoginStep.globalDatas.getStatusCode();
		Assert.assertEquals("Verify Status Code", expStatusCode, actStatusCode);
	}

}
