package SE2.CRM_System;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import javafx.util.Callback;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.web.HTMLEditor;
import javafx.scene.input.MouseEvent;


public class LoginGUI extends Application {

	String checkUser, checkPw;

	@Override
	public void start(final Stage primaryStage) {
		primaryStage.setTitle("CRM Manager");

		/*
		 * 
		 * DAS HIER DRIN LASSEN!!111einself123
		 */
		final Kundenliste kundenliste = new Kundenliste();

		VBox vb = new VBox();
		vb.setPadding(new Insets(10, 50, 50, 50));
		vb.setSpacing(10);

		ImageView iv = new ImageView(getClass().getResource(
				"Database_iStock_000020783950XSmall_0.jpg").toExternalForm());
		vb.getChildren().add(iv);

		Label username = new Label("Username:");
		vb.getChildren().add(username);

		final TextField txtUser = new TextField();
		vb.getChildren().add(txtUser);

		Label password = new Label("Password:");
		vb.getChildren().add(password);

		final PasswordField pwf1 = new PasswordField();
		vb.getChildren().add(pwf1);

		final Label lblMessage = new Label();
		vb.getChildren().add(lblMessage);

		Button loginButton = new Button();
		loginButton.setText("Login");
		// Button mit Enter
		loginButton.setDefaultButton(true);
		vb.getChildren().add(loginButton);

		// Adding VBox to the scene
		final Scene scene = new Scene(vb);
		primaryStage.setScene(scene);
		primaryStage.show();

		// Handler

		loginButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				checkUser = txtUser.getText().toString();

				checkPw = pwf1.getText().toString();

				if (checkUser.equals(Admin.username)
						&& checkPw.equals(Admin.password)) {

					VBox vb2 = new VBox();
					vb2.setPadding(new Insets(10, 50, 50, 50));
					vb2.setSpacing(5);

					// TextField suchfeld = new TextField();
					// GridPane.setHgrow(suchfeld, Priority.ALWAYS);

					// Neues Fenster

					TextField suchfeld = new TextField();
					vb2.getChildren().add(suchfeld);

					Button search = new Button();
					search.setText("Suchen");
					vb2.getChildren().add(search);

					Button add = new Button();
					add.setText("+");
					vb2.getChildren().add(add);
					
					final Driver newdriver = new Driver();
					newdriver.add_wirklichjetzt();

					final TableView kundentable = new TableView();

					kundentable.setEditable(true);
					final TableColumn firstNameCol = new TableColumn("Vorname");
					TableColumn lastNameCol = new TableColumn("Nachname");
					TableColumn kundennummerCol = new TableColumn("Kundennummer");
					

					kundentable.getColumns().addAll(firstNameCol, lastNameCol,kundennummerCol);
 
					firstNameCol.setMinWidth(100);
					firstNameCol.setCellValueFactory(new PropertyValueFactory<Kunde, String>("Vorname"));
					
 
					lastNameCol.setMinWidth(100);
					lastNameCol.setCellValueFactory(new PropertyValueFactory<Kunde, String>("Name"));
					
					kundennummerCol.setMinWidth(100);
					kundennummerCol.setCellValueFactory(new PropertyValueFactory<Kunde, String>("Kundennummer"));
					kundentable.setItems(kundenliste.listeDerKunden);
					vb2.getChildren().add(kundentable);

					Scene scene2 = new Scene(vb2, 400, 800);
					primaryStage.setScene(scene2);
					primaryStage.show();
					
					
					// Handler Kontakt
				

					kundentable.addEventFilter(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>() {
								public void handle(MouseEvent event) {
									if (event.getClickCount() > 1) {

										final Stage secondaryStage = new Stage();
										secondaryStage.setTitle("Kontakt");

										// specify stage locations.
										secondaryStage.setX(900);
										secondaryStage.setY(400);

										// add a trigger to hide the secondary
										// stage when the primary stage is
										// hidden.
										// this will cause all stages to be
										// hidden (which will cause the app to
										// terminate).
										primaryStage.setOnHidden(new EventHandler<WindowEvent>() {

													public void handle(
															WindowEvent onClosing) {
														secondaryStage.hide();
													}
												});

										System.out.println("double clicked");

										VBox vb3 = new VBox();
										vb3.setPadding(new Insets(10, 50, 50,
												50));
										vb3.setSpacing(5);
                                        
										
							
										//wählt den Kunden in der angeglickten Zeile aus
								        final Kunde selected = (Kunde) kundentable.getSelectionModel().getSelectedItem();
						   
										Label vorname = new Label();
										vorname.setText("Vorname:");
										vorname.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
										vorname.setTranslateY(20);
										vorname.setTranslateX(1);
										vb3.getChildren().add(vorname);
										
										final TextField vornameGet = new TextField();
										final String style = vornameGet.getStyle();
										vornameGet.setText(selected.Vorname);
										vornameGet.setTranslateY(-10);
										vornameGet.setTranslateX(150);
										vornameGet.setEditable(false);
										//vornameGet.setFont(Font.font("Verdana", FontWeight.BLACK.EXTRA_BOLD, 15));
										vornameGet.setMouseTransparent(true);
										vornameGet.setFocusTraversable(false);
										vornameGet.setMinWidth(50);
										vornameGet.setPrefWidth(50);
										vornameGet.setMaxWidth(150);
										vornameGet.setStyle("-fx-background-color: whitesmoke");
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
										nachnameGet.setStyle("-fx-background-color: whitesmoke");
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
										straßeGet.setStyle("-fx-background-color: whitesmoke");
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
										hausnummerGet.setStyle("-fx-background-color: whitesmoke");
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
										postleitzahlGet.setStyle("-fx-background-color: whitesmoke");
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
										stadtGet.setStyle("-fx-background-color: whitesmoke");
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
										landGet.setStyle("-fx-background-color: whitesmoke");
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
										telefonGet.setStyle("-fx-background-color: whitesmoke");
										vb3.getChildren().add(telefonGet);
										
										Label kundennummer = new Label();
										kundennummer.setText("Kundennummer:");
										kundennummer.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
										kundennummer.setTranslateY(-60);
										vb3.getChildren().add(kundennummer);
										
										final TextField kundennummerGet = new TextField();
										kundennummerGet.setText(String.valueOf(selected.Kundennummer));										kundennummerGet.setTranslateY(-90);
										kundennummerGet.setTranslateX(150);
										kundennummerGet.setEditable(false);
										kundennummerGet.setMouseTransparent(true);
										kundennummerGet.setFocusTraversable(false);
										kundennummerGet.setMinWidth(50);
										kundennummerGet.setPrefWidth(50);
										kundennummerGet.setMaxWidth(150);
										kundennummerGet.setStyle("-fx-background-color: whitesmoke");
										vb3.getChildren().add(kundennummerGet);
										
										
										Button notiz = new Button();
										notiz.setText("Kontaktnotiz");
										vb3.getChildren().add(notiz);

										final Button bearbeiten = new Button();
										bearbeiten.setText("Bearbeiten");
										vb3.getChildren().add(bearbeiten);

										Scene scene3 = new Scene(vb3, 600, 600);
										secondaryStage.setScene(scene3);

										secondaryStage.show();
										
										
										//Handler
								
										
										notiz.setOnAction(new EventHandler<ActionEvent>(){
											public void handle(ActionEvent event){
												
													final Stage fourthStage = new Stage();
													fourthStage.setTitle("Kontakt");
													fourthStage.setWidth(800);
													fourthStage.setHeight(400);   
													
													final HTMLEditor htmlEditor = new HTMLEditor();
													
													htmlEditor.setHtmlText(selected.Notiz.getHtmlText());
										
										            //final String INITIAL_TEXT = "<html><body>Kontaktfenster, falls noch kein Kontakt zu diesem Kunden angelegt, bitte hier anlegen:</body></html>";

		
										            Scene scene = new Scene(htmlEditor);       
										            fourthStage.setScene(scene);
										            fourthStage.show();
										            
										            fourthStage.setOnHidden(new EventHandler<WindowEvent>() {

														public void handle(
																WindowEvent onClosing) {
															
															selected.Notiz =  htmlEditor;
															
															fourthStage.hide();
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
												vornameGet.setStyle(style);
												
												
												nachnameGet.setEditable(true);
												nachnameGet.setMouseTransparent(false);
												nachnameGet.setFocusTraversable(true);
												nachnameGet.setStyle(style);
												
												straßeGet.setEditable(true);
												straßeGet.setMouseTransparent(false);
												straßeGet.setFocusTraversable(true);
												straßeGet.setStyle(style);
												
												hausnummerGet.setEditable(true);
												hausnummerGet.setMouseTransparent(false);
												hausnummerGet.setFocusTraversable(true);
												hausnummerGet.setStyle(style);
												
												postleitzahlGet.setEditable(true);
												postleitzahlGet.setMouseTransparent(false);
												postleitzahlGet.setFocusTraversable(true);
												postleitzahlGet.setStyle(style);
												
												stadtGet.setEditable(true);
												stadtGet.setMouseTransparent(false);
												stadtGet.setFocusTraversable(true);
												stadtGet.setStyle(style);
												
												landGet.setEditable(true);
												landGet.setMouseTransparent(false);
												landGet.setFocusTraversable(true);
												landGet.setStyle(style);
												
												telefonGet.setEditable(true);
												telefonGet.setMouseTransparent(false);
												telefonGet.setFocusTraversable(true);
												telefonGet.setStyle(style);
												
												
												
												bearbeiten.setText("Änderungen speichern");
												
												bearbeiten.setOnAction(new EventHandler<ActionEvent>(){
													public void handle(ActionEvent event){
														
														selected.setVorname(vornameGet.getText());
														selected.setName(nachnameGet.getText());
														selected.setStraße(straßeGet.getText());
														selected.setHausnummer(Integer.parseInt(hausnummerGet.getText()));
														selected.setPostleitzahl(Integer.parseInt(postleitzahlGet.getText()));
														selected.setStadt(stadtGet.getText());
														selected.setLand(landGet.getText());
														selected.setTelefon(telefonGet.getText());
														
													
														kundentable.refresh();
														
													}
											});

												
											
												
											
										}});
										
										}
							}});
					
					
					// Handler Kontakt hinzufügen 
					
					add.setOnAction(new EventHandler<ActionEvent>(){
						public void handle(ActionEvent event){	
							
							final Stage thirdStage = new Stage();
							thirdStage.setTitle("Kontakt hinzufügen");

							// specify stage locations.
							thirdStage.setX(900);
							thirdStage.setY(400);

							// add a trigger to hide the secondary
							// stage when the primary stage is
							// hidden.
							// this will cause all stages to be
							// hidden (which will cause the app to
							// terminate).
							primaryStage.setOnHidden(new EventHandler<WindowEvent>() {

										public void handle(
												WindowEvent onClosing) {
											thirdStage.hide();
										}
									});

							System.out.println("double clicked");

							VBox vb4 = new VBox();
							vb4.setPadding(new Insets(10, 50, 50,
									50));
							vb4.setSpacing(5);

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
							kundennummerSet.setStyle("-fx-background-color: whitesmoke");
							vb4.getChildren().add(kundennummerSet);
							
							
							Button speichern = new Button();
							speichern.setText("Speichern");
							vb4.getChildren().add(speichern);


							Scene scene3 = new Scene(vb4, 600, 600);
							thirdStage.setScene(scene3);

							thirdStage.show();
							
							// Handler speichern
							
							speichern.setOnAction(new EventHandler<ActionEvent>(){
								public void handle(ActionEvent event){
									
									
									HTMLEditor Notiz= new HTMLEditor();
									Boolean first =true;
									
									for(int i=0; i < Kundenliste.listeDerKunden.size(); i++){
										if ( Kundenliste.listeDerKunden.get(i).Vorname.toLowerCase().equals(vornameSet.getText().toLowerCase()) &&
										     Kundenliste.listeDerKunden.get(i).Name.toLowerCase().equals(nachnameSet.getText().toLowerCase())	&&
										     Kundenliste.listeDerKunden.get(i).Hausnummer ==Integer.parseInt(hausnummerSet.getText()) &&
										     Kundenliste.listeDerKunden.get(i).Land.toLowerCase().equals(landSet.getText().toLowerCase()) &&
										     Kundenliste.listeDerKunden.get(i).Postleitzahl== Integer.parseInt(postleitzahlSet.getText()) &&
										     Kundenliste.listeDerKunden.get(i).Stadt.toLowerCase().equals(stadtSet.getText().toLowerCase()) &&
										     Kundenliste.listeDerKunden.get(i).Straße.toLowerCase().equals(straßeSet.getText().toLowerCase()) &&
										     Kundenliste.listeDerKunden.get(i).Telefon.toLowerCase().equals(telefonSet.getText().toLowerCase()))
											
											first= false;
										}
									
									
									if(first){
									newdriver.add(
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
										
									    );

									thirdStage.hide();
									}
									else{
									//popup Kunde existiert bereits
										final Stage fifthStage = new Stage();
										fifthStage.setTitle("Kontakt hinzufügen");

										VBox vb5 = new VBox();
										vb5.setPadding(new Insets(10, 50, 50,
												50));
										vb5.setSpacing(5);
										
										Label infotext = new Label();
										infotext.setText("Kunde existiert bereits. Wollen Sie ihn trotzdem anlegen?");
										
										vb5.getChildren().add(infotext);
										
										
										Scene scene5 = new Scene(vb5, 300, 150);
										fifthStage.setScene(scene5);
										fifthStage.show();

										
									}
									
									
								
							}});
							
				
						}});
				}
				else {

					lblMessage.setText("Incorrect user or pw.");

					lblMessage.setTextFill(Color.RED);
					
					txtUser.requestFocus();

				}

				txtUser.setText("");

				pwf1.setText("");

			}

		});

	}

	public static void main(String[] args) {
		launch(args);
	}

}// Class
