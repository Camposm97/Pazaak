package layout.gameboard;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Separator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import model.Align;
import model.GameMaster;
import model.Hand;
import model.Player;
import util.FXUtil;

public class GameBoard extends StackPane {
	private BorderPane root;
	private GameMaster gm;
	private StackPane topPane, bottomPane, centerPane;
	
	public GameBoard(Hand hand) {
		super(FXUtil.loadDecor(1));
		this.gm = new GameMaster(new Player("You", hand), new Player("Opponent", new Hand()));
		buildBoard();
		gm.startGame();
	}
	
	public void buildBoard() {
		// Build Top Pane
		Separator s1 = new Separator(Orientation.VERTICAL);
		HBox hBox1 = FXUtil.loadHBox(gm.getP1().getPlayerPane(Align.LEFT), s1, gm.getP2().getPlayerPane(Align.RIGHT));
		hBox1.setAlignment(Pos.CENTER);
		hBox1.setPadding(FXUtil.DEFAULT_INSETS);
		topPane = new StackPane(FXUtil.loadDecor(), hBox1);
		
		// Build Bottom Pane
		Separator s2 = new Separator(Orientation.VERTICAL);
		HBox hBox2 = FXUtil.loadHBox(gm.getP1().getHandPane(), s2, gm.getP2().getHandPane());
		hBox2.setAlignment(Pos.CENTER);
		hBox2.setPadding(FXUtil.DEFAULT_INSETS);
		bottomPane = new StackPane(FXUtil.loadDecor(), hBox2);

		
		// Build Center Pane
		Separator s3 = new Separator(Orientation.VERTICAL);
		HBox hBox3 = FXUtil.loadHBox(gm.getP1().getPlayField(), s3, gm.getP2().getPlayField());
		hBox3.setSpacing(100);
		hBox3.setAlignment(Pos.CENTER);
		hBox3.setPadding(FXUtil.DEFAULT_INSETS);
		centerPane = new StackPane(FXUtil.loadDecor(), hBox3);
		s3.prefHeightProperty().bind(centerPane.heightProperty());

		// Place the Built Panes onto root (BorderPane)
		root = new BorderPane(centerPane, topPane, gm.getP1().getScoreBoard(), bottomPane, gm.getP2().getScoreBoard());
		root.setPadding(new Insets(10));
		this.getChildren().add(root);
	}
}
