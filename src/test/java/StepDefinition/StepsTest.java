package StepDefinition;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import Resource.APIResources;
import Resource.TestDataBuild;
import Resource.Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;

public class StepsTest extends Util
{
	RequestSpecification res;
	RequestSpecification res2;
	ResponseSpecification resspec;
	RequestSpecification res1;
	RequestSpecification updateRes;
	static Response actualResponse;
	static Response getActualResponse;
	static Response authActualResponse;
	static Response putActualResponse;
	String bookingID;
	String token;
	TestDataBuild data= new TestDataBuild();
	
	@Given("create booking Payload with firstname, lastname and bookingdates")
	public void create_booking_payload_with_firstname_lastname_and_bookingdates() throws IOException 
	{
		System.out.println("given step is executing");
		
	   res = given().log().all().spec(requestSpecification()).body(data.creeateBookingBody());
	   System.out.println("given step is executed");
	}

	@When("user calls {string} API with {string} method")
	public void user_calls_api_with_method(String resource, String method)
	{
		System.out.println("when step is executing ");
	    APIResources resourceAPI = APIResources.valueOf(resource);
	    System.out.println("resourceAPI value -> "+resourceAPI);
	    String resourceAPIValue = resourceAPI.getResource();
	    resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	    
	    if(method.equalsIgnoreCase("POST"))
	    {
	      actualResponse = res.when().post(resourceAPIValue).then().log().all().spec(resspec).extract().response();
	    }
	    
	    System.out.println("when step is executed");
	}


	@Then("API call is successfull with status code and staus")
	public void api_call_is_successfull_with_status_code_and_staus() 
	{
		System.out.println("then method is executing");
	    
		int actualStatusCode = actualResponse.getStatusCode();
		assertEquals(actualStatusCode, 200);
		
		System.out.println("then method is executed");
	}
	
	@Given("get the booking id of created booking")
	public void get_the_booking_id_of_created_booking() 
	{
	     bookingID = getJsonPath(actualResponse, "bookingid");
	    System.out.println("Booking Id is -> "+bookingID);
	}

	@When("user calls {string} api with {string} method")
	public void user_calls_api_with_method1(String resource, String method) throws IOException
	{
	    res1 = given().log().all().spec(requestSpecification());
	    APIResources resourceAPI = APIResources.valueOf(resource);
	    System.out.println("resourceAPI value -> "+resourceAPI);
	    String resourceAPIValue = resourceAPI.getResource();
	    System.out.println("value of resourceAPIValue is ->"+resourceAPIValue);
	    System.out.println("modified get api will be ->"+resourceAPIValue+bookingID);
	    String modResourceAPIValue=resourceAPIValue+bookingID;
	    resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	    if(method.equalsIgnoreCase("get"))
	    {
	      getActualResponse = res1.when().get(modResourceAPIValue).then().log().all().spec(resspec).extract().response();
	    }
	    
	}

	@Then("Api call is successfull with status code and status")
	public void api_call_is_successfull_with_status_code_and_status() 
	{
System.out.println("then method is executing");
	    
		int getActualStatusCode = getActualResponse.getStatusCode();
		assertEquals(getActualStatusCode, 200);
		
		System.out.println("then method is executed");
	}
	
	@Given("create the autorisation token")
	public void create_the_autorisation_token() throws IOException 
	{
		 res2 = given().log().all().spec(requestSpecification()).body("{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "}");
		 
		 APIResources resourceAPI = APIResources.valueOf("AuthenticationAPI");
		    System.out.println("resourceAPI value -> "+resourceAPI);
		    String resourceAPIValue = resourceAPI.getResource();
		    System.out.println("value of resourceAPIValue is ->"+resourceAPIValue);
		    
		    authActualResponse = res2.when().post(resourceAPIValue).then().log().all().extract().response();
		    
		   token = getJsonPath(authActualResponse, "token");
		 
	   
	}

	@Given("create the payload for the update API")
	public void create_the_payload_for_the_update_api() throws IOException 
	{
	  updateRes = given().log().all().spec(requestSpecification()).body(data.updateBookingBody());
	}

	@When("user calls {string} Api with {string} method")
	public void user_calls_api_with_method2(String resource, String method) throws IOException
	{
	    res1 = given().log().all().spec(requestSpecification());
	    APIResources resourceAPI = APIResources.valueOf(resource);
	    System.out.println("resourceAPI value -> "+resourceAPI);
	    String resourceAPIValue = resourceAPI.getResource();
	    System.out.println("value of resourceAPIValue is ->"+resourceAPIValue);
	    System.out.println("modified get api will be ->"+resourceAPIValue+bookingID);
	    String modResourceAPIValue=resourceAPIValue+bookingID;
	    resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	    if(method.equalsIgnoreCase("put"))
	    {
	      putActualResponse = res1.when().put(modResourceAPIValue).then().log().all().spec(resspec).extract().response();
	    }
	    
	}
	
	@Then("Api call is successfull with status code {int} and status ok")
	public void api_call_is_successfull_with_status_code_and_status_ok(Integer int1) 
	{
		int putStatusCode = putActualResponse.getStatusCode();
		System.out.println("put Status code value -> "+putStatusCode);
		assertEquals(putStatusCode, 200);
	}

}
