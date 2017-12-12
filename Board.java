//
// creates a tic tac toe board.

public class Board {
	
	/**
	 * the board height and width is 3.
	 */
	public int dimention = 3;
	
	/**
	 * player array that is the board.
	 */
	public Player[][] playerboard;
	
	/**
	 * constructor for tictac.
	 */
	public Board()	{
		
		playerboard = new Player[dimention][dimention];
	}
	
	public boolean setBoardAt(final Player player, final int setX, final int setY)	{
		
		if (playerboard[setX][setY] == null)	{
			playerboard[setX][setY] = player;
			return true;
		}
		return false;
		
		}
	
	public Player winner(final Player[][] board) {
		
		//horizontal cases
		if(board[0][0] == board[1][0] && board[0][0] == board[2][0] && board[0][0] != null)	{
			return board[0][0];
		}
		if(board[0][1] == board[1][1] && board[0][1] == board[2][1] && board[0][1] != null)	{
			return board[0][1];
		}
		if(board[0][2] == board[1][2] && board[0][2] == board[2][2] && board[0][2] != null)	{
			return board[0][2];
		}
		//vertical cases
		if(board[0][0] == board[0][1] && board[0][0] == board[0][2] && board[0][0] != null)	{
			return board[0][0];
		}
		if(board[1][0] == board[1][1] && board[1][0] == board[1][2] && board[1][0] != null)	{
			return board[1][0];
		}
		if(board[2][0] == board[2][1] && board[2][0] == board[2][2] && board[2][0] != null)	{
			return board[2][0];
		}
		//diagonal cases
		if(board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != null)	{
			return board[0][0];
		}
		if(board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] != null)	{
			return board[0][2];
		}
		return null;
	}
	
	
	public boolean tie(final Player[][] board)	{
		if(winner(board) == null)	{
			for (int i = 0; i < dimention; i++) {
				for (int j = 0; j < dimention; j++) {
					if(board[i][j] == null)	{
						return false;
					}
				}
			} 

		}
		return true;
	}
	
	public String[][] print(final Board board)	{
		
		String[][] printboard = new String[6][6];
		for (int i = 0; i < dimention * 2; i++)	{
			for (int j = 0; j < dimention * 2; j++) {
				if (j % 2 == 1) {
					printboard[i][j] = "|";
					
				} else {
					
					if (i % 2 == 1) {
						printboard[i][j] = "------------------";
						i++;
						
					} else {
						
						if (board.playerboard[i][j] == null) {
							printboard[i][j] = "   ";
						}
						if (board.playerboard[i][j].x = true)	{
							printboard[i][j] = " X ";							
						}
						if (board.playerboard[i][j].o = true)	{
							printboard[i][j] = " O ";
						}
					}
				}
			}
		}
		return printboard;
	}
}
