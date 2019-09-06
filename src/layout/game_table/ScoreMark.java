package layout.game_table;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ScoreMark extends StackPane {
	private static final int RADIUS = 25;
	private Circle c1, c2;
	private boolean flipped;
	
	public ScoreMark() {
		c1 = new Circle(RADIUS * 1.5);
		c1.setStrokeWidth(2.0);
		c1.setStroke(Color.BLACK);
		c1.setFill(Color.GRAY);
		c2 = new Circle(RADIUS);
		c2.setStrokeWidth(8.0);
		c2.setStroke(Color.BLACK);
		c2.setFill(Color.GRAY);
		getChildren().addAll(c1, c2);
	}
	
	public void flip() {
		flipped = true;
		c1.setFill(Color.RED);
		c2.setFill(Color.RED);
	}
	
	public boolean isFlipped() {
		return flipped;
	}
}
