package model;

import layout.gameboard.ScoreMark;

public class Scores {
	private static final int SIZE = 3;
	private ScoreMark[] arr;
	private int nElems;
	
	public Scores() {
		arr = new ScoreMark[SIZE];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new ScoreMark();
		}
		nElems = 0;
	}
	
	public ScoreMark[] getScores() {
		return arr;
	}
	
	public void setAWin() {
		arr[nElems++].flip();
	}
	
	public boolean wonAll() {
		for (ScoreMark s : arr) {
			if (!s.isFlipped())
				return false;
		}
		return true;
	}
}
