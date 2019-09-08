package layout.gameboard;

import javafx.scene.layout.StackPane;
import model.Hand;

public class HandPane extends StackPane {
	private Hand hand;
	
	public HandPane(Hand hand) {
		this.hand = hand;
	}
	
	public Hand getHand() {
		return hand;
	}
}
