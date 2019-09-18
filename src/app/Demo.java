package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import layout.gameboard.GameBoard;
import model.Hand;

public class Demo extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		Scene scene = new Scene(new GameBoard(new Hand()));
		stage.setScene(scene);
		stage.setMaximized(true);
		stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
