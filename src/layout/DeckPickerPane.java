package layout;

import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.StageStyle;
import model.DeckPicker;
import model.PazaakCard;
import util.FXUtil;

public class DeckPickerPane extends BorderPane {
	private DeckPicker deckPicker;
	
	public DeckPickerPane() {
		deckPicker = new DeckPicker();
		setTop(loadTopPane());
		setCenter(deckPicker.loadGridPane());
		setBottom(loadBottomPane());
		setPadding(FXUtil.DEFAULT_INSETS);
	}
	
	private ButtonBar loadBottomPane() {
		Button btCont = new Button("Continue");
		btCont.setPrefWidth(256);
		btCont.setFont(Font.font(16));
		btCont.setOnAction(e -> {
			PazaakCard[] deck = deckPicker.getPickedCards();
			if (deck != null) {
				System.out.println("Starting Game...");
			} else {
				Alert a = new Alert(AlertType.ERROR);
				
				a.setHeaderText("Your deck is not complete!");
				a.setContentText("You have to pick " + DeckPicker.DECK_SIZE + " cards");
				a.initStyle(StageStyle.UNDECORATED);
				a.initOwner(getScene().getWindow());
				a.showAndWait();
			}
		});
		Button btBack = new Button("Go Back");
		btBack.setPrefWidth(256);
		btBack.setFont(Font.font(16));
		btBack.setOnAction(e -> {
			getScene().setRoot(new MainMenu());
		});
		ButtonBar btBar = new ButtonBar();
		btBar.getButtons().addAll(btBack, btCont);
		return btBar;
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
		topPane.getChildren().addAll(FXUtil.loadBackground(), hBox);
		return topPane;
	}
}
