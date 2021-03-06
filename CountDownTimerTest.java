 /**
 *  @Author:         Corey M. Moura
 *  @Date:           January 18, 2018
 *  @Professor:      Dr. Trafftz
 *  @Project:        Project 1 of CS163.  J-Unit Structure provided by instructor
 *  @Notes:          This is a copy paste / modification of the provided Junit test guide
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class CountDownTimerTest {
	/****** 
	 * Here are some example JUnit test methods.  Some of the test 
	 * methods do several assertions, while others have only one assert.  
	 * 		What so you think is a better approach?
	 *  	Are there situation where only one assertion is required?
	 *     
	 * Your assignment is to write many test cases so that 
	 * the CountDownTimer class is throughly tested!!!
	 * 	   How may  test cases do I need?
	 * 
	 *     Good questions to ask in class.
	 * 
	 * ******/
	
	@Test
	public void testConstructor() {
		CountDownTimer s = new CountDownTimer (5,10,30);
		assertEquals(s.toString(),"5:10:30");
		
		s = new CountDownTimer("20:10:8");
		assertEquals(s.toString(),"20:10:08");
		
		s = new CountDownTimer("20:8");
		assertEquals(s.toString(),"0:20:08");
		
		s = new CountDownTimer("8");
		assertEquals(s.toString(),"0:00:08");
		
		s = new CountDownTimer(8);
		assertEquals(s.toString(),"0:00:08");
		
		s = new CountDownTimer(8,0);
		assertEquals(s.toString(),"0:08:00");
		
		s = new CountDownTimer(8,0,0);
		assertEquals(s.toString(),"8:00:00");
		
	}
	
	// Note: you are only allowed to have one exception occur
	// In other words, since the constructor throws and exception
	// no additional lines of code after the constructor should be added
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorWithErrors() {
		new CountDownTimer (5,100,300);	
	}

	@Test
	public void testSubMethod () {
		CountDownTimer s1 = new CountDownTimer (5,01,30);
		s1.sub(2000);
		assertEquals (s1.toString(),"4:28:10");
		
		s1 = new CountDownTimer (5,59,30);
		CountDownTimer s2 = new CountDownTimer (1,2,35);
		s1.sub(s2);
		assertEquals (s1.toString(),"4:56:55");
	
		s1 = new CountDownTimer (1,1,30);
		s2 = new CountDownTimer (1,1,1);
		s1.sub(s2);
		assertEquals (s1.toString(),"0:0:29");
		
		s1 = new CountDownTimer (30);
		s2 = new CountDownTimer (1);
		s1.sub(s2);
		assertEquals (s1.toString(),"0:0:29");
		
		for (int i = 0; i < 15000; i++) {
			s1.dec();
			// System.out.println (s1);
		}

		assertEquals (s1.toString(),"0:46:55");	
	}
	
	@Test
	public void testAddMethod () {
		CountDownTimer s1 = new CountDownTimer (5,01,30);
		s1.add(3600);
		assertEquals (s1.toString(),"6:01:30");
		
		s1 = new CountDownTimer (01,10);
		s1.add(360);
		assertEquals (s1.toString(),"01:10");
		
		s1 = new CountDownTimer (10);
		s1.add(60);
		assertEquals (s1.toString(),"0:01:10");
		
		s1 = new CountDownTimer ("2:00:00");
		s1.add(60);
		assertEquals (s1.toString(),"2:01:00");
		
		s1 = new CountDownTimer ("00:10:00");
		s1.add(60);
		assertEquals (s1.toString(),"00:11:00");
		
		s1 = new CountDownTimer ("00:00:10");
		s1.add(1);
		assertEquals (s1.toString(),"00:00:11");
		
	}
	
	@Test 
	public void testEqual () {
		CountDownTimer s1 = new CountDownTimer (5,59,00);
		CountDownTimer s2 = new CountDownTimer (6,01,00);
		CountDownTimer s3 = new CountDownTimer ("5:59:00");

		assertFalse(s1.equals(s2));
		assertTrue (s1.equals(s3));
	}
	
	@Test 
	public void testCompareTo () {
		CountDownTimer s1 = new CountDownTimer (5,59,00);
		CountDownTimer s2 = new CountDownTimer (6,01,00);
		CountDownTimer s3 = new CountDownTimer (5,50,20);
		CountDownTimer s4 = new CountDownTimer ("5:59:00");
		
		assertTrue (s2.compareTo(s1) > 0);
		assertTrue (s3.compareTo(s1) < 0);
		assertTrue (s1.compareTo(s4) == 0);	
	}
	
	@Test 
	public void testLoadSave () {
		CountDownTimer s1 = new CountDownTimer (5,59,30);
		CountDownTimer s2 = new CountDownTimer ("5:59:30");

		// s1.save("saveIt");
		// s1 = new CountDownTimer ();  // resets to zero
		
		// s1.load("saveIt");
		// assertTrue (s1.equals(s2));	
	}
}