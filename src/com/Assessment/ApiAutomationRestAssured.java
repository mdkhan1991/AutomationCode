package com.Assessment;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ApiAutomationRestAssured {

	public static void main(String[] args) {
		RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";
		RestAssured.useRelaxedHTTPSValidation();
		
	
	//Please Note the below Api for get and Delete sometimes Run and sometimes not runnable (its server error) 	
		
//==========================================================================================================================================================================		
System.out.println("//=============================================Get API Invoked=======================================================================================");		
//==========================================================================================================================================================================	
		
		String response = given().contentType(ContentType.JSON)
                .when().get("/employees")              
               .then().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(response);
		JsonPath jpath=new JsonPath(response);
		String currentStatus=jpath.getString("status");
		
		//Return value
		
		System.out.println("Value of status for Get API -->"+ currentStatus );
		
		if(currentStatus.equals("success")) {
			System.out.println("Test is pass");
			
			
		}else {
			System.out.println("Test is Fail");
		}
		
		
//==========================================================================================================================================================================		
System.out.println("//=============================================Delete API Invoked=======================================================================================");		
//==========================================================================================================================================================================        
		

		
	String response1 = given().contentType(ContentType.JSON)
             .when().get("/delete/1")              
             .then().assertThat().statusCode(200).extract().response().asString();

         System.out.println(response1);
         JsonPath jpath1=new JsonPath(response);
         String currentStatus2=jpath1.getString("status");

       //Return value
 		
 		System.out.println("Value of status for Delete API -->"+ currentStatus2 );
         
         if(currentStatus2.equals("success")) {
           System.out.println("Test is pass");


         }else {
             System.out.println("Test is Fail");
          }
		
	}

}
