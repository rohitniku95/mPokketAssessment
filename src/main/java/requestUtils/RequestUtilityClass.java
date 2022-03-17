package requestUtils;

import com.mpokket.util.ResourcePath;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;

public class RequestUtilityClass {
	
	public static Response createNewEmployee(Object empPojo) {
		Response createEmployeeResponse = RestAssured.given()
				.contentType(ContentType.JSON)
				.body(empPojo, ObjectMapperType.JACKSON_1)
				.when()
				.post(ResourcePath.CREATE_EMPLOYEE);
		return createEmployeeResponse;
	}
	
	public static Response getEmployee(int empId) {
		return RestAssured.given()
		.pathParam("empid", empId)
		.get(ResourcePath.CREATE_EMPLOYEE);
	}
	
	public static Response deleteEmployee(int empId) {
		return RestAssured.given()
		.pathParam("empid", empId)
		.delete(ResourcePath.DELETE_SINGLE_EMPLOYEE);
	}

}
