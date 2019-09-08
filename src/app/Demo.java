package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import layout.gameboard.GameBoard;
import model.DeckPicker;
import model.Hand;
import model.PazaakCard;

public class Demo extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		PazaakCard[] deck = DeckPicker.pickRandomDeck();
		Scene scene = new Scene(new GameBoard(new Hand(deck)));
		stage.setScene(scene);
		stage.setFullScreen(true); 
		stage.show();
		
    }

    public static void main(String[] args) {
        launch(args);
    }
}
