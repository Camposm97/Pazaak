package layout;

import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.PazaakCard;
import util.FXUtil;

public class PazaakRoom extends StackPane {
	private BorderPane root;
	private StackPane topPane, bottomPane;
	private VBox leftPane, rightPane;
	private GridPane centerPane;
	private PazaakCard[] deck;
	
	public PazaakRoom(PazaakCard[] deck) {
		super(FXUtil.loadBackground());
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
		Text t1 = new Text("You");
		t1.setFill(Color.WHITE);
		t1.setFont(Font.font(16));
		Polygon pg1 = new Polygon();
		pg1.getPoints().addAll(0.0, 0.0, 200.0, 0.0, 150.0, 40.0, 0.0, 40.0);
		StackPane pane1 = new StackPane(pg1);
		pane1.getChildren().add(t1);
		
		Text t2 = new Text("0");
		t2.setFill(Color.WHITE);
		t2.setFont(Font.font(16));
		Rectangle r1 = new Rectangle(60, 40);
		r1.setArcWidth(25);
		r1.setArcHeight(25);
		
		
		
		StackPane pane2 = new StackPane(r1, t2);
		
		Text t3 = new Text("0");
		t3.setFill(Color.WHITE);
		t3.setFont(Font.font(16));
		Rectangle r2 = new Rectangle(60, 40);
		r2.setArcWidth(25);
		r2.setArcHeight(25);
		StackPane pane3 = new StackPane(r2, t3);
		
		Text t4 = new Text("Computer");
		t4.setFill(Color.WHITE);
		t4.setFont(Font.font(16));
		Polygon pg2 = new Polygon();
		pg2.getPoints().addAll(0.0, 0.0, 200.0, 0.0, 200.0, 40.0, 40.0, 40.0);
		StackPane pane4 = new StackPane(pg2);
		pane4.getChildren().add(t4);
		
		HBox hBox = new HBox(10);
		hBox.setPadding(FXUtil.DEFAULT_INSETS);
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().addAll(pane1, pane2, pane3, pane4);
		
		topPane = new StackPane(FXUtil.loadBackground());
		topPane.setPadding(FXUtil.DEFAULT_INSETS);
		topPane.getChildren().addAll(hBox);
	}
	
	public void buildBottomPane() {
		bottomPane = new StackPane(FXUtil.loadBackground());
	}
	
	public void buildLeftPane() {
		leftPane = new VBox(10);
		leftPane.getChildren().addAll(FXUtil.loadBackground());
	}
	
	public void buildRightPane() {
		rightPane = new VBox(10);
		rightPane.getChildren().addAll(FXUtil.loadBackground());
	}
	
	public void buildCenterPane() {
		centerPane = new GridPane();
	}
}
