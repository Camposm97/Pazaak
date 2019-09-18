package layout.gameboard;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import model.Card;

public class PlayField extends GridPane {
	private static final int COL_LIMIT = 3, ROW_LIMIT = 3;
	private static final int SIZE = COL_LIMIT * ROW_LIMIT * 2;
	private int col, row;

	public PlayField() {
		super.setAlignment(Pos.CENTER);
		super.setHgap(10);
		super.setVgap(10);
		displayPlaceHolders();
	}
	
	public boolean isFull() {
		return (getChildren().size() >= SIZE);
	}
	
	public void clean() {
		super.getChildren().clear();
		displayPlaceHolders();
	}

	public void add(Node node) {
		add(node, col++, row);
		if (col > COL_LIMIT - 1) {
			col = 0;
			row++;
			if (row > ROW_LIMIT - 1)
				row = 0;
		}
	}
	
	private void displayPlaceHolders() {
		for (int i = 0; i < COL_LIMIT; i++) {
			for (int j = 0; j < ROW_LIMIT; j++) {
				Card c = new Card();
				add(c, i, j);
			}
		}
	}
}
