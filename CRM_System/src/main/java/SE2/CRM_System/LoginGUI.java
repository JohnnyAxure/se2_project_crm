package SE2.CRM_System;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;


public class LoginGUI extends Application {


	@Override
	public void start(final Stage loginStage) {
		loginStage.setTitle("CRM Manager");

		
		VBox vb = new VBox();
		vb.setPadding(new Insets(10, 50, 50, 50));
		vb.setSpacing(10);
		//vb.getStyleClass().add("vbox");

		ImageView iv = new ImageView(getClass().getResource(
				"Database_iStock_000020783950XSmall_0.jpg").toExternalForm());
		vb.getChildren().add(iv);

		Label username = new Label("Benutzername:");
		vb.getChildren().add(username);

		final TextField txtUser = new TextField();
		vb.getChildren().add(txtUser);

		Label password = new Label("Passwort:");
		vb.getChildren().add(password);

		final PasswordField pwf1 = new PasswordField();
		vb.getChildren().add(pwf1);

		final Label lblMessage = new Label();
		vb.getChildren().add(lblMessage);

		Button loginButton = new Button();
		loginButton.setText("Login");
		loginButton.setDefaultButton(true);
		//loginButton.getStyleClass().add("button");
		vb.getChildren().add(loginButton);

		// Adding VBox to the scene
		
	
		
		final Scene scene = new Scene(vb);
		scene.getStylesheets().clear();
		//scene.getStylesheets().add("myStylesheet.css");
		loginStage.setScene(scene);
		loginStage.show();

		// Handler

		loginButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

			    String checkUser = txtUser.getText().toString();

				String checkPw = pwf1.getText().toString();

				if (checkUser.equals(Admin.username)
						&& checkPw.equals(Admin.password)) {

					MainGUI.startMainGui(loginStage);
				}
				else {

					lblMessage.setText("Falsches Passwort oder Name");

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

}
