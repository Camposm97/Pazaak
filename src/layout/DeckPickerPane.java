package layout;

import event.StartGameHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import model.DeckPicker;
import util.FXUtil;

public class DeckPickerPane extends BorderPane {
	private DeckPicker deckPicker;
	
	public DeckPickerPane() {
		deckPicker = new DeckPicker();
		setTop(loadTopPane());
		setCenter(deckPicker.loadPane());
		setBottom(loadBottomPane());
		setPadding(FXUtil.DEFAULT_INSETS);
	}
	
	public DeckPicker getDeckPicker() {
		return deckPicker;
	}
	
	private ButtonBar loadBottomPane() {
		final int btnWidth = 256;
		final Font font = Font.font(16);
		Button btCont = new Button("Continue");
		btCont.setPrefWidth(btnWidth);
		btCont.setFont(font);
		btCont.setOnAction(new StartGameHandler(this));
		Button btBack = new Button("Go Back");
		btBack.setPrefWidth(btnWidth);
		btBack.setFont(font);
		btBack.setOnAction(e -> { getScene().setRoot(new MainMenu()); });
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
