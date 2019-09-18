package model;

import java.util.List;

import layout.gameboard.TurnMark;
import util.CardMover;
import util.WinnerUtil;

public class PazaakAI {
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
		if (totalScore == WinnerUtil.GOAL 
				|| (totalScore >= (WinnerUtil.GOAL - 2) 
				&& totalScore >= oppTotalScore) && totalScore <= WinnerUtil.GOAL) {
			System.out.println("Standing");
			tm.setStand(true); // No more turns, let Player go and see if he/she can tie
		} else if (totalScore > WinnerUtil.GOAL) {
			tryToFindAMinusCard();
		} else if (totalScore < WinnerUtil.GOAL) {
			tryToFindAPlusCard();
		}
	}
	
	public void tryToFindAPlusCard() {
		System.out.println("Maybe use a plus card or skip turn");
		if (totalScore < (WinnerUtil.GOAL - 6)) {
			tm.setFlag(false); // Skip Turn
		} else {
			List<PazaakCard> list = hand.getCards();
			PazaakCard pc = null;
			for (PazaakCard card : list) {
				if (card.getInfo().getType().equals(CardType.Plus)) {
					System.out.println("Found a plus card");
					int score = card.getInfo().getNum() + totalScore;
					if (score == WinnerUtil.GOAL || score >= (WinnerUtil.GOAL - 2)) {
						pc = card;
						break;
					}
				}
			}
			if (pc != null) { // Use Plus Card
				System.out.println("Using Plus Card");
				CardMover.moveToField(tm.cs().handPane(), pc);
			} else {
				System.out.println("Standing and Admitting Defeat");
				tm.setStand(true);
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
				int score = card.getInfo().getNum() + totalScore;
				if (score <= WinnerUtil.GOAL || score >= (WinnerUtil.GOAL - 2)) {
					pc = card;
					break;  // This card can help
				}
			}
		}
		if (pc != null) { // Use Minus Card
			System.out.println("Using Minus Card");
			CardMover.moveToField(tm.cs().handPane(), pc);
		} else { // Stand and Admit Defeat
			System.out.println("Standing and Admitting Defeat");
			tm.setStand(true);
		}
	}
}
