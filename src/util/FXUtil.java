package util;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import model.CardType;

public class FXUtil {
	public static final Insets DEFAULT_INSETS = new Insets(10);
	public static final int BTN_WIDTH = 128;
	
	public static BorderPane loadRoot() {
		BorderPane root = new BorderPane();
		
		Image image = new Image("pazaak.png");
		ImageView iv = new ImageView(image);
		iv.setFitWidth(image.getWidth() / 2);
		iv.setFitHeight(image.getHeight() / 2);
		
		Label lblTitle = new Label("Pazaak v1.0");
		lblTitle.setFont(Font.font(64));
		lblTitle.setGraphic(iv);
		
		StackPane stackPane = new StackPane(lblTitle);
		stackPane.setPadding(new Insets(30, 10, 10, 10));
		
		Button btPlay = new Button("Play");
		btPlay.setOnAction(e -> {
			loadSideDeck(root.getScene());
		});
		btPlay.prefWidthProperty().bind(root.widthProperty().divide(5));
		btPlay.setFont(Font.font(16));
		
		Button btQuit = new Button("Quit");
		btQuit.setOnAction(e -> {
			Platform.exit();
		});
		btQuit.prefWidthProperty().bind(root.widthProperty().divide(5));
		btQuit.setFont(Font.font(16));
		
		VBox vBox = new VBox(10);
		vBox.setAlignment(Pos.CENTER);
		vBox.setPadding(DEFAULT_INSETS);
		vBox.getChildren().addAll(btPlay, btQuit);
		
		root.setTop(stackPane);
		root.setCenter(vBox);
		return root;
	}
	
	public static void loadSideDeck(Scene scene) {
		Rectangle r1 = new Rectangle();
		r1.setStroke(Color.GRAY);
		r1.setFill(Color.DIMGRAY);
		r1.setOpacity(0.1);
		r1.widthProperty().bind(scene.widthProperty());
		r1.heightProperty().bind(scene.heightProperty());
		
		StackPane root = new StackPane(r1);
		scene.setRoot(root);
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
