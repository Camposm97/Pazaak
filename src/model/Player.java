package model;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import layout.gameboard.HandPane;
import layout.gameboard.NamePane;
import layout.gameboard.PlayField;
import layout.gameboard.ScoreBoard;

public class Player {
	private String name;
	private HandPane handPane;
	
	public Player(String name, Hand hand) {
		this.name = name;
		this.handPane = new HandPane(hand);
	}
	
	public String getName() {
		return name;
	}
	
	public HandPane getHandPane() {
		return handPane;
	}
	
	public ScoreBoard getScoreBoard() {
		return handPane.getCs().getScoreBoard();
	}
	
	public HBox getPlayerPane(Align a) {
		HBox hBox = new HBox(10);
		hBox.setAlignment(Pos.CENTER);
		if (a.equals(Align.LEFT))
			hBox.getChildren().addAll(handPane.getCs().getTi(), new NamePane(name, a), handPane.getCs());
		else
			hBox.getChildren().addAll(handPane.getCs(), new NamePane(name, a), handPane.getCs().getTi());
		return hBox;
	}
	
	public PlayField getPlayField() {
		return handPane.getCs().getPf();
	}
	
	public void setOpponent(Player opponent) {
		handPane.setOpponent(opponent);
	}
	
	public void setTurn(boolean flag) {
		handPane.getCs().getTi().setFlag(flag);
	}
	
	public void hideCards() {
		handPane.hideCards();
	}
}
