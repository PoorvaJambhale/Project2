package com.project.test;

import static org.junit.Assert.*;
import org.junit.Test;
import com.project.controller.CreateTicketController;


public class CreateTicketJunitTest {
	
	CreateTicketController testTicket = new CreateTicketController ();
	
	String ticketDateStr = "2015-5-5";
 	String bugTitle  = "Junit Test";
 	String bugDescription ="Junit Test";
 	String bugCategory = "Junit Test";		
 	String projectName = "Junit Test";
 	String projectVersion = "JT_V1";
 	String devName = "D333";
 	String ticketPriority ="High";
 	String comments = "Trying to test for Junit";
 	String targetDueDateStr = "2015-5-6";
	String ticketCreatedBy = "Test123";	
	
	@Test
	public void testCreateTicket() {
		
		String result ="error";
		try {
			
			result = testTicket.createANewTicket(ticketDateStr, bugTitle, bugDescription, bugCategory, projectName, projectVersion, devName, ticketPriority, comments, targetDueDateStr, ticketCreatedBy);
			
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(result, "success");	
	}
}
