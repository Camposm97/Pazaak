package model;

import java.util.List;

import layout.gameboard.TurnMark;
import util.CardMover;

public class PazaakAI {
	public static final int GOAL = 20;
	private TurnMark tm;
	private int totalScore;
	private int oppTotalScore;
	private Hand hand;
	
	public PazaakAI(TurnMark tm) {
		this.tm = tm;
		this.totalScore = tm.cs().getTotalScore();
		this.oppTotalScore = tm.cs().handPane().opp().getHandPane().cs().getTotalScore();
		this.hand = tm.cs().handPane().hand();
	}
	
	public void computeMove() {
		if (totalScore == GOAL 
				|| (totalScore >= (GOAL - 2) 
				&& totalScore >= oppTotalScore) && totalScore <= GOAL) {
			System.out.println("Standing");
			tm.setStand(true); // No more turns, let Player go and see if he/she can tie
		} else if (totalScore > GOAL) {
			tryToFindAMinusCard();
		} else if (totalScore < GOAL) {
			tryToFindAPlusCard();
		}
	}
	
	public void tryToFindAPlusCard() {
		System.out.println("Maybe use a plus card or skip turn");
		if (totalScore < (GOAL - 6)) {
			tm.setFlag(false); // Skip Turn
		} else {
			List<PazaakCard> list = hand.getCards();
			PazaakCard pc = null;
			for (PazaakCard card : list) {
				if (card.getInfo().getType().equals(CardType.Plus)) {
					System.out.println("Found a plus card");
					pc = card;
					int score = pc.getInfo().getNum() + totalScore;
					if (score == GOAL || score >= (GOAL - 2)) {
						
					}
				}
			}	
		}
	}
	
	public void tryToFindAMinusCard() {
		System.out.println("Looking for a minus card...");
		// Search for a minus card and use it
		List<PazaakCard> list = hand.getCards();
		PazaakCard pc = null;
		for (PazaakCard card : list) {
			if (card.getInfo().getType().equals(CardType.Minus)) {
				System.out.println("Found a minus card");
				pc = card; // We found a minus card
				int score = pc.getInfo().getNum() + totalScore;
				// Find out if the card can help
				if (score <= GOAL || score >= (GOAL - 2)) {
					System.out.println("This minus card can help");
					break;  // This card can help
				}
				System.out.println("This minus card can't help");
			}
		}
		if (pc != null) { // Use Minus Card
			System.out.println("Using Minus Card");
			CardMover.moveToField(tm.cs().handPane(), pc);
		} else { // Stand and Admit Defeat
			System.out.println("Standing and Defeat");
			tm.setStand(true);
		}
	}
}
