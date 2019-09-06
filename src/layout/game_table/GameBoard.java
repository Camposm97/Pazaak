package layout.game_table;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Separator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import model.Align;
import model.PazaakCard;
import util.FXUtil;

public class GameBoard extends StackPane {
	private BorderPane root;
	private StackPane topPane, bottomPane;
	private ScoreBoard s1, s2;
	private GridPane centerPane;
	private PazaakCard[] deck;
	
	public GameBoard(PazaakCard[] deck) {
		super(FXUtil.loadDecor());
		this.deck = deck;
		buildRoom();
	}
	
	public void buildRoom() {
		buildTopPane();
		buildBottomPane();
		buildLeftPane();
		buildRightPane();
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
	}
	
	public void buildLeftPane() {
		s1 = new ScoreBoard();
	}
	
	public void buildRightPane() {
		s2 = new ScoreBoard();
	}
	
	public void buildCenterPane() {
		centerPane = new GridPane();
	}
}
