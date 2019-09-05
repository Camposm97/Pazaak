package stage;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import layout.MainMenu;
import util.FXUtil;

public class PauseStage extends Stage {
	private static final int FONT_SIZE = 16;
	private static final int BT_WIDTH = 128;
	
	public PauseStage(Window owner) {
		super(StageStyle.UNDECORATED);
		Label lbl = new Label("Pause Menu");
		lbl.setFont(Font.font(FONT_SIZE * 2));
		Button btRs = new Button("Resume");
		btRs.setPrefWidth(BT_WIDTH);
		btRs.setFont(Font.font(FONT_SIZE));
		btRs.setOnAction(g -> {
			this.close();
		});
		Button btExit = new Button("Forfeit");
		btExit.setPrefWidth(BT_WIDTH);
		btExit.setFont(Font.font(FONT_SIZE));
		btExit.setOnAction(h -> {
			this.close();
			this.getOwner().getScene().setOnKeyPressed(null);
			this.getOwner().getScene().setRoot(new MainMenu());
		});
		VBox vBox = FXUtil.loadVBox(lbl, btRs, btExit);
		vBox.setAlignment(Pos.CENTER);
		vBox.setPadding(FXUtil.DEFAULT_INSETS);
		Scene scene = new Scene(vBox);
		scene.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ESCAPE)
				btRs.fire();
		});
		this.setScene(scene);
		this.initModality(Modality.WINDOW_MODAL);
		this.initOwner(owner);
		this.showAndWait();
	}
}
