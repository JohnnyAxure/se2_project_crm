package gui;

import java.util.Optional;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import mainFunctionality.Driver;
import mainFunctionality.Kundenliste;
import persons.IKunde;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
* The CRM_System program implements an application that
* organizes customers 
*
* @author  ss401 , jh170 , bb071
* @version 1.0
* @since   2016.06.28
*/

/**
 * main gui.
 * Shows a table with all our customers. 
 * Has a search method, to search for specific customer. 
 * Opens a new window, when clicking on a customer, which shows customers information.
 * Has an add button, which opens a new window to create a new customer
 */
public abstract class MainGUI extends Application{

	
	private static final Logger log2 = Logger.getLogger(MainGUI.class.getName());
	
	/**
	 * table which shows all the customers
	 */
	public final static TableView<IKunde> kundentable = new TableView<IKunde>();
	
	
	
	/**
	 * this method opens our main gui
	 * @param mainStage Stage that did contain our LoginGUI
	 */
	@SuppressWarnings("unchecked")
	public static void startMainGui(final Stage mainStage) {
		
		Handler handlerSecondary = new ConsoleHandler();
		handlerSecondary.setLevel(Level.FINEST);
		log2.addHandler(handlerSecondary);
		log2.setLevel(Level.FINEST);
		log2.fine("Launched Main Stage.");


			
		/*
		 * Thread that refreshes our table every three seconds
		 */
		 Thread threadRefresh = new Thread(() -> {
		            try {
						Thread.sleep(3000);
					} catch (Exception e) {
						e.printStackTrace();
					} 
		            // Guarded wait observable list 
		            
		           kundentable.refresh();
		           //unused= false;
		           
		    }); 
		 threadRefresh.start();
		 
		 /*
		  * backup List which saves the current customer list
		  */
		 ObservableList<IKunde> backupList = FXCollections.observableArrayList();
		 

		 /*
		  * Thread that creates an backup of the customer list and prints it on our console every three seconds
		  */
		 Thread threadBackup = new Thread(() -> {
		            try {
						Thread.sleep(3000);
					} catch (Exception e) {
						e.printStackTrace();
					} 
		        
		            backupList.addAll(Kundenliste.getListeDerKunden());
					 System.out.println(backupList);
		   
		 });
		 
		 threadBackup.start();
		 
	
		
		VBox vb2 = new VBox();
		vb2.setPadding(new Insets(10, 50, 50, 50));
		vb2.setSpacing(5);
		vb2.getStyleClass().add("vbox");
	    
		
		Label suchlabel = new Label();
		suchlabel.setText("| Suche");
		suchlabel.getStyleClass().add("label2");
		vb2.getChildren().add(suchlabel);

	    TextField suchfeld = new TextField();
	    suchfeld.setId("textfield");
		vb2.getChildren().add(suchfeld);
		
		Label space = new Label();
		vb2.getChildren().add(space);

		Button add = new Button();
		add.setText("+ neuer Kunde ");
		vb2.getChildren().add(add);
		
		Label space2 = new Label();
		vb2.getChildren().add(space2);
		
		Label tabelle = new Label();
		tabelle.setText("| Kundenliste");
		tabelle.getStyleClass().add("label2");
		vb2.getChildren().add(tabelle);
		
		
		final Driver newdriver = new Driver();
		newdriver.add();

		kundentable.setPlaceholder(new Label("keine Kunden gefunden"));

		kundentable.setEditable(false);
		final TableColumn<IKunde, String> firstNameCol = new TableColumn<IKunde, String>("Vorname");
		TableColumn<IKunde, String> lastNameCol = new TableColumn<IKunde, String>("Nachname");
		TableColumn<IKunde, Integer> kundennummerCol = new TableColumn<IKunde, Integer>("Kundennr.");
		

		kundentable.getColumns().addAll(firstNameCol, lastNameCol,kundennummerCol);

		firstNameCol.setMinWidth(120);
		firstNameCol.setCellValueFactory(new PropertyValueFactory<IKunde, String>("Vorname"));
		

		lastNameCol.setMinWidth(120);
		lastNameCol.setCellValueFactory(new PropertyValueFactory<IKunde, String>("Name"));
		
		kundennummerCol.setMinWidth(120);
		kundennummerCol.setCellValueFactory(new PropertyValueFactory<IKunde, Integer>("Kundennummer"));
		
		/*
		 * fill the table with all the customers in our customer List
		 */
		kundentable.setItems(Kundenliste.getListeDerKunden());
		vb2.getChildren().add(kundentable);

		Scene scene2 = new Scene(vb2, 460, 800);
		mainStage.setScene(scene2);
		scene2.getStylesheets().add("myStylesheet.css");
		mainStage.show();
		
		
		
        /*
         * Handler
         * opens a new window that shows the information of the customer that got clicked
         */
		
		kundentable.addEventFilter(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>() {
					public void handle(MouseEvent event) {
						if (event.getClickCount() > 1) {
							
							log2.fine("Selected Object from Table.");
							 final IKunde selected = (IKunde)kundentable.getSelectionModel().getSelectedItem();
							 
							 final Stage infoStage = new Stage();
							 log2.fine("Launching Info Stage.");
							InfoGUI.startInfoGUI(infoStage,mainStage, selected);
						}
				}});
		
		
		/*
		 * add search function
		 */
		
		Kundenliste.search(suchfeld, kundentable);
		


		
		/*
		 * Handler
		 * opens a new window to create a new customer
		 */
		add.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){	
				
				log2.fine("Adding new contact.");
				final Stage addStage = new Stage();
				addStage.setTitle("Kontakt hinzufügen");

				
				addStage.setX(900);
				addStage.setY(200);

				
		 mainStage.setOnHidden(new EventHandler<WindowEvent>() {

				public void handle(
						WindowEvent onClosing) {
						 addStage.hide();
						 log2.fine("Closed Primary Stage, terminating.");
								
						  }
						});

				VBox vb4 = new VBox();
				vb4.setPadding(new Insets(10, 50, 50,
						50));
				vb4.setSpacing(5);
				vb4.getStyleClass().add("vbox");
			
          
				Label neuerKunde = new Label();
				neuerKunde.setText("| Kunde anlegen");
				neuerKunde.getStyleClass().add("label3");
				vb4.getChildren().add(neuerKunde);
				
				
				Label vorname = new Label();
				vorname.setText("Vorname:");
				vorname.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
				vorname.setTranslateY(20);
				vorname.setTranslateX(1);
				vb4.getChildren().add(vorname);
				
				final TextField vornameSet = new TextField();
				vornameSet.setTranslateY(-10);
				vornameSet.setTranslateX(150);
				vornameSet.setMinWidth(50);
				vornameSet.setPrefWidth(50);
				vornameSet.setMaxWidth(150);
				vornameSet.setId("textfield");
				vb4.getChildren().add(vornameSet);
				
				Label nachname = new Label();
				nachname.setText("Nachname:");
				nachname.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
				nachname.setTranslateY(10);
				vb4.getChildren().add(nachname);
				
				final TextField nachnameSet = new TextField();
				nachnameSet.setTranslateY(-20);
				nachnameSet.setTranslateX(150);
				nachnameSet.setMinWidth(50);
				nachnameSet.setPrefWidth(50);
				nachnameSet.setMaxWidth(150);
				nachnameSet.setId("textfield");
				vb4.getChildren().add(nachnameSet);
				
				Label straße = new Label();
				straße.setText("Straße:");
				straße.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
				straße.setTranslateY(0);
				vb4.getChildren().add(straße);
				
				final TextField straßeSet = new TextField();
				straßeSet.setTranslateY(-30);
				straßeSet.setTranslateX(150);
				straßeSet.setMinWidth(50);
				straßeSet.setPrefWidth(50);
				straßeSet.setMaxWidth(150);
				straßeSet.setId("textfield");
				vb4.getChildren().add(straßeSet);
				
				Label hausnummer = new Label();
				hausnummer.setText("Hausnummer:");
				hausnummer.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
				hausnummer.setTranslateY(-10);
				vb4.getChildren().add(hausnummer);
				
				final TextField hausnummerSet = new TextField();
				hausnummerSet.setTranslateY(-40);
				hausnummerSet.setTranslateX(150);
				hausnummerSet.setMinWidth(50);
				hausnummerSet.setPrefWidth(50);
				hausnummerSet.setMaxWidth(150);
				hausnummerSet.setId("textfield");
				vb4.getChildren().add(hausnummerSet);
				
				Label postleitzahl = new Label();
				postleitzahl.setText("Postleitzahl:");
				postleitzahl.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
				postleitzahl.setTranslateY(-20);
				vb4.getChildren().add(postleitzahl);
				
				final TextField postleitzahlSet = new TextField();
				postleitzahlSet.setTranslateY(-50);
				postleitzahlSet.setTranslateX(150);
				postleitzahlSet.setMinWidth(50);
				postleitzahlSet.setPrefWidth(50);
				postleitzahlSet.setMaxWidth(150);
				postleitzahlSet.setId("textfield");
				vb4.getChildren().add(postleitzahlSet);
				
				Label stadt = new Label();
				stadt.setText("Stadt:");
				stadt.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
				stadt.setTranslateY(-30);
				vb4.getChildren().add(stadt);
				
				final TextField stadtSet = new TextField();
				stadtSet.setTranslateY(-60);
				stadtSet.setTranslateX(150);
				stadtSet.setMinWidth(50);
				stadtSet.setPrefWidth(50);
				stadtSet.setMaxWidth(150);
				stadtSet.setId("textfield");
				vb4.getChildren().add(stadtSet);
				
				Label land = new Label();
				land.setText("Land:");
				land.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
				land.setTranslateY(-40);
				vb4.getChildren().add(land);
				
				final TextField landSet = new TextField();
				landSet.setTranslateY(-70);
				landSet.setTranslateX(150);
				landSet.setMinWidth(50);
				landSet.setPrefWidth(50);
				landSet.setMaxWidth(150);
				landSet.setId("textfield");
				vb4.getChildren().add(landSet);
				
				Label telefon = new Label();
				telefon.setText("Telefon:");
				telefon.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
				telefon.setTranslateY(-50);
				vb4.getChildren().add(telefon);
				
				final TextField telefonSet = new TextField();
				telefonSet.setTranslateY(-80);
				telefonSet.setTranslateX(150);
				telefonSet.setMinWidth(50);
				telefonSet.setPrefWidth(50);
				telefonSet.setMaxWidth(150);
				telefonSet.setId("textfield");
				vb4.getChildren().add(telefonSet);
				
				Label kundennummer = new Label();
				kundennummer.setText("Kundennummer:");
				kundennummer.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
				kundennummer.setTranslateY(-60);
				vb4.getChildren().add(kundennummer);
				
				final TextField kundennummerSet = new TextField();
				kundennummerSet.setText(String.valueOf(Kundenliste.getListeDerKunden().get(Kundenliste.getListeDerKunden().size()-1).getKundennummer()+1));
				kundennummerSet.setEditable(false);
				kundennummerSet.setMouseTransparent(true);
				kundennummerSet.setFocusTraversable(false);
				kundennummerSet.setTranslateY(-90);
				kundennummerSet.setTranslateX(150);
				kundennummerSet.setMinWidth(50);
				kundennummerSet.setPrefWidth(50);
				kundennummerSet.setMaxWidth(150);
				kundennummerSet.setStyle("-fx-background-color: #FEFCFF");
				vb4.getChildren().add(kundennummerSet);
				
				
				Button speichern = new Button();
				speichern.setText("Speichern");
				speichern.setTranslateY(-75);
				vb4.getChildren().add(speichern);


				Scene scene3 = new Scene(vb4, 600, 600);
				scene3.getStylesheets().add("myStylesheet.css");
				addStage.setScene(scene3);

				addStage.show();
				
			
				/*
				 * Handler
				 * creates a new customer and checks if the customer already exists
				 */
				speichern.setOnAction(new EventHandler<ActionEvent>(){
					public void handle(ActionEvent event){
						log2.fine("Saving new Contact.");
						
						try{
                            Integer.parseInt(postleitzahlSet.getText());
                            Integer.parseInt(hausnummerSet.getText());
                        
                     }
                     catch (NumberFormatException f){
                        
                    	 log2.log(Level.WARNING, "Number Format Exception, probably invalid input. Launching Alert Window.", f);
                         System.out.println("Fehler");
                        
                         Alert formatException2 = new Alert(AlertType.WARNING);
                         formatException2.setTitle("Falsche Eingabe");
                         formatException2.setContentText("Bitte eine gültige Zahl eingeben!");

                         formatException2.showAndWait();
                     }
						
						String notiz= "";
					
                                                      /*
                                                       * stream
                                                       * checks if the customer already exists
                                                       */
						
						                        	  if((Kundenliste.getListeDerKunden().stream().filter(i -> 
						                        	     i.getVorname().toLowerCase().equals(vornameSet.getText().toLowerCase())&&
						                        	     i.getName().toLowerCase().equals(nachnameSet.getText().toLowerCase())	&&
						              					 i.getHausnummer() ==Integer.parseInt(hausnummerSet.getText()) &&
						              				     i.getLand().toLowerCase().equals(landSet.getText().toLowerCase()) &&
						              				   	 i.getPostleitzahl()== Integer.parseInt(postleitzahlSet.getText()) &&
						              				     i.getStadt().toLowerCase().equals(stadtSet.getText().toLowerCase()) &&
						              					 i.getStraße().toLowerCase().equals(straßeSet.getText().toLowerCase()) &&
						              					 i.getTelefon().toLowerCase().equals(telefonSet.getText().toLowerCase()))).count() != 0)
						                        	  {

						                                  Alert doppelterKunde = new Alert(AlertType.INFORMATION);
						                                  doppelterKunde.setTitle("Kunde existiert bereits");
						                                  doppelterKunde.setContentText("Kunde existiert bereits. Wollen Sie ihn trotzdem nochmal anlegen?");


						                                  ButtonType yesButton = new ButtonType("Ja");
						                                  ButtonType noButton = new ButtonType("Nein", ButtonData.CANCEL_CLOSE);

						                                  doppelterKunde.getButtonTypes().setAll(yesButton, noButton);

						                                  Optional<ButtonType> result = doppelterKunde.showAndWait();
						                                  if (result.get() == yesButton){
						                                	  log2.fine("Adding duplicate Contact.");
						                                	
						                                	  /*
						                                	   * thread
						                                	   * adds customer 
						                                	   */
						                                	  Platform.runLater( () -> newdriver.add(
						              									"Kunde",
						              									nachnameSet.getText(),
						              									vornameSet.getText(),
						              									straßeSet.getText(),
						              									Integer.parseInt(hausnummerSet.getText()),
						              									Integer.parseInt(postleitzahlSet.getText()),
						              									stadtSet.getText(),
						              									landSet.getText(),
						              									telefonSet.getText(),
						              									Kundenliste.getListeDerKunden().get(Kundenliste.getListeDerKunden().size()-1).getKundennummer()+1,
						              									notiz
						              								
						              							    ) );
						              						           
						     										
						              						 landSet.getStyle();	    
						                                 	 addStage.hide();
						                                 	
						                                 	 
						                                  } else{
						                                 	 doppelterKunde.hide();
						                                     
						                                  }
						                        	  }
						                        	  
						                        	  else {
						                        		  
						                        		  /*
					                                	   * thread
					                                	   * adds customer 
					                                	   */
						                        		  Platform.runLater( () -> newdriver.add(
					              									"Kunde",
					              									nachnameSet.getText(),
					              									vornameSet.getText(),
					              									straßeSet.getText(),
					              									Integer.parseInt(hausnummerSet.getText()),
					              									Integer.parseInt(postleitzahlSet.getText()),
					              									stadtSet.getText(),
					              									landSet.getText(),
					              									telefonSet.getText(),
					              									Kundenliste.getListeDerKunden().get(Kundenliste.getListeDerKunden().size()-1).getKundennummer()+1,
					              									notiz
					              								
					              							    ) );
					              						           
						          							
						          						   

						          						addStage.hide();
						          						log2.fine("Terminating Info Stage.");
						                        	  }
					                              }
						                          });
						
			
				}});
				
	
			};
	}
	
	