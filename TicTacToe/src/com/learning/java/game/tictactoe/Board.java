package com.learning.java.game.tictactoe;

public class Board {
	private static final int SIZE = 3;
	private char[][] board = null;

	public Board() {
		board = new char[SIZE][SIZE];
	}

	public Board(Board board) {
		this.board = new char[SIZE][SIZE];
		for (int i = 0; i < this.board.length; i++) {
			for (int j = 0; j < this.board[i].length; j++) {
				this.board[i][j] = board.get(i, j);
			}
		}
	}
	public Board(char[][] board) {
		this.board = new char[SIZE][SIZE];
		for (int i = 0; i < this.board.length; i++) {
			for (int j = 0; j < this.board[i].length; j++) {
				this.board[i][j] = board[i][j];
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("********************");
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				builder.append(board[i][j] + "\t");
			}
			builder.append("\n");
		}
		builder.append("********************");
		return builder.toString();
	}

	public char get(int i, int j) {
		if (i >= SIZE || j >= SIZE) {
			System.err.println("out of range index");
			return Character.MIN_VALUE;
		}
		return board[i][j];
	}

	public boolean isFull() {
		boolean retValue = false;
		if (checkVertical()) {
			return true;
		}
		if (checkHorizontal()) {
			return true;
		}
		if (checkDiagnoal()) {
			return true;
		}

		return retValue;
	}

	private boolean checkVertical() {
		boolean retValue = true;
		for (int verticalIndex = 0; verticalIndex < SIZE; verticalIndex++) {
			for (int i = 0; i < SIZE; i++) {
				if (board[verticalIndex][0] != board[verticalIndex][i]) {
					return false;
				}
			}
			if (retValue) {
				break;
			}
		}
		return retValue;
	}

	private boolean checkHorizontal() {
		boolean retValue = true;
		for (int horizontalIndex = 0; horizontalIndex < SIZE; horizontalIndex++) {
			for (int i = 0; i < SIZE; i++) {
				if (board[horizontalIndex][0] != board[i][horizontalIndex]) {
					return false;
				}
			}
			if (retValue) {
				break;
			}
		}
		return retValue;
	}

	private boolean checkDiagnoal() {
		int x = 0, y = 0;
		boolean retValue = true;
		for (int i = 0, j = 0; i < SIZE; i++, j++) {
			if (board[x][y] != board[i][j]) {
				return false;
			}
		}
		if (retValue) {
			return retValue;
		}
		x = SIZE;
		y = SIZE;
		for (int i = 3, j = 3; i > 0; i--, j--) {
			if (board[x][y] != board[i][j]) {
				return false;
			}
		}

		return retValue;
	}
}