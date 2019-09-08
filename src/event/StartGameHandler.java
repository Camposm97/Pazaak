package event;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.stage.StageStyle;
import layout.DeckPickerPane;
import layout.gameboard.GameBoard;
import model.DeckPicker;
import model.Hand;
import model.PazaakCard;
import stage.PauseStage;

public class StartGameHandler implements EventHandler<ActionEvent> {
	private DeckPickerPane pane;

	public StartGameHandler(DeckPickerPane pane) {
		this.pane = pane;
	}

	@Override
	public void handle(ActionEvent e) {
		PazaakCard[] deck = pane.getDeckPicker().getPickedCards();
		if (deck != null) {
			Scene scene = pane.getScene();
			scene.setRoot(new GameBoard(new Hand(deck)));
			scene.setOnKeyPressed(f -> {
				if (f.getCode() == KeyCode.ESCAPE)
					new PauseStage(scene.getWindow());
			});
		} else {
			Alert a = new Alert(AlertType.ERROR);
			a.setHeaderText("Your deck is either too small or big!");
			a.setContentText("You have to pick exactly " + DeckPicker.DECK_SIZE + " cards.");
			a.initStyle(StageStyle.UNDECORATED);
			a.initOwner(pane.getScene().getWindow());
			a.showAndWait();
		}
	}
}
