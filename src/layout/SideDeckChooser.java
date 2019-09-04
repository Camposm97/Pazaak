package layout;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Card;
import model.CardInfo;
import model.PazaakCard;
import util.FXUtil;

public class SideDeckChooser extends BorderPane {
	private GridPane cardGrid;
	
	public SideDeckChooser() {
		initCardGrid();
		setCenter(loadCenterPane(cardGrid));
	}
	
	private HBox loadGridLabels() {
		String tfStyle = "-fx-text-fill: white; -fx-background-color: black; "
				+ "-fx-border-color: gray; -fx-font-size: 24pt;";
		TextField tf1 = new TextField("Available Cards");
		tf1.setStyle(tfStyle);
		tf1.setEditable(false);
		tf1.setAlignment(Pos.CENTER);
		TextField tf2 = new TextField("Choose Sidedeck");
		tf2.setStyle(tfStyle);
		tf2.setEditable(false);
		tf2.setAlignment(Pos.CENTER);
		HBox hBox = new HBox(100);
		hBox.setAlignment(Pos.CENTER);
		hBox.setPadding(FXUtil.DEFAULT_INSETS);
		hBox.getChildren().addAll(tf1, tf2);
		return hBox;
	}
	
	private void initCardGrid() {
		cardGrid = new GridPane();
		cardGrid.setAlignment(Pos.TOP_CENTER);
		cardGrid.setPadding(new Insets(80, 120, 80, 120));
		cardGrid.setHgap(30);
		cardGrid.setVgap(30);
		cardGrid.setGridLinesVisible(true);
		cardGrid.add(loadGridLabels(), 0, 0, 7, 1);
		
		int col = 0, row = 1;
		Card pc = null;
		for (int i = 1; i <= 6; i++) {
			pc = new PazaakCard(new CardInfo(i));
			cardGrid.add(pc, col, row);
			col++;
			if (col >= 6) {
				col = 0;
				row++;
			}
		}
		for (int i = -1; i >= -6; i--) {
			pc = new PazaakCard(new CardInfo(i));
			cardGrid.add(pc, col, row);
			col++;
		}
	}
	
	private StackPane loadCenterPane(Node node) {
		StackPane pane = new StackPane();
		Rectangle r1 = new Rectangle();
		r1.setFill(Color.GRAY);
		r1.widthProperty().bind(pane.widthProperty());
		r1.heightProperty().bind(pane.heightProperty());
		Rectangle r2 = new Rectangle();
		r2.setFill(Color.LIGHTGRAY);
		r2.setStroke(Color.BLACK);
		r2.widthProperty().bind(r1.widthProperty().multiply(0.98));
		r2.heightProperty().bind(r1.heightProperty().multiply(0.98));
		r2.setArcWidth(20);
		r2.setArcHeight(20);
		pane.getChildren().addAll(r1, r2, node);
		return pane;
	}
}
