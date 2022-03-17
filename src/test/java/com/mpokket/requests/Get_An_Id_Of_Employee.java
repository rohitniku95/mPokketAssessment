package com.mpokket.requests;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.mokket.pojos.CreateEmpPOJO;
import com.mpokket.util.ResourcePath;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import requestUtils.RequestUtilityClass;

public class Get_An_Id_Of_Employee {

	@Test
	public void getEmployeeTest() {
CreateEmpPOJO createEmployeePOJO = new CreateEmpPOJO("test", "123", "23");
		
		Response createEmployeeResponse = RequestUtilityClass.createNewEmployee(createEmployeePOJO);
		createEmployeeResponse.then()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON)
		.log().all();
		
		int empId = createEmployeeResponse.jsonPath().get("data.id");
		
		RequestUtilityClass.getEmployee(empId)
		.then()
		.assertThat().body("data.employee_name", Matchers.equalTo(createEmployeePOJO.getName()))
		.assertThat().body("data.employee_salary",Matchers.equalTo(createEmployeePOJO.getSalary()))
		.assertThat().body("data.employee_age", Matchers.equalTo(createEmployeePOJO.getAge()))
		.log().all();
		
	}
}


