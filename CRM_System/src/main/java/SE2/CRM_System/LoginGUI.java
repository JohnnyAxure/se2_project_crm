package SE2.CRM_System;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LoginGUI extends Application {

	String checkUser, checkPw;

	@Override
	public void start(final Stage primaryStage) {
		primaryStage.setTitle("CRM Manager");
		
		/*
		 * 
		 * DAS HIER DRIN LASSEN!!111einself12
		 * 
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

	
					//Neues Fenster
					
					TextField suchfeld = new TextField();
					vb2.getChildren().add(suchfeld);

					Button search = new Button();
					search.setText("Suchen");
					vb2.getChildren().add(search);

					Button add = new Button();
					add.setText("+");
					vb2.getChildren().add(add);
//					add.setOnAction(new EventHandler<ActionEvent>() {
//			            @Override public void handle(ActionEvent e) {
//			                kundenliste.add(new Kunde(checkPw, checkPw, checkPw, checkPw, 0, 0, checkPw, checkPw, checkPw, 0));
//			            }
//			        });

					// TextArea textarea1 = new TextArea();
					// textarea1.setText("");
					// System.out.println(kundenliste.listeDerKunden.size());
					// for (int i = 0; i < kundenliste.listeDerKunden.size();
					// i++) {
					//
					// textarea1.setText(textarea1.getText() + "\n"
					// + kundenliste.listeDerKunden.get(i).getName());
					//
					// System.out.println(kundenliste.listeDerKunden.get(i)
					// .getName());
					// System.out.println(kundenliste.listeDerKunden.size());
					// }
					// vb2.getChildren().add(textarea1);
//					IKunde a = FactoryKunde.add("Kunde", "Hans", "Peter", "Musterstraße",
//							1, 72121, "Musterstadt", "Musterland", "0711/12334567", 001);
//					
//					IKunde b = FactoryKunde.add("Kunde", "Gans", "Gustav", "Nelkenweg", 2, 70707, "Entenhausen", "Entenland", "0715468945", 002);
                    Driver newdriver = new Driver();
					newdriver.add_wirklichjetzt();
					
					TableView table = new TableView();

					final Label label = new Label("Kundenliste");
					label.setFont(new Font("Arial", 20));

					table.setEditable(true);
					TableColumn firstNameCol = new TableColumn("Vorname");
					TableColumn lastNameCol = new TableColumn("Nachname");
					TableColumn kundennummerCol = new TableColumn(
							"Kundennummer");

					table.getColumns().addAll(firstNameCol, lastNameCol,
							kundennummerCol);

					firstNameCol.setMinWidth(100);
					firstNameCol.setCellValueFactory(new PropertyValueFactory<Kunde, String>("Vorname"));
					lastNameCol.setMinWidth(100);
					lastNameCol.setCellValueFactory(new PropertyValueFactory<Kunde, String>("Name"));
					kundennummerCol.setMinWidth(100);
					kundennummerCol.setCellValueFactory(new PropertyValueFactory<Kunde, String>("Kundennummer"));

					
					table.setItems(kundenliste.listeDerKunden);
					vb2.getChildren().add(table);

					Scene scene2 = new Scene(vb2, 400, 800);
					primaryStage.setScene(scene2);
					primaryStage.show();

				
				
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
