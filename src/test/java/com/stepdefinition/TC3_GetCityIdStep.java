package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import com.base.BaseClass;
import com.endpoint.EndPoints;
import com.google.common.base.Verify;

import com.pojo.address.CityList_Input_Pojo;
import com.pojo.address.CityList_Output_Pojo;
import com.pojo.address.CityList;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import net.bytebuddy.asm.Advice.Enter;

public class TC3_GetCityIdStep extends BaseClass {
	Response response;

	/**
	 * @see Enter the header present in City List page
	 */
	@Given("User add header for to CityList")
	public void userAddHeaderForToCityList() {
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("accept", "appilication/json");
		Header h2 = new Header("Content-Type", "application/json");// 4423
		listHeader.add(h1);
		listHeader.add(h2);
		Headers headers = new Headers(listHeader);
		addHeaders(headers);
	}

	/**
	 * @see User pass the Request body State_Id
	 * @param string
	 */
	@When("User add requestbody for get CityList enter State_Id")
	public void userAddRequestbodyForGetCityListEnterStateId() {
		CityList_Input_Pojo cityList_Input_Pojo = new CityList_Input_Pojo(TC1_LoginStep.globalDatas.getState_Id());
		addBody(cityList_Input_Pojo);
	}

	/**
	 * @see Pass the Method type
	 * @param string
	 */
	@When("User sent {string} request for CityList endpoint")
	public void userSentRequestForCityListEndpoint(String type) {
		response = requestType(type, EndPoints.CITYLIST);
	}

	/**
	 * @see Verify after cityList response Message
	 * @param string
	 */
	@Then("User Verify the CityList response message matches {string} and saved CityId")
	public void userVerifyTheCityListResponseMessageMatchesAndSavedCityId(String expCityName) {
		CityList_Output_Pojo cityList_Output_Pojo = response.as(CityList_Output_Pojo.class);
		ArrayList<CityList> CityList = cityList_Output_Pojo.getData();
		for (CityList eachCityList : CityList) {
			String actCityName = eachCityList.getName();
			if (actCityName.equals(expCityName)) {
				int city_Id = eachCityList.getId();
				System.out.println(city_Id);
				TC1_LoginStep.globalDatas.setCity_Id(city_Id);
				String cityIdNum = String.valueOf(city_Id);
				TC1_LoginStep.globalDatas.setCityIdNum(cityIdNum);
			}
		}
	}

}
