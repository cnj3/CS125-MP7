//
//This will be the main program for running the game in the terminal.
//

import java.util.Random;

public class tictac	{
	
	private static void main()	{
		
		//initialize and assign x and o to player.
		
		System.out.println("Please enter your name, player one.");
		String name1 = TextIO.getln();
		Player player1 = new Player(name1);
		
		System.out.println("Please enter your name, player two.");
		String name2 = TextIO.getln();
		Player player2 = new Player(name2);
		
		Random rand = new Random();
		
		int n = rand.nextInt(10) + 1;
		
		if (n < 5)	{
			player1.x = true;
			player2.o = true;
		} else {
			player1.o = true;
			player2.x = true;
		}
		
		//initialize board
		
		Board board = new Board();
		
		//accept inputs and print the current board, check if win or tie each turn
		
		if (board.winner(board.playerboard) == null || board.tie(board.playerboard) == false)	{
			
			String[][] printboard = board.print(board);
			
			for (int i = 0; i < printboard.length; i++)	{
				for (int j = 0; j < printboard.length ; j++)	{
					System.out.print(printboard[i][j]);
				}
				
			}
			
		} else if (board.winner(board.playerboard) != null) {
			System.out.println(board.winner(board.playerboard) + " has won!");
			board.winner(board.playerboard).addScore();
		} else if (board.tie(board.playerboard) == false) { 
			System.out.println("Tie!");
		} else {
			System.out.println("Oops. Something happened that shouldn't have happened.");
		}
		
		//if win or tie, end the game and declare the winner, or if there was a tie.
		
		
		//prompt to restart program.
		
		System.out.println(player1.getName() + ": " + player1.getScore() 
		+ "    " + player2.getName() + ": " + player2.getScore());
		System.out.println("Play Again? Y/N");
		char play = TextIO.getChar();
		if (play == 'y' || play == 'Y')	{
			
		}
		
		
	}
	
}
