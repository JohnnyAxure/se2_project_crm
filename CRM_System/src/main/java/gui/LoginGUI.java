package gui;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import persons.Admin;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class LoginGUI extends Application {

	private static final Logger log1 = Logger.getLogger(LoginGUI.class.getName());
	
	@Override
	public void start(final Stage loginStage) {
		loginStage.setTitle("CRM Manager");

		Handler handlerPrimary = new ConsoleHandler();
		handlerPrimary.setLevel(Level.FINE);
		log1.addHandler(handlerPrimary);
		log1.setLevel(Level.FINE);
		log1.fine("Launched Primary Stage.");
		
		VBox vb = new VBox();
		vb.setPadding(new Insets(10, 50, 50, 50));
		vb.setSpacing(10);
		vb.getStyleClass().add("vbox");

		ImageView iv = new ImageView(getClass().getResource(
				"Database_iStock_000020783950XSmall_4d.png"
				+ "").toExternalForm());
		vb.getChildren().add(iv);

		Image image = new Image(getClass().getResourceAsStream("grey_person_icon2.png"));

		Label username = new Label("Benutzername:");
		username.setGraphic(new ImageView(image));
		vb.getChildren().add(username);

		final TextField txtUser = new TextField();
		txtUser.setId("textfield");
		vb.getChildren().add(txtUser);
		
		Image image2 = new Image(getClass().getResourceAsStream("lock-icon2.png"));

		Label password = new Label(" Passwort:");
		password.setGraphic(new ImageView(image2));
		vb.getChildren().add(password);

		final PasswordField pwf1 = new PasswordField();
		pwf1.setId("textfield");
		vb.getChildren().add(pwf1);

		final Label lblMessage = new Label();
		vb.getChildren().add(lblMessage);

		Button loginButton = new Button();
		loginButton.setText("Login");
		loginButton.setDefaultButton(true);
		loginButton.getStyleClass().add("button");
		vb.getChildren().add(loginButton);

		// Adding VBox to the scene
		
		
		
			final Scene scene = new Scene(vb);
			scene.getStylesheets().clear();
			scene.getStylesheets().add("myStylesheet.css");
			loginStage.setScene(scene);
			loginStage.show();

			// Handler

			loginButton.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {

				    String checkUser = txtUser.getText().toString();

					String checkPw = pwf1.getText().toString();

					if (checkUser.equals(Admin.username)
							&& checkPw.equals(Admin.password)) {

						log1.fine("Inserted correct username and password.");
						MainGUI.startMainGui(loginStage);
						log1.fine("Launching Main GUI.");
					}
					else {

						lblMessage.setText("Falsches Passwort oder Name");

						lblMessage.setTextFill(Color.RED);
						
						log1.fine("Inserted wrong username or password.");
						
						txtUser.requestFocus();

					}

					txtUser.setText("");

					pwf1.setText("");

				}

			});

		}

		public static void main(String[] args) {
			launch(args);
			log1.fine("Terminating Application.");
		}

	}
