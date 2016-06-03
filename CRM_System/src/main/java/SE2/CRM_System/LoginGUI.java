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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

		Label lbl1 = new Label("Username:");
		vb.getChildren().add(lbl1);

		final TextField txtUser = new TextField();
		vb.getChildren().add(txtUser);

		Label lbl2 = new Label("Password:");
		vb.getChildren().add(lbl2);

		final PasswordField pwf1 = new PasswordField();
		vb.getChildren().add(pwf1);

		final Label lblMessage = new Label();
		vb.getChildren().add(lblMessage);

		Button btn1 = new Button();
		btn1.setText("Login");
		vb.getChildren().add(btn1);

		// Adding VBox to the scene
		final Scene scene = new Scene(vb);
		primaryStage.setScene(scene);
		primaryStage.show();

		// Handler

		btn1.setOnAction(new EventHandler<ActionEvent>() {

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
					
					Driver newdriver = new Driver();
					newdriver.add_wirklichjetzt();

					TableView kundentable = new TableView();

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

					// Handler

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

										Label vorname = new Label();
										vorname.setText("Vorname:");
										vorname.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
										vorname.setTranslateY(20);
										vorname.setTranslateX(1);
										vb3.getChildren().add(vorname);
										
										final TextField vornameGet = new TextField();
										vornameGet.setText(Kundenliste.listeDerKunden.get(1).Vorname);
										vornameGet.setTranslateY(0);
										vornameGet.setTranslateX(150);
										vornameGet.setEditable(false);
										vornameGet.setMinWidth(50);
										vornameGet.setPrefWidth(50);
										vornameGet.setMaxWidth(150);
										vb3.getChildren().add(vornameGet);
										
										Label nachname = new Label();
										nachname.setText("Nachname:");
										nachname.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
										vb3.getChildren().add(nachname);
										
										final TextField nachnameGet = new TextField();
										nachnameGet.setText(Kundenliste.listeDerKunden.get(1).Name);
										nachnameGet.setTranslateY(0);
										nachnameGet.setTranslateX(150);
										nachnameGet.setEditable(false);
										nachnameGet.setMinWidth(50);
										nachnameGet.setPrefWidth(50);
										nachnameGet.setMaxWidth(150);
										vb3.getChildren().add(nachnameGet);
										
										Label straße = new Label();
										straße.setText("Straße:");
										straße.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
										vb3.getChildren().add(straße);
										
										final TextField straßeGet = new TextField();
										straßeGet.setText(Kundenliste.listeDerKunden.get(1).Straße);
										straßeGet.setTranslateY(0);
										straßeGet.setTranslateX(150);
										straßeGet.setEditable(false);
										straßeGet.setMinWidth(50);
										straßeGet.setPrefWidth(50);
										straßeGet.setMaxWidth(150);
										vb3.getChildren().add(straßeGet);
										
										Label hausnummer = new Label();
										hausnummer.setText("Hausnummer:");
										hausnummer.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
										vb3.getChildren().add(hausnummer);
										
										final TextField hausnummerGet = new TextField();
										hausnummerGet.setText(String.valueOf(Kundenliste.listeDerKunden.get(1).Hausnummer));
										hausnummerGet.setTranslateY(0);
										hausnummerGet.setTranslateX(150);
										hausnummerGet.setEditable(false);
										hausnummerGet.setMinWidth(50);
										hausnummerGet.setPrefWidth(50);
										hausnummerGet.setMaxWidth(150);
										vb3.getChildren().add(hausnummerGet);
										
										Label postleitzahl = new Label();
										postleitzahl.setText("Postleitzahl:");
										postleitzahl.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
										vb3.getChildren().add(postleitzahl);
										
										final TextField postleitzahlGet = new TextField();
										postleitzahlGet.setText(String.valueOf(Kundenliste.listeDerKunden.get(1).Postleitzahl));
										postleitzahlGet.setTranslateY(0);
										postleitzahlGet.setTranslateX(150);
										postleitzahlGet.setEditable(false);
										postleitzahlGet.setMinWidth(50);
										postleitzahlGet.setPrefWidth(50);
										postleitzahlGet.setMaxWidth(150);
										vb3.getChildren().add(postleitzahlGet);
										
										Label stadt = new Label();
										stadt.setText("Stadt:");
										stadt.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
										vb3.getChildren().add(stadt);
										
										final TextField stadtGet = new TextField();
										stadtGet.setText(Kundenliste.listeDerKunden.get(1).Stadt);
										stadtGet.setTranslateY(0);
										stadtGet.setTranslateX(150);
										stadtGet.setEditable(false);
										stadtGet.setMinWidth(50);
										stadtGet.setPrefWidth(50);
										stadtGet.setMaxWidth(150);
										vb3.getChildren().add(stadtGet);
										
										Label land = new Label();
										land.setText("Land:");
										land.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
										vb3.getChildren().add(land);
										
										final TextField landGet = new TextField();
										landGet.setText(Kundenliste.listeDerKunden.get(1).Land);
										landGet.setTranslateY(0);
										landGet.setTranslateX(150);
										landGet.setEditable(false);
										landGet.setMinWidth(50);
										landGet.setPrefWidth(50);
										landGet.setMaxWidth(150);
										vb3.getChildren().add(landGet);
										
										Label telefon = new Label();
										telefon.setText("Telefon:");
										telefon.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
										vb3.getChildren().add(telefon);
										
										final TextField telefonGet = new TextField();
										telefonGet.setText(Kundenliste.listeDerKunden.get(1).Telefon);
										telefonGet.setTranslateY(0);
										telefonGet.setTranslateX(150);
										telefonGet.setEditable(false);
										telefonGet.setMinWidth(50);
										telefonGet.setPrefWidth(50);
										telefonGet.setMaxWidth(150);
										vb3.getChildren().add(telefonGet);
										
										Label kundennummer = new Label();
										kundennummer.setText("Kundennummer:");
										kundennummer.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
										vb3.getChildren().add(kundennummer);
										
										final TextField kundennummerGet = new TextField();
										kundennummerGet.setText(String.valueOf(Kundenliste.listeDerKunden.get(1).Kundennummer));
										kundennummerGet.setTranslateY(0);
										kundennummerGet.setTranslateX(150);
										kundennummerGet.setEditable(false);
										kundennummerGet.setMinWidth(50);
										kundennummerGet.setPrefWidth(50);
										kundennummerGet.setMaxWidth(150);
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
										
										// Handler
										
										
										bearbeiten.setOnAction(new EventHandler<ActionEvent>(){
											public void handle(ActionEvent event){
												vornameGet.setEditable(true);
												nachnameGet.setEditable(true);
												straßeGet.setEditable(true);
												hausnummerGet.setEditable(true);
												postleitzahlGet.setEditable(true);
												stadtGet.setEditable(true);
												landGet.setEditable(true);
												telefonGet.setEditable(true);
												kundennummerGet.setEditable(true);
												
												bearbeiten.setText("Änderungen speichern");
												
												bearbeiten.setOnAction(new EventHandler<ActionEvent>(){
													public void handle(ActionEvent event){
														
														//Überschreiben des ausgewählten Kunden uns seiner Daten
													}
											});

											
												
											
										}});
										
										}
							}});
				
				}
				else {

					lblMessage.setText("Incorrect user or pw.");

					lblMessage.setTextFill(Color.RED);

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
