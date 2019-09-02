package util;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import layout.PazaakCard;
import model.CardInfo;
import model.CardType;

public class FXUtil {
	public static final Insets DEFAULT_INSETS = new Insets(10);
	public static final int BTN_WIDTH = 128;
	
	public static VBox loadVBox(Node...nodes) {
		VBox vBox = new VBox(10);
		for (Node n : nodes) {
			vBox.getChildren().add(n);
		}
		return vBox;
	}
	
	public static void displayCards(GridPane gridPane) {
		PazaakCard card1 = new PazaakCard(new CardInfo(1));
		PazaakCard card2 = new PazaakCard(new CardInfo(2));
		PazaakCard card3 = new PazaakCard(new CardInfo(3));
		PazaakCard card4 = new PazaakCard(new CardInfo(4));
		PazaakCard card5 = new PazaakCard(new CardInfo(5));
		PazaakCard card6 = new PazaakCard(new CardInfo(6));
		gridPane.addRow(1, card1, card2, card3, card4, card5, card6);
		
		PazaakCard card7 = new PazaakCard(new CardInfo(-1));
		PazaakCard card8 = new PazaakCard(new CardInfo(-2));
		PazaakCard card9 = new PazaakCard(new CardInfo(-3));
		PazaakCard card10 = new PazaakCard(new CardInfo(-4));
		PazaakCard card11 = new PazaakCard(new CardInfo(-5));
		PazaakCard card12 = new PazaakCard(new CardInfo(-6));
		gridPane.addRow(2, card7, card8, card9, card10, card11, card12);
	}
	
	public static LinearGradient loadLg(CardType cardType) {
		List<Stop> stops = new ArrayList<>();
		if(cardType != null) {
			if (cardType.equals(CardType.Plus)) {
				stops.add(new Stop(0.1f, Color.DARKBLUE));
				stops.add(new Stop(0.5f, Color.BLUE));
				stops.add(new Stop(0.9f, Color.DARKBLUE));
			} else if (cardType.equals(CardType.Minus)) {
				stops.add(new Stop(0.1f, Color.DARKRED));
				stops.add(new Stop(0.5f, Color.RED));
				stops.add(new Stop(0.9f, Color.DARKRED));
			} else {
				stops.add(new Stop(0.1f, Color.DARKGREEN));
				stops.add(new Stop(0.5f, Color.LIME));
				stops.add(new Stop(0.9f, Color.DARKGREEN));
			}
		} else {
			stops.add(new Stop(0.1f, Color.DIMGRAY));
			stops.add(new Stop(0.5f, Color.LIGHTGRAY));
			stops.add(new Stop(0.9f, Color.DIMGRAY));
		}
		LinearGradient lg = new LinearGradient(0, 0, 1, 0, true, CycleMethod.REFLECT, stops);
		return lg;
	}
}
