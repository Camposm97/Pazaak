package model;

import layout.game_table.ScoreMark;

public class ScoreRecorder {
	private static final int SIZE = 3;
	private ScoreMark[] scores;
	private int nElems;
	
	public ScoreRecorder() {
		scores = new ScoreMark[SIZE];
		for (int i = 0; i < scores.length; i++) {
			scores[i] = new ScoreMark();
		}
		nElems = 0;
	}
	
	public ScoreMark[] getScores() {
		return scores;
	}
	
	public void setAWin() {
		scores[nElems++].flip();
	}
	
	public boolean wonAll() {
		for (ScoreMark s : scores) {
			if (!s.isFlipped())
				return false;
		}
		return true;
	}
}
