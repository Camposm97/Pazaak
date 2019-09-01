package model;

public class CardInfo {
	private int num;
	private CardType type;
	
	public CardInfo() {
		this.num = (int) (Math.random() * 10) + 1;
		type = CardType.Main;
	}
	
	public CardInfo(int num) {
		this.num = num;
		if (num > 0) {
			type = CardType.Plus;
		} else {
			type = CardType.Minus;
		}
	}
	
	public int getNum() {
		return num;
	}
	
	public CardType getType() {
		return type;
	}
	
	@Override
	public String toString() {
		String s = String.valueOf(num);
		if (type.equals(CardType.Main)) {
			return s;
		} else if (num > 0) {
			s = "+" + num;
			return s;
		}
		return s;
	}
}
