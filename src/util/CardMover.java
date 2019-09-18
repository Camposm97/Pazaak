package util;

import layout.gameboard.HandPane;
import model.PazaakCard;

public class CardMover {
	public static void moveToField(HandPane handPane, PazaakCard pc) {
		pc.setOnMouseClicked(null);
		handPane.getChildren().remove(pc); // Remove the card from the hand
		handPane.cs().add(pc);
		handPane.cs().tm().setFlag(false);
		WinningUtil.computeScore(handPane);
	}
}
