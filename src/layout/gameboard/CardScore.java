package layout.gameboard;


import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.PazaakCard;

public class CardScore extends StackPane {
	private int totalScore;
	private Text t;
	private PlayField pf;
	private TurnIndicator ti;
	private ScoreBoard scoreBoard;
	private HandPane handPane;
	
	public CardScore(HandPane handPane) {
		this.totalScore = 0;
		this.pf = new PlayField();
		this.ti = new TurnIndicator(this);
		this.scoreBoard = new ScoreBoard();
		this.handPane = handPane;
		build();
	}
	
	public PlayField getPf() {
		return pf;
	}
	
	public TurnIndicator getTi() {
		return ti;
	}
	
	public ScoreBoard getScoreBoard() {
		return scoreBoard;
	}
	
	public HandPane getHandPane() {
		return handPane;
	}
	
	public void add(PazaakCard pc) {
		totalScore += pc.getInfo().getNum();
		t.setText(String.valueOf(totalScore));
		pf.add(pc);
	}
	
	private void build() {
		double arc = NamePane.HEIGHT;
		Font font = Font.font(NamePane.WIDTH * 0.05);
		t = new Text(String.valueOf(totalScore));
		t.setFill(Color.WHITE);
		t.setFont(font);
		Rectangle r = new Rectangle(NamePane.HEIGHT * 1.5, NamePane.HEIGHT);
		r.setArcWidth(arc);
		r.setArcHeight(arc);
		this.getChildren().addAll(r, t);
	}
}
