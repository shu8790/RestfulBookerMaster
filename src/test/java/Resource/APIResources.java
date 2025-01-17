package Resource;

public enum APIResources 
{
	AuthenticationAPI ("https://restful-booker.herokuapp.com/auth"),
	CreateBookingAPI("https://restful-booker.herokuapp.com/booking"),
	GetBookingAPI("https://restful-booker.herokuapp.com/booking/"),
	UpdateBookingAPI("https://restful-booker.herokuapp.com/booking/"),
	DeleteBookingAPI("https://restful-booker.herokuapp.com/booking");
	
	public String resource;
	
	APIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
	
}
