package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Hand {
	private static final int SIZE = 4;
	private List<PazaakCard> cards;
	
	public static List<PazaakCard> drawCards(PazaakCard[] deck) {
		List<PazaakCard> deckList = Arrays.asList(deck);
		List<PazaakCard> cards = new ArrayList<>(SIZE);
		Collections.shuffle(deckList);
		for (int i = 0; i < SIZE; i++)
			cards.add(deckList.get(i));
		return cards;
	}
	
	public Hand(PazaakCard[] deck) {
		this.cards = drawCards(deck);
	}
	
	public Hand() {
		this.cards = drawCards(DeckPicker.pickRandomDeck());
	}
	
	public List<PazaakCard> getCards() {
		return cards;
	}
}
