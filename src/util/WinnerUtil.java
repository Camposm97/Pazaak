package util;

import layout.gameboard.CardScore;

public class WinnerUtil {
	public static final int GOAL = 20;
	public static void chooseWinner(CardScore cs1) {
		CardScore cs2 = cs1.handPane().opp().getHandPane().cs();
		int score1 = cs1.getTotalScore();
		int score2 = cs2.getTotalScore();
		if (score1 == score2) {
			System.out.println("Tie");
		} else if (score1 == GOAL && score2 != GOAL) {
			System.out.println("Player 1 is the winner");
		} else if (score1 != GOAL && score2 == GOAL) {
			System.out.println("Player 2 is the winner");
		} else if (score1 > score2 && score1 <= GOAL) {
			System.out.println("Player 1 is the winner");
		} else {
			System.out.println("Player 2 is the winner");
		}
	}
}
