package app;

import javafx.application.Application;
import javafx.stage.Stage;
import stage.MainStage;

public class App extends Application {
	public static final String TITLE = "Pazaak v1.0";
	
	@Override
	public void start(Stage stage) {
		stage = new MainStage();
		stage.show();
	}
	

	public static void main(String[] args) {
		launch(args);
	}
}
