package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.BaseClass;
import com.endpoint.EndPoints;
import com.payload.product.ProductPayload;

import com.pojo.product.SearchProduct_Input_Pojo;
import com.pojo.product.SearchProduct_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC5_SearchProductStep extends BaseClass {
	static ProductPayload productPayload = new ProductPayload();
	Response response;

	/**
	 * @see User should enter the Header in Search Product page
	 * 
	 */
	@Given("User add header for to Search Product")
	public void userAddHeaderForToSearchProduct() {
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("accept", "appilication/json");
		Header h2 = new Header("Content-Type", "application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		Headers headers = new Headers(listHeader);
		addHeaders(headers);

	}

	/**
	 * @see User should perform add Product Name by using API
	 * @param product_Name
	 */
	@When("User add requestbody for get SearchProduct {string}")
	public void userAddRequestbodyForGetSearchProduct(String product_Name) {
		SearchProduct_Input_Pojo searchProduct_Input_Pojo = productPayload.searchProductPayload(product_Name);
		addBody(searchProduct_Input_Pojo);
	}

	/**
	 * @see User should pass the method type
	 * @param text
	 */
	@When("User sent {string} request for SearchProduct endpoint")
	public void userSentRequestForSearchProductEndpoint(String text) {
		response = requestType(text, EndPoints.SEARCHPRODUCT);
	}

	/**
	 * @see User verify after Search Product success message
	 * @param expMessage
	 */
	@Then("User Verify the SearchProduct response message matches {string}")
	public void userVerifyTheSearchProductResponseMessageMatches(String expMessage) {
		SearchProduct_Output_Pojo searchProduct_Output_Pojo = response.as(SearchProduct_Output_Pojo.class);
		String actMessage = searchProduct_Output_Pojo.getMessage();
		Assert.assertEquals("Verify After Search Product Message", expMessage, actMessage);
	}

}
