package com.stepdefinition;

import java.util.ArrayList;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoint.EndPoints;
import com.google.common.base.Verify;
import com.pojo.address.StateList;
import com.pojo.address.StateList_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.bytebuddy.asm.Advice.Enter;

public class TC2_GetStateIdStep extends BaseClass {
	Response response;

	/**
	 * @see Enter the Header present in Statelist page
	 * 
	 */
	@Given("User add header for to StateList")
	public void userAddHeaderForToStateList() {
		addHeader("accept", "application/json");
	}

	/**
	 * @see Pass the Method type
	 * @param type
	 */
	@When("User sent {string} request for StateList endpoint")
	public void userSentRequestForStateListEndpoint(String type) {
		response = requestType(type, EndPoints.STATELIST);
	}

	/**
	 * @see Verify the state list response message
	 * @param expMessage
	 */
	@Then("User Verify the StateList response message matches {string} and saved StateId")
	public void userVerifyTheStateListResponseMessageMatchesAndSavedStateId(String expStateName) {
		StateList_Output_Pojo stateList_Output_Pojo = response.as(StateList_Output_Pojo.class);
		ArrayList<StateList> stateList = stateList_Output_Pojo.getData();
		for (StateList eachStateList : stateList) {
			String actStateName = eachStateList.getName();
			if (actStateName.equals(expStateName)) {
				int stateIdNum = eachStateList.getId();
				TC1_LoginStep.globalDatas.setStateIdNum(stateIdNum);
				String state_Id = String.valueOf(stateIdNum);
				TC1_LoginStep.globalDatas.setState_Id(state_Id);
				Assert.assertEquals("Verify State Name", expStateName, actStateName);
				break;

			}
		}
	}

}
