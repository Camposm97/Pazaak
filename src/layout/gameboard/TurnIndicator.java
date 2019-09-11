package layout.gameboard;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.PazaakCard;

public class TurnIndicator extends Circle {
	private CardScore cs;
	private boolean stand;
	private boolean aiMode;
	private boolean flag;
	
	public TurnIndicator(CardScore cs) {
		super(NamePane.HEIGHT / 2);
		super.setFill(Color.DIMGRAY);
		super.setStroke(Color.BLACK);
		this.cs = cs;
	}
	
	public void setStand(boolean stand) {
		this.stand = stand;
	}
	
	public void setAIMode(boolean aiMode) {
		this.aiMode = aiMode;
	}
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
		if (flag) {
			setFill(Color.RED);
			cs.add(new PazaakCard());
			if (aiMode) {
				/*
				 * Take the total card score and determine to end turn, stand, or
				 * pick a card to +/- the total card score.  
				 */
			}
		} else {
			setFill(Color.DIMGRAY);
			cs.getHandPane().getOpponent().setTurn(true);
		}
	}
}
