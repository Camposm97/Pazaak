package layout.gameboard;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import model.Scores;
import util.FXUtil;

public class ScoreBoard extends StackPane {
	private Scores record;
	
	public ScoreBoard() {
		super(FXUtil.loadDecor());
		super.setPadding(FXUtil.DEFAULT_INSETS);
		this.record = new Scores();
		VBox vBox = FXUtil.loadVBox(record.getScores());
		vBox.setAlignment(Pos.CENTER);
		vBox.setPadding(FXUtil.DEFAULT_INSETS);
		getChildren().add(vBox);
	}
}
