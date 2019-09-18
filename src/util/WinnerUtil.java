package util;

import layout.gameboard.CardScore;

public class WinnerUtil {
	public static final int GOAL = 20;

	public static void chooseWinner(CardScore cs1) {
		CardScore cs2 = cs1.handPane().opp().getHandPane().cs();
		String name1 = cs2.handPane().opp().getName();
		String name2 = cs1.handPane().opp().getName();
		int score1 = cs1.getTotalScore();
		int score2 = cs2.getTotalScore();
		System.out.println("Total Scores: " + score1 + " | " + score2);
		if (cs1.sb().getScores().wonAll()) {
			System.out.println(name2 + " won the game!");
		} else if (cs2.sb().getScores().wonAll()) {
			System.out.println(name1 + " won the game!");
		} else {
			if (score1 == score2) {
				System.out.println("Tie");
			} else if (score1 == GOAL && score2 != GOAL) {
				System.out.println(name1 + " is the winner");
				cs2.sb().getScores().addWin();
			} else if (score1 != GOAL && score2 == GOAL) {
				System.out.println(name2 + " is the winner");
				cs1.sb().getScores().addWin();
			} else if (score1 > score2 && score1 <= GOAL) {
				System.out.println(name1 + " is the winner");
				cs2.sb().getScores().addWin();
			} else if (score1 < score2 && score2 <= GOAL) {
				System.out.println(name2 + " is the winner");
				cs1.sb().getScores().addWin();
			}
//			cs1.reset();
//			cs2.reset();
//			cs1.tm().setFlag(true);
		}
	}
}
