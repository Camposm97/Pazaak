package app;

import javafx.application.Application;
import javafx.stage.Stage;
import stage.MyStage;

public class App extends Application {
	public static final String TITLE = "Pazaak v1.0";
	
	@Override
	public void start(Stage stage) {
		stage = new MyStage();
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
