package layout.game_table;


import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.PazaakCard;

public class CardScore extends StackPane {
	private int sum;
	private Text t; 
	
	public CardScore() {
		this.sum = 0;
		build();
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
	
	public void add(PazaakCard pc) {
		sum += pc.getInfo().getNum();
	}
}
