package util;

import layout.gameboard.HandPane;
import model.PazaakAI;

public class WinningUtil {
	public static void computeScore(HandPane handPane) {
		int totalScore = handPane.cs().getTotalScore();
		if (totalScore == PazaakAI.GOAL) {
			handPane.cs().tm().setStand(true);
			handPane.cs().tm().setFlag(false);
		}
	}
}
