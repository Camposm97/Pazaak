package model;

public class CardMatrix {
	private Card[][] arr;
	private int nRow, nCol, rowSize, colSize;
	
	public CardMatrix(int rowSize, int colSize) {
		this.arr = new Card[rowSize][colSize];
		this.nRow = 0;
		this.nCol = 0;
		this.rowSize = rowSize;
		this.colSize = colSize;
	}

	public void add(Card c) {
		arr[nRow][nCol++] = c;
		if (nCol > colSize-1) {
			nRow++;
			nCol = 0;
		}
	}
	
	public PazaakCard[] getSelectedCards(int size) {
		int i = 0;
		PazaakCard[] chosenOnes = new PazaakCard[size];
		try {
			for (Card[] cards : arr)
				for (Card c : cards)
					if (((PazaakCard)(c)).isSelected())
						chosenOnes[i++] = (PazaakCard) c;
			if(i != size)
				return null;
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
		return chosenOnes;
	}
	
	public Card get(int row, int col) {
		return arr[row][col];
	}
	
	public int rowSize() {
		return nRow;
	}
	
	public int colSize() {
		return nCol;
	}
	
	public int rowLength() {
		return rowSize;
	}
	
	public int colLength() {
		return colSize;
	}
}
