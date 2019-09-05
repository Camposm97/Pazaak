package layout.game_table;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class TurnIndicator extends Circle {
	private boolean flag;
	
	public TurnIndicator() {
		super(NamePane.HEIGHT / 2);
		setFill(Color.DIMGRAY);
		setStroke(Color.BLACK);
	}
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
		if (flag)
			setFill(Color.RED);
		else
			setFill(Color.DIMGRAY);
	}
}
