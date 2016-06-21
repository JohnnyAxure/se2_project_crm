package gui;

import java.util.Optional;
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
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import mainFunctionality.Driver;
import mainFunctionality.Kundenliste;
import persons.Kunde;
import javafx.application.Platform;

public abstract class MainGUI extends Application{

	public final static TableView<Kunde> kundentable = new TableView<Kunde>();
	
	
 // Thread 
	
	@SuppressWarnings("unchecked")
	public static void startMainGui(final Stage mainStage) {
		
		 Thread threadRefresh = new Thread(() -> {
		        while (true) {
		            try {
						Thread.sleep(3000);
					} catch (Exception e) {
						e.printStackTrace();
					} 
		            // Guarded wait observable list 
		            
		           kundentable.refresh();
		        }
		    }); 
		 threadRefresh.start();
	
		
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
		final TableColumn<Kunde, String> firstNameCol = new TableColumn<Kunde, String>("Vorname");
		TableColumn<Kunde, String> lastNameCol = new TableColumn<Kunde, String>("Nachname");
		TableColumn<Kunde, Integer> kundennummerCol = new TableColumn<Kunde, Integer>("Kundennr.");
		

		kundentable.getColumns().addAll(firstNameCol, lastNameCol,kundennummerCol);

		firstNameCol.setMinWidth(120);
		firstNameCol.setCellValueFactory(new PropertyValueFactory<Kunde, String>("Vorname"));
		

		lastNameCol.setMinWidth(120);
		lastNameCol.setCellValueFactory(new PropertyValueFactory<Kunde, String>("Name"));
		
		kundennummerCol.setMinWidth(120);
		kundennummerCol.setCellValueFactory(new PropertyValueFactory<Kunde, Integer>("Kundennummer"));
		
		kundentable.setItems(Kundenliste.listeDerKunden);
		vb2.getChildren().add(kundentable);

		Scene scene2 = new Scene(vb2, 460, 800);
		mainStage.setScene(scene2);
		scene2.getStylesheets().add("myStylesheet.css");
		mainStage.show();
		
		
		// Handler Kontakt
		

		kundentable.addEventFilter(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>() {
					public void handle(MouseEvent event) {
						if (event.getClickCount() > 1) {
							
							 final Kunde selected = (Kunde)kundentable.getSelectionModel().getSelectedItem();
							 
							 final Stage infoStage = new Stage();
							InfoGUI.startInfoGUI(infoStage,mainStage, selected);
						}
				}});
		
		
		//Suchfeld
		
		Kundenliste.search(suchfeld, kundentable);
		


		// Handler 
		
		add.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){	
				
				final Stage addStage = new Stage();
				addStage.setTitle("Kontakt hinzufügen");

				// specify stage locations.
				addStage.setX(900);
				addStage.setY(200);

				// add a trigger to hide the secondary
				// stage when the primary stage is
				// hidden.
				// this will cause all stages to be
				// hidden (which will cause the app to
				// terminate).
				mainStage.setOnHidden(new EventHandler<WindowEvent>() {

							public void handle(
									WindowEvent onClosing) {
								addStage.hide();
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
				kundennummerSet.setText(String.valueOf(Kundenliste.listeDerKunden.get(Kundenliste.listeDerKunden.size()-1).Kundennummer+1));
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
				
				// Handler 
				
				speichern.setOnAction(new EventHandler<ActionEvent>(){
					public void handle(ActionEvent event){
						
						
						try{
                            Integer.parseInt(postleitzahlSet.getText());
                            Integer.parseInt(hausnummerSet.getText());
                        
                     }
                     catch (NumberFormatException f){
                        
                    	 
                         System.out.println("Fehler");
                        
                         Alert formatException2 = new Alert(AlertType.WARNING);
                         formatException2.setTitle("Falsche Eingabe");
                         formatException2.setContentText("Bitte eine gültige Zahl eingeben!");

                         formatException2.showAndWait();
                     }
						
						HTMLEditor Notiz= new HTMLEditor();
					
                       //stream
						
						                        	  if((Kundenliste.listeDerKunden.stream().filter(i -> 
						                        	     i.Vorname.toLowerCase().equals(vornameSet.getText().toLowerCase())&&
						                        	     i.Name.toLowerCase().equals(nachnameSet.getText().toLowerCase())	&&
						              					 i.Hausnummer ==Integer.parseInt(hausnummerSet.getText()) &&
						              				     i.Land.toLowerCase().equals(landSet.getText().toLowerCase()) &&
						              				   	 i.Postleitzahl== Integer.parseInt(postleitzahlSet.getText()) &&
						              				     i.Stadt.toLowerCase().equals(stadtSet.getText().toLowerCase()) &&
						              					 i.Straße.toLowerCase().equals(straßeSet.getText().toLowerCase()) &&
						              					 i.Telefon.toLowerCase().equals(telefonSet.getText().toLowerCase()))).count() != 0)
						                        	  {

						                                  Alert doppelterKunde = new Alert(AlertType.INFORMATION);
						                                  doppelterKunde.setTitle("Kunde existiert bereits");
						                                  doppelterKunde.setContentText("Kunde existiert bereits. Wollen Sie ihn trotzdem nochmal anlegen?");


						                                  ButtonType yesButton = new ButtonType("Ja");
						                                  ButtonType noButton = new ButtonType("Nein", ButtonData.CANCEL_CLOSE);

						                                  doppelterKunde.getButtonTypes().setAll(yesButton, noButton);

						                                  Optional<ButtonType> result = doppelterKunde.showAndWait();
						                                  if (result.get() == yesButton){
						                                      
						                                	//thread 
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
						              									Kundenliste.listeDerKunden.get(Kundenliste.listeDerKunden.size()-1).Kundennummer+1,
						              									Notiz
						              								
						              							    ) );
						              						           
						     										
						              						 landSet.getStyle();	    
						                                 	 addStage.hide();
						                                 	 
						                                  } else{
						                                 	 doppelterKunde.hide();
						                                     
						                                  }
						                        	  }
						                        	  
						                        	  else {
                                                          //thread 
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
					              									Kundenliste.listeDerKunden.get(Kundenliste.listeDerKunden.size()-1).Kundennummer+1,
					              									Notiz
					              								
					              							    ) );
					              						           
						          							
						          						   

						          						addStage.hide();
						                        	  }
					                              }
						                          });
						
			
				}});
				
	
			};
	}
	
	

