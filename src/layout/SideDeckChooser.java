package layout;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import util.FXUtil;

public class SideDeckChooser extends StackPane {
	public SideDeckChooser(Scene scene) {
		Rectangle r1 = new Rectangle();
		r1.setFill(Color.GRAY);
		r1.widthProperty().bind(scene.widthProperty());
		r1.heightProperty().bind(scene.heightProperty());
		
		Rectangle r2 = new Rectangle();
		r2.setFill(Color.LIGHTGRAY);
		r2.setStroke(Color.BLACK);
		r2.widthProperty().bind(r1.widthProperty().multiply(0.98));
		r2.heightProperty().bind(r1.heightProperty().multiply(0.98));
		r2.setArcWidth(20);
		r2.setArcHeight(20);
		
//		Rectangle r3 = new Rectangle();
//		r3.setFill(Color.GRAY);
//		r3.setStroke(Color.BLACK);
//		r3.widthProperty().bind(r2.widthProperty().multiply(0.95));
//		r3.heightProperty().bind(r2.heightProperty().multiply(0.95));
//		r3.setArcWidth(20);
//		r3.setArcHeight(20);
		final String tfStyle = "-fx-text-fill: white; -fx-background-color: black; -fx-border-color: gray;";
		TextField tf1 = new TextField("Available Cards");
		tf1.setStyle(tfStyle);
		tf1.setEditable(false);
		tf1.setAlignment(Pos.CENTER);
		tf1.setFont(Font.font(24));
		TextField tf2 = new TextField("Choose Sidedeck");
		tf2.setStyle(tfStyle);
		tf2.setEditable(false);
		tf2.setAlignment(Pos.CENTER);
		tf2.setFont(Font.font(24));
		TextField tf3 = new TextField("Chosen Cards");
		tf3.setStyle(tfStyle);
		tf3.setEditable(false);
		tf3.setAlignment(Pos.CENTER);
		tf3.setFont(Font.font(24));
		
		HBox hBox = new HBox(100);
		hBox.setAlignment(Pos.CENTER);
		hBox.setPadding(FXUtil.DEFAULT_INSETS);
		hBox.getChildren().addAll(tf1, tf2);
		
		GridPane chosenCards = new GridPane();
		chosenCards.setAlignment(Pos.CENTER);
		chosenCards.setHgap(10);
		chosenCards.setVgap(10);
		
		VBox vBox = new VBox(10);
		vBox.setAlignment(Pos.CENTER);
		vBox.setPadding(FXUtil.DEFAULT_INSETS);
		vBox.getChildren().add(tf3);
		
		Separator s1 = new Separator();
		s1.setOrientation(Orientation.VERTICAL);
		
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.TOP_CENTER);
		gridPane.setPadding(new Insets(80, 120, 80, 120));
		gridPane.setHgap(20);
		gridPane.setVgap(10);
		gridPane.setGridLinesVisible(true);
		FXUtil.displayCards(gridPane);
		gridPane.add(hBox, 0, 0, 6, 1);
//		gridPane.add(s1, 7, 0, 1, 50);
		gridPane.add(vBox, 8, 0);		
		getChildren().addAll(r1, r2, gridPane);
		scene.setRoot(this);
	}
}
