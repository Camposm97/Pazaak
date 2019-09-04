package model;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import util.FXUtil;

public class PazaakCard extends Card {
	private CardInfo info;
	private boolean selected;
	
	public PazaakCard(CardInfo info) {
		this.info = info;
		buildCard();
	}
	
	public PazaakCard() {
		info = new CardInfo();
		buildCard();
	}
	
	public CardInfo getInfo() {
		return info;
	}
	
	public boolean isSelected() {
		return selected;
	}
	
	private void buildCard() {
		if (info != null) { // Plus or Minus Card
			if (!info.getType().equals(CardType.Main)) {
				setOnMouseClicked(e -> {
					if (selected) {
						r.setStroke(Color.BLACK);
						selected = false;
					} else {
						r.setStroke(Color.YELLOW);
						selected = true;
					}
				});
			}
			getChildren().add(loadDetails());
		} else { // Main Card
			Rectangle r1 = new Rectangle(WIDTH_OF_CARD * 0.9, HEIGHT_OF_CARD * 0.95, FXUtil.loadLg(null));
			r1.setStroke(Color.DIMGRAY);
			r1.setArcWidth(ARC_SIZE);
			r1.setArcHeight(ARC_SIZE);
			getChildren().add(r1);
		}
	}
	
	private VBox loadDetails() {
		Polygon pg1 = loadPoly(1); // Above Display of Number
		Polygon pg2 = loadPoly(1); // Below Display of Number
		pg2.setRotate(180);
		Polygon pg3 = loadPoly(0); // Bottom Detail of Card
		
		Rectangle r = new Rectangle(WIDTH_OF_CARD*0.85, HEIGHT_OF_CARD*0.2, Color.BLACK);
		r.setStroke(Color.GRAY);
		
		Label lbl = new Label(info.toString());
		lbl.setTextFill(Color.WHITE);
		lbl.setFont(Font.font(24));
		
		StackPane stackPane = new StackPane();
		stackPane.getChildren().addAll(r, lbl);
		
		VBox vBox = new VBox(5);
		vBox.setAlignment(Pos.CENTER);
		vBox.getChildren().addAll(pg1, stackPane, pg2, pg3);
		return vBox;
	}
	
	private Polygon loadPoly(int n) {
		final double width = WIDTH_OF_CARD * 0.85;
		final double x1 = (HEIGHT_OF_CARD * 0.2) - 5;
		Polygon pg = new Polygon();
		if (n == 0){
			pg.getPoints().addAll(new Double[] {
					0.0, 0.0,
					0.0, x1,
					width, x1,
					width, 0.0
			});
		} else if (n == 1) {
			pg.getPoints().addAll(new Double[] {
					0.0, 0.0,
					0.0, x1,
					(width/2)-(x1/2), x1,
					width/2, x1/2,
					(width/2)+(x1/2), x1,
					width, x1,
					width, 0.0
			});
		}
		pg.setStroke(Color.GRAY);
		pg.setFill(FXUtil.loadLg(info.getType()));
		return pg;
	}
}
