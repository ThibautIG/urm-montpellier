package Persist;
import java.sql.Connection;

import BL.Booking;


class BookingJDBC extends Booking {
	public BookingJDBC(Connection dbConnection) 
	{
		// TODO Auto-generated constructor stub
	}

	public int checkFreeRooms() {
		return 0;
	}

	public boolean save() {
		return false;
	}

	@Override
	public void load(String reference) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSalle() {
		// TODO Auto-generated method stub
		
	}

}
