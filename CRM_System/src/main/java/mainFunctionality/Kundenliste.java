package mainFunctionality;


import java.util.List;
import java.util.stream.Collectors;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import persons.Kunde;

public class Kundenliste {

	public static ObservableList<Kunde> listeDerKunden = FXCollections.observableArrayList();
	
	
	public void show() {
		
		for (int i = 0; i < listeDerKunden.size(); i++) {
			System.out.println(listeDerKunden.get(i));

		}

	}

	@SuppressWarnings("rawtypes")
	public static  void search(TextField suchfeld, TableView kundentable) {

		 suchfeld.textProperty().addListener(new ChangeListener<String>() {
	            @SuppressWarnings("unchecked")
				@Override
	            public void changed(ObservableValue<? extends String> observableValue, String s, String suche) {
	            	
	        
	            		 			 		if (!suche.isEmpty()){
	            		 			 			
	            		 			 			// Stream
	            		 			 			
	            		 				 		List<Kunde> filteredList =   listeDerKunden.stream()
	            		 				 				                                               .filter(i -> i.Name.toLowerCase().contains(suche.toLowerCase()) 
			                                            	                                                  	    || i.Vorname.toLowerCase().contains(suche.toLowerCase())
			                                            	                                                        || String.valueOf(i.Kundennummer).contains(suche.toLowerCase()))
	            		 				 				                                               .collect(Collectors.toList());
	            		 				 				                                                       
	            		 				 		ObservableList<Kunde> observableFilteredList = FXCollections.observableList(filteredList);
	            		 				 		
	            		 				 		kundentable.setItems(observableFilteredList);
	            		 			 			
	            		 			 		}
	            		 			 		else{
	            		 			 			kundentable.setItems(listeDerKunden);
	            		 			 			}
	            		 		
	            }
	        });
	}
}


