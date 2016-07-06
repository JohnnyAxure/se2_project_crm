package mainFunctionality;


import java.util.List;
import java.util.stream.Collectors;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import persons.IKunde;

/**
* The CRM_System program implements an application that
* organizes customers 
*
* @author  ss401 , jh170 , bb071
* @version 1.0
* @since   2016.06.28
*/

/**
 * Represents customer list
 */
public class Kundenliste {

	/**
	 * synchronized list that collects all the customers
	 */
	private static ObservableList<IKunde> listeDerKunden =  FXCollections.synchronizedObservableList(FXCollections.observableArrayList());
	
	
		
 
/**
 * @return the customer list
 */
public static ObservableList<IKunde> getListeDerKunden() {
		return listeDerKunden;
	}




	
	/**
	 * this method searches our customers list, for customers 
	 * which first name, surname or customer number starts with the given search term 
	 * @param suchfeld the field in which the searchterm gets typed 
	 * @param kundentable table which shows the filtered list
	 */
	public static  void search(TextField suchfeld, TableView<IKunde> kundentable) {

		 suchfeld.textProperty().addListener(new ChangeListener<String>() {

				/* (non-Javadoc)
				 * @see javafx.beans.value.ChangeListener#changed(javafx.beans.value.ObservableValue, java.lang.Object, java.lang.Object)
				 */
				@Override
	            public void changed(ObservableValue<? extends String> observableValue, String s, String suche) {
	            	
	        
	            		 			 		if (!suche.isEmpty()){
	            		 			 			
	            		 			 			// Stream
	            		 			 			/*
	            		 			 			 * list that includes the customers that contain the searchterm
	            		 			 			 */
	            		 				 		List<IKunde> filteredList =   listeDerKunden.stream()
	            		 				 				                                    .filter(i -> i.getName().toLowerCase().startsWith(suche.toLowerCase()) 
			                                            	                                                  	    || i.getVorname().toLowerCase().startsWith(suche.toLowerCase())
			                                            	                                                        || String.valueOf(i.getKundennummer()).startsWith(suche.toLowerCase()))
	            		 				 				                                     .collect(Collectors.toList());
	            		 				 				                                                       
	            		 				 		ObservableList<IKunde> observableFilteredList = FXCollections.observableList(filteredList);
	            		 				 		
	            		 				 		kundentable.setItems(observableFilteredList);
	            		 			 			
	            		 			 		}
	            		 			 		else{
	            		 			 			kundentable.setItems(listeDerKunden);
	            		 			 			}
	            		 		
	            }
	        });
	}
}

