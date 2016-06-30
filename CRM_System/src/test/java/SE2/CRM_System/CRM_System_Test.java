package SE2.CRM_System;

import mainFunctionality.Driver;
import persons.FactoryKunde;
import persons.IKunde;
import mainFunctionality.Kundenliste;
import org.junit.Test;
import javafx.collections.ObservableList;
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

@Test
public void testKundentableIsEmpty() {
Driver newDriver = new Driver();
newDriver.add();
Assert.assertFalse(Kundenliste.getListeDerKunden().isEmpty());
}

@Test
public void testMainGUILöschenButton() {
Driver newDriver = new Driver();
newDriver.add();

final ObservableList<IKunde> expectedResult = Kundenliste.getListeDerKunden();



Assert.assertFalse(expectedResult.remove(3) == Kundenliste.getListeDerKunden());
}

@Test
public void testMainGUIAddKunde() {
Driver newDriver = new Driver();
newDriver.add();

final int expectedResult = Kundenliste.getListeDerKunden().size();
String Notiz = "";

FactoryKunde.add("Kunde", "Yamashi", "Andano", "Tendostraße", 65, 564657465, "Tokio", "Japan", "5745354357", 19, Notiz);

final int actualResult = Kundenliste.getListeDerKunden().size();

Assert.assertFalse(expectedResult == actualResult);
}

@Test(expected = NumberFormatException.class)
public void testException() {
final String postleitzahlSet = "ascbcbiqö";
Integer.parseInt(postleitzahlSet);

}

@Test(expected = NumberFormatException.class)
public void testException2() {
final String hausnummerSet = "dreizehn";
Integer.parseInt(hausnummerSet);

}




}
