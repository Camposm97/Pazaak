package util;

import java.util.List;

import com.sun.glass.ui.CommonDialogs.Type;

import layout.gameboard.HandPane;
import layout.gameboard.TurnIndicator;
import model.CardType;
import model.Hand;
import model.PazaakCard;

public class Initiative {
	private static final byte GOAL = 20;
	
	public static void makeMove(TurnIndicator ti) {
		int totalScore = ti.getCs().getTotalScore();
		if (totalScore == GOAL) {
			ti.setStand(true); // No more turns, let Player go and see if he/she can win
		} else if (totalScore > GOAL) {
			// Search for a Minus Card and use it
			HandPane handPane = ti.getCs().getHandPane();
			Hand hand = handPane.getHand();
			List<PazaakCard> list = hand.getCards();
			PazaakCard pc = null;
			for (PazaakCard card : list) {
				if (card.getInfo().getType().equals(CardType.Minus)) {
					pc = card;
					break;  // We found a minus type card
				}
			}
			// Use Minus Card
			
		} else if (totalScore < GOAL) { 
			/* Determine if A.I. should use a Positive card if possible for stand depending if the the total score
			 * is close to 20. 
			 */
		}
			//   
		/*
		 * Take the total card score and determine to end turn, stand, or
		 * pick a card to +/- the total card score.  
		 * 
		 */
	}
}
