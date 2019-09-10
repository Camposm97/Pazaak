package model;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import layout.gameboard.HandPane;
import layout.gameboard.NamePane;
import layout.gameboard.ScoreBoard;
import layout.gameboard.TurnIndicator;

public class Player {
	private TurnIndicator ti;
	private NamePane namePane;
	private ScoreBoard scoreBoard;
	private HandPane handPane;
	
	public Player(String name, Hand hand) {
		this.ti = new TurnIndicator();
		this.namePane = new NamePane(name);
		this.scoreBoard = new ScoreBoard();
		this.handPane = new HandPane(hand);
	}
	
	public HBox getPlayerPane(Align a) {
		HBox hBox = new HBox(10);
		hBox.setAlignment(Pos.CENTER);
		if (a.equals(Align.LEFT))
			hBox.getChildren().addAll(ti, namePane.build(a), handPane.getCs());
		else
			hBox.getChildren().addAll(handPane.getCs(), namePane.build(a), ti);
		return hBox;
	}
	
	public void hideCards() {
		handPane.hideCards();
	}
	
	public ScoreBoard getScoreBoard() {
		return scoreBoard;
	}
	
	public HandPane getHandPane() {
		return handPane;
	}
}
