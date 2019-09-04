package layout;

import app.App;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import util.FXUtil;
import util.ImgUtil;
import util.Web;

public class MainMenu extends BorderPane {
	public MainMenu() {
		ImageView iv = ImgUtil.loadImgV(ImgUtil.ICON_PAZAAK, 0.5);
		Label lblTitle = new Label(App.TITLE);
		lblTitle.setPadding(FXUtil.DEFAULT_INSETS);
		lblTitle.setFont(Font.font(64));
		lblTitle.setGraphic(iv);	
		setTop(new StackPane(lblTitle));
		setCenter(loadBtns());
	}
	
	private VBox loadBtns() {
		final Font font = Font.font(16);
		Button btStart = new Button("Start");
		btStart.setOnAction(e -> { getScene().setRoot(new SideDeckChooser()); });
		btStart.prefWidthProperty().bind(widthProperty().multiply(0.25));
		btStart.setFont(font);
		Button btHelp = new Button("How to Play");
		btHelp.setOnAction(e -> { Web.openThisRepo(); });
		btHelp.prefWidthProperty().bind(widthProperty().multiply(0.25));
		btHelp.setFont(font);
		Button btQuit = new Button("Quit");
		btQuit.setOnAction(e -> { Platform.exit(); });
		btQuit.prefWidthProperty().bind(widthProperty().multiply(0.25));
		btQuit.setFont(font);
		VBox vBox = FXUtil.loadVBox(btStart, btHelp, btQuit);
		vBox.setAlignment(Pos.CENTER);
		return vBox;
	}
}
