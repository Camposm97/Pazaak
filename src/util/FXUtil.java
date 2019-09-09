package util;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
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
	
	public static HBox loadHBox(Node...nodes) {
		HBox hBox = new HBox(10);
		for (Node n : nodes) {
			hBox.getChildren().add(n);
		}
		return hBox;
	}
	
	public static StackPane loadDecor() {
		StackPane pane = new StackPane();
		Rectangle r1 = new Rectangle();
		r1.setFill(Color.LIGHTGRAY);
		r1.setStroke(Color.BLACK);
		r1.widthProperty().bind(pane.widthProperty().multiply(0.98));
		r1.heightProperty().bind(pane.heightProperty().multiply(0.98));
		r1.setArcWidth(20);
		r1.setArcHeight(20);
		pane.getChildren().addAll(r1);
		return pane;
	}
	
	public static StackPane loadDecor(int percent) {
		StackPane pane = new StackPane();
		Rectangle r1 = new Rectangle();
		r1.setFill(Color.LIGHTGRAY);
		r1.setStroke(Color.BLACK);
		r1.widthProperty().bind(pane.widthProperty().multiply(percent));
		r1.heightProperty().bind(pane.heightProperty().multiply(percent));
		r1.setArcWidth(20);
		r1.setArcHeight(20);
		pane.getChildren().addAll(r1);
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
			stops.add(new Stop(0.25f, Color.DARKGRAY));
			stops.add(new Stop(0.5f, Color.WHITE));
			stops.add(new Stop(0.75f, Color.DARKGRAY));
		}
		LinearGradient lg = new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, stops);
		return lg;
	}
}
