package layout.gameboard;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import model.Hand;
import model.PazaakCard;
import util.FXUtil;

public class HandPane extends GridPane {
	private PlayField playField;
	private Hand hand;
	
	public HandPane(Hand hand) {
		this.playField = new PlayField();
		this.hand = hand;
		this.setHgap(10);
		this.setVgap(10);
		this.setAlignment(Pos.CENTER);
		this.setPadding(FXUtil.DEFAULT_INSETS);
		
		// Display Cards
		for (int i = 0; i < hand.getCards().size(); i++) {
			PazaakCard pc  = hand.getCards().get(i);
			pc.setOnMouseClicked(e -> {
				super.getChildren().remove(pc);
				playField.add(pc);
				pc.setOnMouseClicked(null);
			});
			super.add(hand.getCards().get(i), i, 0);
			
		}
	}
	
	public PlayField getPlayField() {
		return playField;
	}
	
	public Hand getHand() {
		return hand;
	}
}
