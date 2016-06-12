package SE2.CRM_System;

import java.util.Optional;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
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

					MainGUI.startMainGui(primaryStage);
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
