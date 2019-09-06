package model;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import util.FXUtil;

public class DeckPicker {
	public static final int DECK_SIZE = 10;
	private static final int ROW_SIZE = 2, COL_SIZE = 6;
	private CardMatrix cardMatrix;
	
	public static PazaakCard[] getRandomDeck() {
		PazaakCard[] deck = new PazaakCard[DECK_SIZE];
		int i = 0;
		while (i < 10) {
			int n = (int)(Math.random() * (6 - ((int)(Math.random() * 6)))) - 6;
			if (n != 0)
				deck[i++] = new PazaakCard(n);
		}
		System.out.println(deck.length);
		return deck;
	}
	
	public DeckPicker() {
		cardMatrix = loadCardMatrix();
	}
	
	public CardMatrix loadCardMatrix() {
		CardMatrix cardMatrix = new CardMatrix(ROW_SIZE, COL_SIZE);
		int n = 1;
		for (int i = 0; i < cardMatrix.rowLength(); i++) {
			for (int j = 0; j < cardMatrix.colLength(); j++) {
				cardMatrix.add(new PazaakCard(n));				
				if (n > 0)
					n++;
				else
					n--;
			}
			n = -1;
		}
		return cardMatrix;
	}
	
	public PazaakCard[] getPickedCards() {
		return cardMatrix.getSelectedCards(DECK_SIZE);
	}
	
	public StackPane loadPane() {
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.TOP_CENTER);
		gridPane.setPadding(new Insets(30));
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		for (int i = 0; i < cardMatrix.rowLength(); i++)
			for (int j = 0; j < cardMatrix.colLength(); j++)
				gridPane.add(cardMatrix.get(i, j), j, i);
		StackPane centerPane = new StackPane();
		centerPane.getChildren().addAll(FXUtil.loadDecor(), gridPane);
		return centerPane;
	}
}
