package model;

import java.util.ArrayList;

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
	
	public ArrayList<Card> getPickedCards() {
		ArrayList<Card> list = new ArrayList<>();
		for (Card[] cards : arr) {
			for (Card c : cards) {
				
			}
		}
		return list;
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
