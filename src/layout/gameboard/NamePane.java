package layout.gameboard;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.Align;

public class NamePane extends StackPane {
	public static final double WIDTH = 640.0;
	public static final double HEIGHT = WIDTH * 0.1;

	public NamePane(String name, Align a) {
		Font font = Font.font(WIDTH * 0.05);
		double[] arr;
		if (a.equals(Align.LEFT))
			arr = new double[] { HEIGHT, 0.0, WIDTH, 0.0, WIDTH - HEIGHT, HEIGHT, 0.0, HEIGHT };
		else
			arr = new double[] { 0.0, 0.0, WIDTH - HEIGHT, 0.0, WIDTH, HEIGHT, HEIGHT, HEIGHT };
		Polygon pg = new Polygon(arr);
		Text t1 = new Text(name);
		t1.setFill(Color.WHITE);
		t1.setFont(font);
		getChildren().addAll(pg, t1);
	}
}
