package util;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import model.CardType;

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
	
	public static StackPane loadBackground() {
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

	public static LinearGradient loadLg(CardType type) {
		List<Stop> stops = new ArrayList<>();
		if (type != null) {
			if (type.equals(CardType.Plus)) {
				stops.add(new Stop(0.1f, Color.DARKBLUE));
				stops.add(new Stop(0.5f, Color.BLUE));
				stops.add(new Stop(0.9f, Color.DARKBLUE));
			} else if (type.equals(CardType.Minus)) {
				stops.add(new Stop(0.1f, Color.DARKRED));
				stops.add(new Stop(0.5f, Color.RED));
				stops.add(new Stop(0.9f, Color.DARKRED));
			} else { // Main Card
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
