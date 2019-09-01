package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import model.CardInfo;
import util.FXUtil;

public class PazaakCard extends StackPane {
	private static final int WIDTH_OF_CARD = 120;
	private static final int HEIGHT_OF_CARD = 180;
	private static final int ARC_SIZE = 20;
	private CardInfo cardInfo;
	
	public PazaakCard() {
		this.cardInfo = new CardInfo();
		buildCard();
	}
	
	public PazaakCard(CardInfo cardInfo) {
		this.cardInfo = cardInfo;
		buildCard();
	}
	
	public CardInfo getCardInfo() {
		return cardInfo;
	}
	
	private void buildCard() {
		Rectangle r = new Rectangle(WIDTH_OF_CARD, HEIGHT_OF_CARD, FXUtil.loadLg(null)); // Background
		r.setStroke(Color.BLACK);
		r.setArcWidth(ARC_SIZE);
		r.setArcHeight(ARC_SIZE);
		getChildren().add(r);
		
		if (cardInfo != null) {
			setOnMouseEntered(e -> {
				r.setStroke(Color.YELLOW);
			});
			setOnMouseExited(e -> {
				r.setStroke(Color.BLACK);
			});
			getChildren().add(loadCardDetails());
		} else {
			Rectangle r1 = new Rectangle(WIDTH_OF_CARD * 0.9, HEIGHT_OF_CARD * 0.95, FXUtil.loadLg(null));
			r1.setStroke(Color.DIMGRAY);
			r1.setArcWidth(ARC_SIZE);
			r1.setArcHeight(ARC_SIZE);
			getChildren().add(r1);
		}
	}
	
	private VBox loadCardDetails() {
		Polygon pg1 = loadPoly(1); // Above Display of Number
		Polygon pg2 = loadPoly(1); // Below Display of Number
		pg2.setRotate(180);
		Polygon pg3 = loadPoly(0); // Bottom Detail of Card
		
		Rectangle r = new Rectangle(WIDTH_OF_CARD*0.85, HEIGHT_OF_CARD*0.2, Color.BLACK);
		r.setStroke(Color.GRAY);
		
		Label lbl = new Label(cardInfo.toString());
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
		pg.setFill(FXUtil.loadLg(cardInfo.getType()));
		return pg;
	}
}
