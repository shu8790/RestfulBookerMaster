
package Resource;

import POJO.CreateBookingBookingDates;
import POJO.CreateBookingPayload;
import POJO.UpdateBookingBookingDates;
import POJO.UpdateBookingPayload;

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
	
	public UpdateBookingPayload updateBookingBody()
	{
		UpdateBookingPayload ub= new UpdateBookingPayload();
		UpdateBookingBookingDates ubd= new UpdateBookingBookingDates();
		
		ubd.setCheckin("2025-01-17");
		ubd.setCheckout("2025-01-17");

		ub.setFirstname("akash");
		ub.setLastname("patil");
		ub.setTotalprice(1200);
		ub.setDepositpaid(false);
		ub.setBookingdates(ubd);
		ub.setAdditionalneeds("Dinner");
		
		return ub;
	}
	
	
}
