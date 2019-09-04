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

	public PazaakCard(CardInfo info) { // Creates a Main/Plus/Minus Card
		this.info = info;
		buildCard();
	}

	public PazaakCard() { // Creates a Main Card (Green Card)
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
		if (!info.getType().equals(CardType.Main))
			initFunctions();
		getChildren().add(buildDetails());
	}
	
	private void initFunctions() {
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

	private VBox buildDetails() {
		Polygon pg1 = loadPoly(Poly.Pivot);
		Polygon pg2 = loadPoly(Poly.Pivot);
		pg2.setRotate(180);
		Polygon pg3 = loadPoly(Poly.Normal);

		Rectangle r1 = new Rectangle(WIDTH_OF_CARD * 0.85, HEIGHT_OF_CARD * 0.2, Color.BLACK);
		r1.setStroke(Color.GRAY);
		r1.setArcWidth(ARC_SIZE);
		r1.setArcHeight(ARC_SIZE);

		Label lbl = new Label(info.toString());
		lbl.setTextFill(Color.WHITE);
		lbl.setFont(Font.font(24));

		StackPane stackPane = new StackPane();
		stackPane.getChildren().addAll(r1, lbl);

		VBox vBox = new VBox(5);
		vBox.setAlignment(Pos.CENTER);
		vBox.getChildren().addAll(pg1, stackPane, pg2, pg3);
		return vBox;
	}

	private Polygon loadPoly(Poly poly) {
		final double width = WIDTH_OF_CARD * 0.85;
		final double pt1 = (HEIGHT_OF_CARD * 0.2) - 5;
		Polygon pg = new Polygon();
		Double[] arr;
		if (poly.equals(Poly.Normal)) {
			arr = new Double[] { 0.0, 0.0, 0.0, pt1, width, pt1, width, 0.0 };
			pg.getPoints().addAll(arr);
		} else if (poly.equals(Poly.Pivot)) {
			arr = new Double[] { 0.0, 0.0, 0.0, pt1, (width / 2) - (pt1 / 2), pt1, width / 2, pt1 / 2,
					(width / 2) + (pt1 / 2), pt1, width, pt1, width, 0.0 };
			pg.getPoints().addAll(arr);
		}
		pg.setStroke(Color.GRAY);
		pg.setFill(FXUtil.loadLg(info.getType()));
		return pg;
	}
}
