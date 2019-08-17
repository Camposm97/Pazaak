package src.app;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
	@Override
	public void start(Stage stage) {
		stage.setTitle("Pazaak");
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
