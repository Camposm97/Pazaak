package util;

import java.util.List;

import layout.gameboard.TurnIndicator;
import model.CardType;
import model.Hand;
import model.PazaakCard;

public class Initiative {
	private static final byte GOAL = 20;
	
	public static void makeMove(TurnIndicator ti) {
		/*
		 * Take the total card score and determine to end turn, stand, or
		 * pick a card to +/- the total card score.  
		 */
		int totalScore = ti.getCs().getTotalScore();
		if (totalScore == GOAL) {
			System.out.println("Standing...");
			ti.setStand(true); // No more turns, let Player go and see if he/she can tie
		} else if (totalScore > GOAL) {
			System.out.println("Looking for a minus card...");
			// Search for a minus card and use it
			Hand hand = ti.getCs().getHandPane().getHand();
			List<PazaakCard> list = hand.getCards();
			PazaakCard pc = null;
			for (PazaakCard card : list) {
				if (card.getInfo().getType().equals(CardType.Minus)) {
					int score = card.getInfo().getNum();
					int tempTotalScore = score + totalScore;
					pc = card;
					break;  // We found a minus type card
				}
			}
			if (pc != null) { // Use Minus Card
				
			} else { // Stand and Admit Defeat
				ti.setStand(true);
			}
		} else if (totalScore < GOAL) { 
			System.out.println("Maybe use a plus card or skip turn");
			/* Determine if A.I. should use a plus card if possible for stand depending if the the total score
			 * is close to 20. 
			 */
		}
	}
}
