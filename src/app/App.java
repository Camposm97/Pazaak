package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import util.FXUtil;

public class App extends Application {
	private BorderPane root;
	
	@Override
	public void init() {
		root = FXUtil.loadRoot();
	}
	
	@Override
	public void start(Stage stage) {
		Scene scene = new Scene(root, 700, 500);
		stage.getIcons().add(new Image("pazaak.png"));
		stage.setTitle("Pazaak v1.0");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
