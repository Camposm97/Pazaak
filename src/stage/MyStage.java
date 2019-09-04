package stage;

import app.App;
import javafx.scene.Scene;
import javafx.stage.Stage;
import layout.MainMenu;
import util.ImgUtil;

public class MyStage extends Stage {
	private static final int STAGE_WIDTH = 1600;
	private static final int STAGE_HEIGHT = 900;
	
	public MyStage() {
		getIcons().add(ImgUtil.loadImg(ImgUtil.ICON_PAZAAK));
		setTitle(App.TITLE);
		setWidth(STAGE_WIDTH);
		setHeight(STAGE_HEIGHT);
		setResizable(false);
		setScene(new Scene(new MainMenu()));
	}
}
