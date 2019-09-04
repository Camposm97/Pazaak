package util;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import model.CardInfo;
import model.CardType;
import model.Card;

public class FXUtil {
	public static final Insets DEFAULT_INSETS = new Insets(10);
	public static final int BTN_WIDTH = 128;

	public static VBox loadVBox(Node... nodes) {
		VBox vBox = new VBox(10);
		for (Node n : nodes) {
			vBox.getChildren().add(n);
		}
		return vBox;
	}

	public static LinearGradient loadLg(CardType cardType) {
		List<Stop> stops = new ArrayList<>();
		if (cardType != null) {
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
