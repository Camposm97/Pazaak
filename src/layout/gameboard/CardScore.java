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
	private TurnMark tm;
	private ScoreBoard sb;
	private HandPane handPane;
	
	public CardScore(HandPane handPane) {
		this.totalScore = 0;
		this.pf = new PlayField();
		this.tm = new TurnMark(this);
		this.sb = new ScoreBoard();
		this.handPane = handPane;
		build();
	}
	
	public int getTotalScore() {
		return totalScore;
	}
	
	public PlayField pf() {
		return pf;
	}
	
	public TurnMark tm() {
		return tm;
	}
	
	public ScoreBoard sb() {
		return sb;
	}
	
	public HandPane handPane() {
		return handPane;
	}
	
	public void add(PazaakCard pc) {
		if (pf.isFull()) {
			tm.setStand(true);
			tm.setFlag(false);
		} else {
			totalScore += pc.getInfo().getNum();
			t.setText(String.valueOf(totalScore));
			pf.add(pc);
		}
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
