package layout.gameboard;


import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.PazaakCard;

public class CardScore extends StackPane {
	private int sum;
	private Text t;
	private PlayField playField;
	
	public CardScore() {
		this.sum = 0;
		this.playField = new PlayField();
		build();
	}
	
	public PlayField getPlayField() {
		return playField;
	}
	
	public void add(PazaakCard pc) {
		sum += pc.getInfo().getNum();
		t.setText(String.valueOf(sum));
		playField.add(pc);
	}
	
	private void build() {
		double arc = NamePane.HEIGHT;
		Font font = Font.font(NamePane.WIDTH * 0.05);
		t = new Text(String.valueOf(sum));
		t.setFill(Color.WHITE);
		t.setFont(font);
		Rectangle r = new Rectangle(NamePane.HEIGHT * 1.5, NamePane.HEIGHT);
		r.setArcWidth(arc);
		r.setArcHeight(arc);
		this.getChildren().addAll(r, t);
	}
}
