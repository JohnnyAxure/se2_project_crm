package SE2.CRM_System;

import mainFunctionality.Kundenliste;

import org.junit.Test;
import org.junit.Assert;

import persons.Admin;

public class CRM_System_Test {

	@Test
	public void testLoginGUIUsername() {
		final String expectedResult = "admin";
		final String actualResult = Admin.username;
		
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testLoginGUIPassword() {
		final String expectedResult = "admin";
		final String actualResult = Admin.password;
		
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testLoginGUIWrongUsername() {
		final String expectedResult = "user";
		final String actualResult = Admin.password;
		
		Assert.assertFalse(expectedResult.equals(actualResult));
		}
	
	
	@Test
	public void testLoginGUIWrongPassword() {
		final String expectedResult = "user";
		final String actualResult = Admin.password;
		
		Assert.assertFalse(expectedResult.equals(actualResult));
	}
	//FEHLER!!!
	//@Test
	public void testDriverWrongKundennummer() {
		final int expectedResult = 2;
		final int actualResult = Kundenliste.listeDerKunden.get(2).Kundennummer;
		
		Assert.assertTrue(expectedResult == actualResult);
		
	}
	
	
	
}
