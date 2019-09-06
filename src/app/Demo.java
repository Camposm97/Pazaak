package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import layout.game_table.GameBoard;
import model.DeckPicker;
import model.PazaakCard;

public class Demo extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		PazaakCard[] deck = DeckPicker.getRandomDeck();
		Scene scene = new Scene(new GameBoard(deck));
		stage.setScene(scene);
		stage.setFullScreen(true);
		stage.show();
		
    }

    public static void main(String[] args) {
        launch(args);
    }
}
