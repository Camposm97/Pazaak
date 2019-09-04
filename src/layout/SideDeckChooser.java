package layout;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
	private PazaakCard[][] cards;
	
	public SideDeckChooser() {
		cards = new PazaakCard[2][6];
		setTop(loadTopPane());
		setCenter(loadCenterPane());
	}
	
	private StackPane loadTopPane() {
		String tfStyle = "-fx-text-fill: white; -fx-background-color: black; "
				+ "-fx-border-color: gray; -fx-font-size: 20pt;";
		TextField tf1 = new TextField("Available Cards");
		tf1.setStyle(tfStyle);
		tf1.setEditable(false);
		tf1.setAlignment(Pos.CENTER);
		TextField tf2 = new TextField("Choose Sidedeck");
		tf2.setStyle(tfStyle);
		tf2.setEditable(false);
		tf2.setAlignment(Pos.CENTER);
		
		HBox hBox = new HBox(10);
		hBox.setAlignment(Pos.CENTER);
		hBox.setPadding(FXUtil.DEFAULT_INSETS);
		hBox.getChildren().addAll(tf1, tf2);
		
		StackPane topPane = new StackPane();
		topPane.getChildren().addAll(loadBackground(), hBox);
		return topPane;
	}
	
	private StackPane loadCenterPane() {
		cardGrid = new GridPane();
		cardGrid.setAlignment(Pos.TOP_CENTER);
		cardGrid.setPadding(new Insets(30));
		cardGrid.setHgap(30);
		cardGrid.setVgap(30);
		
		int col = 0, row = 0;
		PazaakCard pc = null;
		for (int i = 1; i <= 6; i++) {
			pc = new PazaakCard(new CardInfo(i));
			cardGrid.add(pc, col, row);
			cards[row][col] = pc;
			col++;
			if (col >= 6) {
				col = 0;
				row++;
			}
		}
		for (int i = -1; i >= -6; i--) {
			pc = new PazaakCard(new CardInfo(i));
			cards[row][col] = pc;
			cardGrid.add(pc, col, row);
			col++;
		}
		for (int i = 0; i < cards.length; i++) {
			for (int j = 0; j < cards[i].length; j++) {
				System.out.print(cards[i][j].getInfo().toString() + " ");
			}
			System.out.println();
		}
		
		StackPane centerPane = new StackPane();
		centerPane.getChildren().addAll(loadBackground(), cardGrid);
		return centerPane;
	}
	
	private StackPane loadBackground() {
		StackPane pane = new StackPane();
		Rectangle r1 = new Rectangle();
		r1.setFill(Color.GRAY);
		r1.widthProperty().bind(pane.widthProperty());
		r1.heightProperty().bind(pane.heightProperty());
		r1.setArcWidth(20);
		r1.setArcHeight(20);
		Rectangle r2 = new Rectangle();
		r2.setFill(Color.LIGHTGRAY);
		r2.setStroke(Color.BLACK);
		r2.widthProperty().bind(r1.widthProperty().multiply(0.98));
		r2.heightProperty().bind(r1.heightProperty().multiply(0.98));
		r2.setArcWidth(20);
		r2.setArcHeight(20);
		pane.getChildren().add(r2);
		return pane;
	}
}
