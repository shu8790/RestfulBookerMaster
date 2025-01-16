
package Resource;

import POJO.CreateBookingBookingDates;
import POJO.CreateBookingPayload;

public class TestDataBuild
{
	
	public CreateBookingPayload creeateBookingBody()
	{
		CreateBookingPayload cb= new CreateBookingPayload();
		CreateBookingBookingDates bd= new CreateBookingBookingDates();
		bd.setCheckin("2024-06-01");
		bd.setCheckout("2024-06-02");
		
		cb.setFirstname("Shubham");
		cb.setLastname("kale");
		cb.setTotalprice(1000);
		cb.setDepositpaid(true);
		cb.setBookingdates(bd);
		cb.setAdditionalneeds("Breakfast");
		
		return cb;
		
	}
	
	
}
