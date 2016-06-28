package SE2.CRM_System;

import mainFunctionality.Kundenliste;

import org.junit.Test;

import gui.MainGUI;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.web.HTMLEditor;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;

import persons.Admin;
import persons.FactoryKunde;
import persons.Kunde;

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
	
	@Test
	public void testKundentableIsEmpty() {
		Kundenliste.listeDerKunden.addAll(FactoryKunde.listeDerKunden);
		 Assert.assertFalse(Kundenliste.listeDerKunden.isEmpty());	
	}
	
	@Test
	public void testMainGUILöschen() {
		Assert.assertEquals(MainGUI.kundentable.getItems() == MainGUI.kundentable.getItems().remove(1), null);
	}
	
	@Test 
	public void testMainGUIAddKunde() {
		
		final ObservableList<Kunde> expectedResult = MainGUI.kundentable.getItems();

		HTMLEditor Notiz2 = null;
		FactoryKunde.add("Kunde", "Yamashi", "Andano", "Tendostraße", 65, 564657465, "Tokio", "Japan", "5745354357", 19, Notiz2);
		
		final ObservableList<Kunde> actualResult = MainGUI.kundentable.getItems();
		
		Assert.assertFalse(expectedResult == actualResult);
	}
	
	//@Test
	public void testKundenlisteSearch() {
		
		TextField suchfeld;
	//	suchfeld.setText("Peter");
		
	//	Assert.assertFalse(Kundenliste.search(suchfeld, MainGUI.kundentable).equals(MainGUI.kundentable.getItems()));
	}
	
	@Test(expected = NumberFormatException.class)
	public void testException() {
		 new ArrayList<Object>().get(0);
	}
	
	
	

}
