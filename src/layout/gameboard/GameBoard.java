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
import util.FXUtil;

public class GameBoard extends StackPane {
	private BorderPane root;
	private StackPane topPane, bottomPane, centerPane;
	private ScoreBoard s1, s2;
	private HandPane handPane1;
	private HandPane handPane2;
	
	public GameBoard(Hand hand) {
		super(FXUtil.loadDecor(1));
		this.handPane1 = new HandPane(hand);
		this.handPane2 = new HandPane(new Hand());
		buildBoard();
	}
	
	public void buildBoard() {
		buildTopPane();
		buildBottomPane();
		s1 = new ScoreBoard(); // Left Pane
		s2 = new ScoreBoard(); // Right Pane
		buildCenterPane();
		root = new BorderPane(centerPane, topPane, s2, bottomPane, s1);
		root.setPadding(new Insets(10));
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
		Separator sep = new Separator(Orientation.VERTICAL);
		HBox hBox = FXUtil.loadHBox(handPane1, sep, handPane2);
		hBox.setAlignment(Pos.CENTER);
		hBox.setPadding(FXUtil.DEFAULT_INSETS);
		bottomPane.getChildren().add(hBox);
	}
	
	public void buildCenterPane() {
		centerPane = new StackPane(FXUtil.loadDecor());
		Separator sep = new Separator(Orientation.VERTICAL);
		sep.prefHeightProperty().bind(centerPane.heightProperty());
		HBox hBox = FXUtil.loadHBox(handPane1.getPlayField(), sep, handPane2.getPlayField());
		hBox.setSpacing(100);
		hBox.setAlignment(Pos.CENTER);
		hBox.setPadding(FXUtil.DEFAULT_INSETS);
		centerPane.getChildren().add(hBox);
	}
}
