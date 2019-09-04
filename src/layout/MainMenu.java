package layout;

import app.App;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import util.FXUtil;
import util.ImgUtil;
import util.Web;

public class MainMenu extends BorderPane {
	public MainMenu() {
		Label lblTitle = new Label(App.TITLE);
		lblTitle.setPadding(FXUtil.DEFAULT_INSETS);
		lblTitle.setFont(Font.font(64));
		lblTitle.setGraphic(ImgUtil.loadImgV(ImgUtil.ICON_PAZAAK, 0.5));	
		setTop(new StackPane(lblTitle));
		setCenter(loadBoxOfBtns());
	}
	
	private VBox loadBoxOfBtns() {
		Button btStart = new Button("Start");
		btStart.setOnAction(e -> { getScene().setRoot(new SideDeckChooser()); });
		Button btHelp = new Button("How to Play");
		btHelp.setOnAction(e -> { Web.openThisRepo(); });
		Button btQuit = new Button("Quit");
		btQuit.setOnAction(e -> { Platform.exit(); });
		editBtns(btStart, btHelp, btQuit);
		VBox vBox = FXUtil.loadVBox(btStart, btHelp, btQuit);
		vBox.setAlignment(Pos.CENTER);
		return vBox;
	}
	
	private void editBtns(Button...btns) {
		for (Button bt : btns) {
			bt.prefWidthProperty().bind(widthProperty().multiply(0.25));
			bt.setFont(Font.font(16));
		}
	}
}
