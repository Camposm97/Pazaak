package model;

public class GameMaster {
	private Player p1, p2;
	
	public GameMaster(Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public void startGame() {
		p1.getHandPane().getCs().getTi().setFlag(true); // Player One goes first
//		p2.hideCards(); // Hide Player Two's cards from Player One
		p1.setOpponent(p2);
		p2.setOpponent(p1);
	}
	
	public Player getP1() {
		return p1;
	}
	
	public Player getP2() {
		return p2;
	}
}
