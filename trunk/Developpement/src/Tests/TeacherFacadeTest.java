package Tests;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import BL.TeacherFacade;

public class TeacherFacadeTest extends TestCase
{
	TeacherFacade tf;
	
	@Before
    public void setUp() throws Exception 
    {
		if(this.tf == null)
		{
			this.tf = new TeacherFacade("Laurent", "anne");   
		}
    }

	@Test
	public void testGetSchedules() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFeatures() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTeachings() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetValidBooking() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsSuperUser() 
	{
		boolean superuser = this.tf.isSuperUser();
		assertEquals(false, superuser);
	}

	@Test
	public void testConfirmBooking() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckFreeRooms() {
		fail("Not yet implemented");
	}

}
