package layout.gameboard;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.PazaakAI;
import model.PazaakCard;
import util.WinnerUtil;

public class TurnMark extends Circle {
	private CardScore cs;
	private boolean stand;
	private boolean aiMode;
	private boolean flag;
	
	public TurnMark(CardScore cs) {
		super(NamePane.HEIGHT / 2);
		super.setFill(Color.DIMGRAY);
		super.setStroke(Color.BLACK);
		this.cs = cs;
	}
	
	public CardScore cs() {
		return cs;
	}
	
	public boolean isStand() {
		return stand;
	}
	
	public void setStand(boolean stand) {
		this.stand = stand;
		setFlag(false);
	}
	
	public boolean isAIMode() {
		return aiMode;
	}
	
	public void setAIMode(boolean aiMode) {
		this.aiMode = aiMode;
	}
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
		if (stand && cs.handPane().opp().getHandPane().cs().tm().isStand()) {
			System.out.println("Both players are standing");
			WinnerUtil.chooseWinner(cs);
			return;
		}
		if (!stand) {
			if (flag) {
				setFill(Color.RED);
				cs.add(new PazaakCard()); // Draw Green Card onto Playing Field
				if (aiMode) {// Let Computer make the next move
					PazaakAI ai = new PazaakAI(this);
					ai.computeMove();
				}
			} else {
				setFill(Color.DIMGRAY);
				cs.handPane().opp().setTurn(true);
			}
		} else {
			setFill(Color.DIMGRAY);
			cs.handPane().opp().setTurn(true);
		}
		
	}
}
