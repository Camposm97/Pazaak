package util;

import layout.gameboard.HandPane;
import layout.gameboard.TurnMark;
import model.PazaakCard;

public class CardMover {
	public static void moveToField(HandPane handPane, PazaakCard pc) {
		pc.setOnMouseClicked(null);
		handPane.getChildren().remove(pc); // Remove the card from the hand
		handPane.cs().add(pc);

		if (handPane.cs().tm().isAIMode()) {
			int totalScore = handPane.cs().getTotalScore();
			TurnMark oppTm = handPane.opp().getHandPane().cs().tm();
			int oppTotalScore = oppTm.cs().getTotalScore();
			if (totalScore == WinnerUtil.GOAL) { // Stand since totalScore = 20
				handPane.cs().tm().setStand(true);
			} else if (totalScore >= oppTotalScore && oppTm.isStand()) {
				handPane.cs().tm().setStand(true);
			} else if (totalScore <= WinnerUtil.GOAL && totalScore > WinnerUtil.GOAL - 2) {
				handPane.cs().tm().setStand(true);
			} else {
				handPane.cs().tm().setFlag(false);
			}
		}
	}
}
