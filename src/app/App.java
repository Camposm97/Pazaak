package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import layout.MainMenu;
import util.ImgUtil;

public class App extends Application {
	public static final String TITLE = "Pazaak v1.0";
	private MainMenu root;
	
	@Override
	public void init() {
		root = new MainMenu();
	}
	
	@Override
	public void start(Stage stage) {
		Scene scene = new Scene(root);
		stage.getIcons().add(ImgUtil.loadImg(ImgUtil.ICON_PAZAAK));
		stage.setTitle(TITLE);
		stage.setWidth(1600);
		stage.setHeight(900);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
