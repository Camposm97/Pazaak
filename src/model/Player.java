package model;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import layout.gameboard.HandPane;
import layout.gameboard.NamePane;
import layout.gameboard.PlayField;
import layout.gameboard.ScoreBoard;
import util.FXUtil;

public class Player {
	private String name;
	private HandPane handPane;
	
	public Player(String name, Hand hand) {
		this.name = name;
		this.handPane = new HandPane(hand);
	}
	
	public Player() {
		this.name = "Jon";
		this.handPane = new HandPane();
	}
	
	public String getName() {
		return name;
	}
	
	public HBox getHandPane(Align a) {
		Button btStand = new Button("Stand");
		btStand.setOnAction(e -> {
			handPane.cs().tm().setStand(true);
			handPane.cs().tm().setFlag(false);
			btStand.setDisable(true);
		});
		btStand.setPrefWidth(FXUtil.BTN_WIDTH);
		Button btEndTurn = new Button("End Turn");
		btEndTurn.setOnAction(e -> {
			handPane.cs().tm().setFlag(false);
		});
		btEndTurn.setPrefWidth(FXUtil.BTN_WIDTH);
		HBox hBox = new HBox(10);
		hBox.setAlignment(Pos.CENTER);
		VBox vBox = new VBox(10);
		vBox.setAlignment(Pos.CENTER);
		vBox.getChildren().addAll(btStand, btEndTurn);
		if (a.equals(Align.LEFT))
			hBox.getChildren().addAll(vBox, handPane);
		else
			hBox.getChildren().addAll(handPane, vBox);
		return hBox;
	}
	
	public HandPane getHandPane() {
		return handPane;
	}
	
	public ScoreBoard getScoreBoard() {
		return handPane.cs().sb();
	}
	
	public HBox getPlayerPane(Align a) {
		HBox hBox = new HBox(10);
		hBox.setAlignment(Pos.CENTER);
		if (a.equals(Align.LEFT))
			hBox.getChildren().addAll(handPane.cs().tm(), new NamePane(name, a), handPane.cs());
		else
			hBox.getChildren().addAll(handPane.cs(), new NamePane(name, a), handPane.cs().tm());
		return hBox;
	}
	
	public PlayField getPlayField() {
		return handPane.cs().pf();
	}
	
	public void setOpp(Player opp) {
		handPane.setOpp(opp);
	}
	
	public void setTurn(boolean flag) {
		handPane.cs().tm().setFlag(flag);
	}
	
	public void setAIMode(boolean aiMode) {
		handPane.cs().tm().setAIMode(aiMode);
	}
	
	public void hideCards() {
		handPane.hideCards();
	}
}
