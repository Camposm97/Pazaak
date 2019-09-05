package layout.game_table;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Separator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import model.Align;
import model.PazaakCard;
import util.FXUtil;

public class GameTable extends StackPane {
	private BorderPane root;
	private StackPane topPane, bottomPane;
	private VBox leftPane, rightPane;
	private GridPane centerPane;
	private PazaakCard[] deck;
	
	public GameTable(PazaakCard[] deck) {
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
		root = new BorderPane(centerPane, topPane, rightPane, bottomPane, leftPane);
		root.setPadding(FXUtil.DEFAULT_INSETS);
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
		topPane.setPadding(FXUtil.DEFAULT_INSETS);
	}
	
	public void buildBottomPane() {
		bottomPane = new StackPane(FXUtil.loadDecor());
	}
	
	public void buildLeftPane() {
		leftPane = new VBox(10);
		leftPane.getChildren().addAll(FXUtil.loadDecor());
	}
	
	public void buildRightPane() {
		rightPane = new VBox(10);
		rightPane.getChildren().addAll(FXUtil.loadDecor());
	}
	
	public void buildCenterPane() {
		centerPane = new GridPane();
	}
}
