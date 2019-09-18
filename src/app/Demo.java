package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import layout.gameboard.GameBoard;
import model.Hand;

/**
 * Things to Fix:
 * - Stop the AI from adding duplicate children to the playing field
 * after the human player decides to stand.
 * @author Camposm97
 */
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
