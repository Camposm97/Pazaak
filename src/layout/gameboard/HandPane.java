package layout.gameboard;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import model.Card;
import model.Hand;
import model.PazaakCard;
import util.FXUtil;

public class HandPane extends GridPane {
	private CardScore cs;
	private Hand hand;

	public HandPane(Hand hand) {
		this.cs = new CardScore();
		this.hand = hand;
		this.setHgap(10);
		this.setVgap(10);
		this.setAlignment(Pos.CENTER);
		this.setPadding(FXUtil.DEFAULT_INSETS);
		displayCards();
	}

	public CardScore getCs() {
		return cs;
	}

	public Hand getHand() {
		return hand;
	}

	public void hideCards() {
		for (int i = 0; i < hand.getCards().size(); i++) {
			super.add(new Card(), i, 0);
		}
	}

	private void displayCards() {
		// Display Cards From Hand & Place Holders
		for (int i = 0; i < hand.getCards().size(); i++) {
			PazaakCard pc = hand.getCards().get(i);
			pc.setOnMouseClicked(e -> {
				super.getChildren().remove(pc);
				cs.add(pc);
				pc.setOnMouseClicked(null);
			});
			super.add(new Card(), i, 0);
			super.add(hand.getCards().get(i), i, 0);
		}
	}
}
