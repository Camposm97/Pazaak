package app;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import layout.gameboard.GameBoard;
import model.Hand;

/**
 * Things to Fix:
 * - When someone wins, clear the playing fields and add a ScoreMark
 * to the winner's score board.  
 * @author Camposm97
 */
public class Demo extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		Scene scene = new Scene(new GameBoard(new Hand()));
		scene.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ESCAPE)
				Platform.exit();
		});
		stage.setScene(scene);
		stage.setMaximized(true);
		stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
