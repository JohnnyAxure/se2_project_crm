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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import mainFunctionality.Kundenliste;
import persons.Kunde;


public abstract class InfoGUI extends Application {

	private static final Logger log3 = Logger.getLogger(LoginGUI.class.getName());
	

	public static void startInfoGUI(final Stage infoStage,final Stage mainStage, final Kunde selected){

		Handler handlerThird = new ConsoleHandler();
		handlerThird.setLevel(Level.FINEST);
		log3.addHandler(handlerThird);
		log3.setLevel(Level.FINEST);

		
		infoStage.setTitle("Kontakt");
        infoStage.setX(900);
		infoStage.setY(400);

		// add a trigger to hide the secondary
		// stage when the primary stage is
		// hidden.
		// this will cause all stages to be
		// hidden (which will cause the app to
		// terminate).
		mainStage.setOnHidden(new EventHandler<WindowEvent>() {

			public void handle(
					WindowEvent onClosing) {
				infoStage.hide();
				log3.fine("Closed Primary Stage, terminating.");
			}
		});
		infoStage.setOnHidden(new EventHandler<WindowEvent>() {

					public void handle(
							WindowEvent onClosing) {
						infoStage.hide();
					}
				});

		

		VBox vb3 = new VBox();
		vb3.setPadding(new Insets(10, 50, 50,
				50));
		vb3.setSpacing(5);
		vb3.getStyleClass().add("vbox");
        
		Label kundeninfo = new Label();
		kundeninfo.setText("| Kundeninformationen");
		kundeninfo.getStyleClass().add("label3");
		vb3.getChildren().add(kundeninfo);

		Label vorname = new Label();
		vorname.setText("Vorname:");
		vorname.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		vorname.setTranslateY(20);
		vorname.setTranslateX(1);
		vb3.getChildren().add(vorname);
		
		final TextField vornameGet = new TextField();
		vornameGet.setText(selected.Vorname);
		vornameGet.setTranslateY(-10);
		vornameGet.setTranslateX(150);
		vornameGet.setEditable(false);
		vornameGet.setMouseTransparent(true);
		vornameGet.setFocusTraversable(false);
		vornameGet.setMinWidth(50);
		vornameGet.setPrefWidth(50);
		vornameGet.setMaxWidth(150);
		vornameGet.setId("textfield2"); 
		vb3.getChildren().add(vornameGet);
		
		Label nachname = new Label();
		nachname.setText("Nachname:");
		nachname.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		nachname.setTranslateY(10);
		vb3.getChildren().add(nachname);
		
		final TextField nachnameGet = new TextField();
		nachnameGet.setText(selected.Name);
		nachnameGet.setTranslateY(-20);
		nachnameGet.setTranslateX(150);
		nachnameGet.setEditable(false);
		nachnameGet.setMouseTransparent(true);
		nachnameGet.setFocusTraversable(false);
		nachnameGet.setMinWidth(50);
		nachnameGet.setPrefWidth(50);
		nachnameGet.setMaxWidth(150);
		nachnameGet.setId("textfield2"); 
		vb3.getChildren().add(nachnameGet);
		
		Label straße = new Label();
		straße.setText("Straße:");
		straße.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		straße.setTranslateY(0);
		vb3.getChildren().add(straße);
		
		final TextField straßeGet = new TextField();
		straßeGet.setText(selected.Straße);
		straßeGet.setTranslateY(-30);
		straßeGet.setTranslateX(150);
		straßeGet.setEditable(false);
		straßeGet.setMouseTransparent(true);
		straßeGet.setFocusTraversable(false);
		straßeGet.setMinWidth(50);
		straßeGet.setPrefWidth(50);
		straßeGet.setMaxWidth(150);
		straßeGet.setId("textfield2");
		vb3.getChildren().add(straßeGet);
		
		Label hausnummer = new Label();
		hausnummer.setText("Hausnummer:");
		hausnummer.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		hausnummer.setTranslateY(-10);
		vb3.getChildren().add(hausnummer);
		
		final TextField hausnummerGet = new TextField();
		hausnummerGet.setText(String.valueOf(selected.Hausnummer));
		hausnummerGet.setTranslateY(-40);
		hausnummerGet.setTranslateX(150);
		hausnummerGet.setEditable(false);
		hausnummerGet.setMouseTransparent(true);
		hausnummerGet.setFocusTraversable(false);
		hausnummerGet.setMinWidth(50);
		hausnummerGet.setPrefWidth(50);
		hausnummerGet.setMaxWidth(150);
		hausnummerGet.setId("textfield2");
		vb3.getChildren().add(hausnummerGet);
		
		Label postleitzahl = new Label();
		postleitzahl.setText("Postleitzahl:");
		postleitzahl.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		postleitzahl.setTranslateY(-20);
		vb3.getChildren().add(postleitzahl);
		
		final TextField postleitzahlGet = new TextField();
		postleitzahlGet.setText(String.valueOf(selected.Postleitzahl));
		postleitzahlGet.setTranslateY(-50);
		postleitzahlGet.setTranslateX(150);
		postleitzahlGet.setEditable(false);
		postleitzahlGet.setMouseTransparent(true);
		postleitzahlGet.setFocusTraversable(false);
		postleitzahlGet.setMinWidth(50);
		postleitzahlGet.setPrefWidth(50);
		postleitzahlGet.setMaxWidth(150);
		postleitzahlGet.setId("textfield2");
		vb3.getChildren().add(postleitzahlGet);
		
		Label stadt = new Label();
		stadt.setText("Stadt:");
		stadt.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		stadt.setTranslateY(-30);
		vb3.getChildren().add(stadt);
		
		final TextField stadtGet = new TextField();
		stadtGet.setText(String.valueOf(selected.Stadt));
		stadtGet.setTranslateY(-60);
		stadtGet.setTranslateX(150);
		stadtGet.setEditable(false);
		stadtGet.setMouseTransparent(true);
		stadtGet.setFocusTraversable(false);
		stadtGet.setMinWidth(50);
		stadtGet.setPrefWidth(50);
		stadtGet.setMaxWidth(150);
		stadtGet.setId("textfield2");
		vb3.getChildren().add(stadtGet);
		
		Label land = new Label();
		land.setText("Land:");
		land.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		land.setTranslateY(-40);
		vb3.getChildren().add(land);
		
		final TextField landGet = new TextField();
		landGet.setText(String.valueOf(selected.Land));
		landGet.setTranslateY(-70);
		landGet.setTranslateX(150);
		landGet.setEditable(false);
		landGet.setMouseTransparent(true);
		landGet.setFocusTraversable(false);
		landGet.setMinWidth(50);
		landGet.setPrefWidth(50);
		landGet.setMaxWidth(150);
		landGet.setId("textfield2");
		vb3.getChildren().add(landGet);
		
		Label telefon = new Label();
		telefon.setText("Telefon:");
		telefon.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		telefon.setTranslateY(-50);
		vb3.getChildren().add(telefon);
		
		final TextField telefonGet = new TextField();
		telefonGet.setText(String.valueOf(selected.Telefon));
		telefonGet.setTranslateY(-80);
		telefonGet.setTranslateX(150);
		telefonGet.setEditable(false);
		telefonGet.setMouseTransparent(true);
		telefonGet.setFocusTraversable(false);
		telefonGet.setMinWidth(50);
		telefonGet.setPrefWidth(50);
		telefonGet.setMaxWidth(150);
		telefonGet.setId("textfield2");
		vb3.getChildren().add(telefonGet);
		
		Label kundennummer = new Label();
		kundennummer.setText("Kundennummer:");
		kundennummer.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		kundennummer.setTranslateY(-60);
		vb3.getChildren().add(kundennummer);
		
		final TextField kundennummerGet = new TextField();
		kundennummerGet.setText(String.valueOf(selected.Kundennummer));										
		kundennummerGet.setTranslateY(-90);
		kundennummerGet.setTranslateX(150);
		kundennummerGet.setEditable(false);
		kundennummerGet.setMouseTransparent(true);
		kundennummerGet.setFocusTraversable(false);
		kundennummerGet.setMinWidth(50);
		kundennummerGet.setPrefWidth(50);
		kundennummerGet.setMaxWidth(150);
		kundennummerGet.setId("textfield2");
		vb3.getChildren().add(kundennummerGet);
		
		
		Button notiz = new Button();
		notiz.setTranslateY(-50);
		notiz.setText("Kontaktnotiz");
		vb3.getChildren().add(notiz);

		final Button bearbeiten = new Button();
		bearbeiten.setTranslateY(-85);
		bearbeiten.setTranslateX(190);
		bearbeiten.setText("Bearbeiten");
		vb3.getChildren().add(bearbeiten);
		
	    Button speichern = new Button();
	    speichern.setTranslateY(-105);
	    speichern.setTranslateX(190);
	    speichern.setText("Speichern");
	 
	   
		Button löschen = new Button();
		löschen.setTranslateY(-120);
		löschen.setTranslateX(350);
		löschen.setText("Kunde löschen");
		vb3.getChildren().add(löschen);

		Scene scene3 = new Scene(vb3, 600, 650);
		scene3.getStylesheets().add("myStylesheet.css");

		infoStage.setScene(scene3);

		infoStage.show();
		log3.fine("Launched Info Stage.");
		
		
		//Handler

		
		notiz.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				log3.fine("Adding a Note to Contact.");
				
					final Stage notizStage = new Stage();
					notizStage.setTitle("Kontakt");
					notizStage.setWidth(800);
					notizStage.setHeight(400);   
					
					final HTMLEditor htmlEditor = new HTMLEditor();
					
					htmlEditor.setHtmlText(selected.Notiz.getHtmlText());
		
		           
		            Scene scene = new Scene(htmlEditor);       
		            notizStage.setScene(scene);
		            notizStage.show();
		            log3.fine("Launched Note Stage.");
		            
		            notizStage.setOnHidden(new EventHandler<WindowEvent>() {

						public void handle(
								WindowEvent onClosing) {
							
							selected.Notiz =  htmlEditor;
							log3.fine("Closed Primary Stage, terminating.");
							notizStage.hide();
						}
					});
		        }
				
	});
		
		
		
		// Handler
		
		bearbeiten.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				
																
				vornameGet.setEditable(true);
				vornameGet.setMouseTransparent(false);
				vornameGet.setFocusTraversable(true);
				vornameGet.setId("textfield"); 
				
				nachnameGet.setEditable(true);
				nachnameGet.setMouseTransparent(false);
				nachnameGet.setFocusTraversable(true);
				nachnameGet.setId("textfield"); 
				
				straßeGet.setEditable(true);
				straßeGet.setMouseTransparent(false);
				straßeGet.setFocusTraversable(true);
				straßeGet.setId("textfield"); 
				
				hausnummerGet.setEditable(true);
				hausnummerGet.setMouseTransparent(false);
				hausnummerGet.setFocusTraversable(true);
				hausnummerGet.setId("textfield"); 
				
				postleitzahlGet.setEditable(true);
				postleitzahlGet.setMouseTransparent(false);
				postleitzahlGet.setFocusTraversable(true);
				postleitzahlGet.setId("textfield"); 	
				
				stadtGet.setEditable(true);
				stadtGet.setMouseTransparent(false);
				stadtGet.setFocusTraversable(true);
				stadtGet.setId("textfield"); 
				
				landGet.setEditable(true);
				landGet.setMouseTransparent(false);
				landGet.setFocusTraversable(true);
				landGet.setId("textfield"); 
				
				telefonGet.setEditable(true);
				telefonGet.setMouseTransparent(false);
				telefonGet.setFocusTraversable(true);
				telefonGet.setId("textfield"); 
				
				vb3.getChildren().remove(bearbeiten);
				vb3.getChildren().add(speichern);
				
				speichern.setTranslateY(-120);
				speichern.setTranslateX(190);
				löschen.setTranslateY(-84);
				löschen.setTranslateX(350);
			    
				
		}});
		
		//Handler
		
		speichern.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event){
					
					try{
                     Integer.parseInt(postleitzahlGet.getText());
                     Integer.parseInt(hausnummerGet.getText());
                 
              }
              catch (NumberFormatException f){
                 
            	  log3.log(Level.WARNING, "Number Format Exception, probably invalid input. Launching Alert Window.", f);
                  System.out.println("Fehler");
                 
                  Alert formatException2 = new Alert(AlertType.WARNING);
                  formatException2.setTitle("Falsche Eingabe");
                  formatException2.setContentText("Bitte eine gültige Zahl eingeben!");
                  
                  formatException2.showAndWait();
              }
					
					selected.setVorname(vornameGet.getText());
					selected.setName(nachnameGet.getText());
					selected.setStraße(straßeGet.getText());
					selected.setHausnummer(Integer.parseInt(hausnummerGet.getText()));
					selected.setPostleitzahl(Integer.parseInt(postleitzahlGet.getText()));
					selected.setStadt(stadtGet.getText());
					selected.setLand(landGet.getText());
					selected.setTelefon(telefonGet.getText());
					
					
					vornameGet.setEditable(false);
					vornameGet.setMouseTransparent(true);
					vornameGet.setFocusTraversable(false);
					vornameGet.setStyle("-fx-background-color: #FEFCFF");
					
					
					nachnameGet.setEditable(false);
					nachnameGet.setMouseTransparent(true);
					nachnameGet.setFocusTraversable(false);
					nachnameGet.setStyle("-fx-background-color: #FEFCFF");
					
					straßeGet.setEditable(false);
					straßeGet.setMouseTransparent(true);
					straßeGet.setFocusTraversable(false);
					straßeGet.setStyle("-fx-background-color: #FEFCFF");
					
					hausnummerGet.setEditable(false);
					hausnummerGet.setMouseTransparent(true);
					hausnummerGet.setFocusTraversable(false);
					hausnummerGet.setStyle("-fx-background-color: #FEFCFF");
					
					postleitzahlGet.setEditable(false);
					postleitzahlGet.setMouseTransparent(true);
					postleitzahlGet.setFocusTraversable(false);
					postleitzahlGet.setStyle("-fx-background-color: FEFCFF");
					
					stadtGet.setEditable(false);
					stadtGet.setMouseTransparent(true);
					stadtGet.setFocusTraversable(false);
					stadtGet.setStyle("-fx-background-color: #FEFCFF");
					
					landGet.setEditable(false);
					landGet.setMouseTransparent(true);
					landGet.setFocusTraversable(false);
					landGet.setStyle("-fx-background-color: #FEFCFF");
					
					telefonGet.setEditable(false);
					telefonGet.setMouseTransparent(true);
					telefonGet.setFocusTraversable(false);
					telefonGet.setStyle("-fx-background-color: #FEFCFF");
					

					vb3.getChildren().add(bearbeiten);
					vb3.getChildren().remove(speichern);
					
					bearbeiten.setTranslateY(-120);
					bearbeiten.setTranslateX(185);
					
				    //MainGUI.kundentable.refresh();
					
				}
		});
		
		
		
		
		// handler
		
		löschen.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
			
    
				Alert kundeLöschen = new Alert(AlertType.INFORMATION);
				kundeLöschen.setTitle("Kunde löschen");
				kundeLöschen.setContentText("Wollen Sie den Kunden wirklich löschen?");


                ButtonType yesButton = new ButtonType("Ja");
                ButtonType noButton = new ButtonType("Nein", ButtonData.CANCEL_CLOSE);

                kundeLöschen.getButtonTypes().setAll(yesButton, noButton);
                
                
                Optional<ButtonType> result = kundeLöschen.showAndWait();
                if (result.get() == yesButton){
                    
                	Kundenliste.listeDerKunden.remove(selected);
    				infoStage.hide();
    					
               	 
                } else {
                	kundeLöschen.hide();
                    
                } 

		       
			}
				
	});
		
		
		
	}

}

