package com.mpokket.util;

import io.restassured.response.Response;

public class Json_Utility {
	
	public static Object getResponseJsondata(Response response,String jsonPath) {
		return response.jsonPath().get(jsonPath);
	}

}
