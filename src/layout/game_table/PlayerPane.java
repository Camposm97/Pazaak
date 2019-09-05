package layout.game_table;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import model.Align;

public class PlayerPane extends HBox {
	private TurnIndicator ti;
	private NamePane namePane;
	private CardScore cs;
	
	public PlayerPane(String name, Align a) {
		super(10);
		ti = new TurnIndicator();
		namePane = new NamePane(name);
		cs = new CardScore();
		setAlignment(Pos.CENTER);
		if (a.equals(Align.LEFT))
			getChildren().addAll(ti, namePane.build(a), cs);
		else
			getChildren().addAll(cs, namePane.build(a), ti);
	}
}
