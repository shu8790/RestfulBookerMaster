package Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
//import resource.Utils;

public class Util 
{
	// 1. request specification and log
	
	// 2. property file reading
	
	// 3. json path 
	
	public static RequestSpecification req;
	public RequestSpecification requestSpecification() throws IOException
	{
		if(req==null)
	{
		System.out.println("request specification if condition is getting executed");
	
		PrintStream log= new PrintStream(new FileOutputStream("logging.text"));
		req = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com")
									.addFilter(RequestLoggingFilter.logRequestTo(log))
									.addFilter(ResponseLoggingFilter.logResponseTo(log)).setContentType(ContentType.JSON).build();
		return req;
		
	}
		return req;
	}
	
	public static String getGlobalValues() throws IOException
	{
		Properties pro= new Properties();
		FileInputStream fis= new FileInputStream("C:\\Users\\srkal\\eclipse-workspace\\RestFulBooker\\src\\test\\java\\Resource\\Global.properties");
		pro.load(fis);
		String Baseurl = pro.getProperty("Baseurl");
		return Baseurl;
		
	}

	public String getJsonPath(Response actualResponse,String key)
	{
		String a = actualResponse.asString();
		JsonPath js= new JsonPath(a);
		return js.get(key).toString();
	}

}
