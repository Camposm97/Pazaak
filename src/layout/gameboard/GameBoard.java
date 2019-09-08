package layout.gameboard;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Separator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import model.Align;
import model.Hand;
import util.FXUtil;

public class GameBoard extends StackPane {
	private BorderPane root;
	private StackPane topPane, bottomPane;
	private ScoreBoard s1, s2;
	private GridPane centerPane;
	private Hand hand;
	
	public GameBoard(Hand hand) {
		super(FXUtil.loadDecor());
		this.hand = hand;
		buildRoom();
	}
	
	public void buildRoom() {
		buildTopPane();
		buildBottomPane();
		s1 = new ScoreBoard();
		s2 = new ScoreBoard();
		buildCenterPane();
		root = new BorderPane(centerPane, topPane, s2, bottomPane, s1);
		root.setPadding(new Insets(20));
		this.getChildren().add(root);
	}
	
	public void buildTopPane() {
		PlayerPane pp1 = new PlayerPane("You", Align.LEFT);
		PlayerPane pp2 = new PlayerPane("Opponent", Align.RIGHT);
		Separator s = new Separator();
		s.setOrientation(Orientation.VERTICAL);
		HBox hBox = FXUtil.loadHBox(pp1, s, pp2);
		hBox.setAlignment(Pos.CENTER);
		hBox.setPadding(FXUtil.DEFAULT_INSETS);
		topPane = new StackPane(FXUtil.loadDecor(), hBox);
	}
	
	public void buildBottomPane() {
		bottomPane = new StackPane(FXUtil.loadDecor());
		HBox hBox = new HBox(10);
		hBox.setAlignment(Pos.CENTER);
		Separator sep = new Separator(Orientation.VERTICAL);
		GridPane gridPane1 = new GridPane();
		gridPane1.setPadding(new Insets(50));
		gridPane1.setHgap(10);
		gridPane1.setVgap(10);
		for (int i = 0; i < hand.getCards().size(); i++) {
			gridPane1.add(hand.getCards().get(i), i, 0);
		}
		hBox.getChildren().addAll(gridPane1, sep);
		bottomPane.getChildren().add(hBox);
	}
	
	public void buildCenterPane() {
		centerPane = new GridPane();
	}
}
