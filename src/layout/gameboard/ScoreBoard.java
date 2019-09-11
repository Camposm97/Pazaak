package layout.gameboard;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import model.Scores;
import util.FXUtil;

public class ScoreBoard extends StackPane {
	private Scores scores;
	
	public ScoreBoard() {
		super(FXUtil.loadDecor());
		super.setPadding(FXUtil.DEFAULT_INSETS);
		this.scores = new Scores();
		VBox vBox = FXUtil.loadVBox(scores.getScores());
		vBox.setAlignment(Pos.CENTER);
		vBox.setPadding(FXUtil.DEFAULT_INSETS);
		getChildren().add(vBox);
	}
	
	
	public Scores getScores() {
		return scores;
	}
}
