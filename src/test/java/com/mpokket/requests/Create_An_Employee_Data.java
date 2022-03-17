package com.mpokket.requests;

import org.testng.annotations.Test;

import com.mokket.pojos.CreateEmpPOJO;
import com.mpokket.util.BaseAPIClass;
import com.mpokket.util.ResourcePath;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import requestUtils.RequestUtilityClass;

public class Create_An_Employee_Data extends BaseAPIClass {
	@Test

	public void createEmployeeData() {

		CreateEmpPOJO createEmployeePOJO = new CreateEmpPOJO("test", "123", "23");

		Response createEmployeeResponse = RequestUtilityClass.createNewEmployee(createEmployeePOJO);
		createEmployeeResponse.then()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON)
		.log().all();
	}
}
