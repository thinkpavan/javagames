package com.learning.java.game.tictactoe;

public class Board {
	private static final int SIZE = 3;
	private char[][] board = null;

	public Board() {
		board = new char[SIZE][SIZE];
		char ch = '-';
		for (int i = 0; i < this.board.length; i++) {
			for (int j = 0; j < this.board[i].length; j++) {
				this.board[i][j] = ch;
			}
		}
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
		builder.append("********************\n");
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
		String board = this.toString();

		if (board.contains("-")) {
			return false;
		} else {
			return true;
		}
	}

	public void move(int x, int y, char piece){
		board[x][y] = piece;
	}
	

	public GameStatus checkVertical() {
		GameStatus retValue = GameStatus.IN_PROGRESS;
		
		boolean flag = true;
		for (int verticalIndex = 0; verticalIndex < SIZE; verticalIndex++) {
			flag = true;
			for (int i = 0; i < SIZE; i++) {
				if (board[0][verticalIndex] != board[i][verticalIndex] || board[i][verticalIndex] == '-') {
					flag = false;
					break;
				}
			}
			if (flag) {
				retValue = whoWon(board[0][verticalIndex]);
				break;
			}
		}
		return retValue;
	}

	public GameStatus checkHorizontal() {
		GameStatus retValue = GameStatus.IN_PROGRESS;
		boolean flag = true;
		for (int horizontalIndex = 0; horizontalIndex < SIZE; horizontalIndex++) {
			flag = true;
			
			for (int i = 0; i < SIZE; i++) {
				if (board[horizontalIndex][0] != board[horizontalIndex][i] || board[horizontalIndex][i] == '-') {
					flag= false;
					break;
				}
			}
			if (flag) {
				retValue = whoWon(board[horizontalIndex][0]);
				break;
			}
		}
		return retValue;
	}

	public GameStatus checkDiagnoal() {
		GameStatus retValue = GameStatus.IN_PROGRESS;
		int x = 0, y = 0;
		boolean flag = true;
		for (int i = 0, j = 0; i < SIZE; i++, j++) {
			if (board[x][y] != board[i][j] ||  board[x][y] == '-') {
				flag =  false;
			}
		}
		if (flag) {
			return whoWon(board[0][0]);
			
		}
		x = SIZE-1;
		y = SIZE-1;
		for (int i = 2, j = 2; i >= 0; i--, j--) {
			if (board[x][y] != board[i][j]|| board[x][y]== '-') {
				flag =  false;
			}
		}

		if (flag) {
			return whoWon(board[3][3]);
		}
		return retValue;
	}
	
	private GameStatus whoWon(char ch){
		GameStatus retValue = null;
		if ( ch == 'X'){
			retValue = GameStatus.X_WON;
		}else{
			retValue = GameStatus.O_WON;
		}
		return retValue;
	}
}
