package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import layout.game_table.ScoreToken;

public class Demo extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		Scene scene = new Scene(new ScoreToken());
		stage.setScene(scene);
		stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
