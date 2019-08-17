package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {
	private BorderPane root;
	
	@Override
	public void init() {
		root = new BorderPane();
	}
	
	@Override
	public void start(Stage stage) {
		Scene scene = new Scene(root);
		stage.setTitle("Pazaak");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
