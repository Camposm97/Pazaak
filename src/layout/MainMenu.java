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

public class MainMenu extends BorderPane {
	public MainMenu() {
		ImageView iv = ImgUtil.loadImgV("images/pazaak.png", 0.5);
		Label lblTitle = new Label(App.TITLE);
		lblTitle.setPadding(FXUtil.DEFAULT_INSETS);
		lblTitle.setFont(Font.font(64));
		lblTitle.setGraphic(iv);
		
		Button btStart = new Button("Start");
		btStart.setOnAction(e -> { new SideDeckChooser(getScene()); });
		btStart.prefWidthProperty().bind(widthProperty().multiply(0.25));
		btStart.setFont(Font.font(16));
		
		Button btHelp = new Button("How to Play");
		btHelp.prefWidthProperty().bind(widthProperty().multiply(0.25));
		btHelp.setFont(Font.font(16));
		
		Button btQuit = new Button("Quit");
		btQuit.setOnAction(e -> { Platform.exit(); });
		btQuit.prefWidthProperty().bind(widthProperty().multiply(0.25));
		btQuit.setFont(Font.font(16));
		
		VBox vBox = FXUtil.loadVBox(btStart, btHelp, btQuit);
		vBox.setAlignment(Pos.CENTER);
		vBox.setPadding(FXUtil.DEFAULT_INSETS);		
		super.setTop(new StackPane(lblTitle));
		super.setCenter(vBox);
	}
}
