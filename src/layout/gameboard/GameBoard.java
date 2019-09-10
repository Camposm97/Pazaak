package layout.gameboard;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Separator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import model.Align;
import model.Hand;
import model.Player;
import util.FXUtil;

public class GameBoard extends StackPane {
	private BorderPane root;
	private StackPane topPane, bottomPane, centerPane;
	private Player p1, p2;
	
	public GameBoard(Hand hand) {
		super(FXUtil.loadDecor(1));
		this.p1 = new Player("You", hand);
		this.p2 = new Player("Opponent", new Hand());
		p2.hideCards();
//		p2.getHandPane().setDisable(true);
		buildBoard();
	}
	
	public void buildBoard() {
		buildTopPane();
		buildBottomPane();
		buildCenterPane();
		root = new BorderPane(centerPane, topPane, p1.getScoreBoard(), bottomPane, p2.getScoreBoard());
		root.setPadding(new Insets(10));
		this.getChildren().add(root);
	}
	
	public void buildTopPane() {
		Separator s = new Separator();
		s.setOrientation(Orientation.VERTICAL);
		HBox hBox = FXUtil.loadHBox(p1.getPlayerPane(Align.LEFT), s, p2.getPlayerPane(Align.RIGHT));
		hBox.setAlignment(Pos.CENTER);
		hBox.setPadding(FXUtil.DEFAULT_INSETS);
		topPane = new StackPane(FXUtil.loadDecor(), hBox);
	}
	
	public void buildBottomPane() {
		bottomPane = new StackPane(FXUtil.loadDecor());
		Separator sep = new Separator(Orientation.VERTICAL);
		HBox hBox = FXUtil.loadHBox(p1.getHandPane(), sep, p2.getHandPane());
		hBox.setAlignment(Pos.CENTER);
		hBox.setPadding(FXUtil.DEFAULT_INSETS);
		bottomPane.getChildren().add(hBox);
	}
	
	public void buildCenterPane() {
		centerPane = new StackPane(FXUtil.loadDecor());
		Separator sep = new Separator(Orientation.VERTICAL);
		sep.prefHeightProperty().bind(centerPane.heightProperty());
		HBox hBox = FXUtil.loadHBox(
				p1.getHandPane().getCs().getPlayField(), sep, 
				p2.getHandPane().getCs().getPlayField());
		hBox.setSpacing(100);
		hBox.setAlignment(Pos.CENTER);
		hBox.setPadding(FXUtil.DEFAULT_INSETS);
		centerPane.getChildren().add(hBox);
	}
}
