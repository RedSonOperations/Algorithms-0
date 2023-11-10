import java.util.*;
import java.util.Arrays;

public class TicTacToe {

	public static void main(String[] args) {
		boolean end = false;
		double turnCounter = 0;
		char playerTurn;
		char yOrN;
		int[] rowColArr=new int[2];
		char gameOver;
		char playAgain;
		char selection;
		//initialize new grid, 4x4 array
		char[][] scores = {{' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' '}};
		Scanner input = new Scanner(System.in);
		
		greeting();
		selection=chooseACharacter();
		
		while(end==false) {
			
			
			if(selection=='X') {
				if(turnCounter%2==0.0) {
					playerTurn='X';
				}
				else {
					playerTurn='O';
				}
			}
			else {
				if(turnCounter%2==0.0) {
					playerTurn='O';
				}
				else {
					playerTurn='X';
				}
			}
			
			gameBoard(playerTurn, scores, turnCounter);
			
			rowColArr=turn(playerTurn);
			
			//did the grid update? if yes, turnCounter++
			yOrN=gridUpdate(scores, playerTurn, rowColArr);
			if(yOrN=='y') {
				turnCounter++;
			}
			
			gameOver=gameOverChecker(scores);
			//if game is over, offer another playing round. If accepted, reinitialize vars and end=false. If not accepted, end game entirely
			if(gameOver=='w') {
				gameBoard(playerTurn, scores, turnCounter);
				end=true;
				System.out.println("Would you like to play again? (y/n): ");
				playAgain=input.next().charAt(0);
				if(playAgain=='y') {
					end=false;
					turnCounter = 0;
					playerTurn='a';
					yOrN='a';
					rowColArr=new int[2];
					gameOver='a';
					selection='a';
					//reinitialize grid, 4x4 array
					scores =  new char[][]{{' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' '}};
					greeting();
					selection=chooseACharacter();
				}
				else {
					System.out.println("Thanks for playing!");
				}
				
				
			}
		}
				
		
		
	}
	
	public static void greeting() {
		System.out.println("======================================");
		System.out.println("|                                    |");
		System.out.println("|       TIC-TAC-TOE SHOWDOWN!        |");
		System.out.println("|                                    |");
		System.out.println("|      ████╗░░██╗░██████╗░██╗░░██╗    |");
		System.out.println("|      ██╔══██╗██║██╔════╝░██║░░██║    |");
		System.out.println("|      ███████║██║██║░░██╗░███████║    |");
		System.out.println("|      ██╔══██║██║██║░░╚██╗██╔══██║    |");
		System.out.println("|      ██║░░██║██║╚██████╔╝██║░░██║    |");
		System.out.println("|      ╚═╝░░╚═╝╚═╝░╚═════╝░╚═╝░░╚═╝    |");
		System.out.println("|                                     |");
		System.out.println("|       Author: Alec Kain            |");
		System.out.println("======================================\n");

	}
	
	public static char chooseACharacter() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("====================================");
		System.out.println("|                                  |");
		System.out.println("|     CHOOSE YOUR CHARACTER!       |");
		System.out.println("|                                  |");
		System.out.println("|          ░░░░░░░░░░░░░           |");
		System.out.println("|        ░░░░░░░░░░░░░░░░░░       |");
		System.out.println("|      ░░░░░░░░░░░░░░░░░░░░░░░     |");
		System.out.println("|    ░░░░░░░░░░░░░░░░░░░░░░░░░░   |");
		System.out.println("|      ░░░░░░░░░░░░░░░░░░░░░░░     |");
		System.out.println("|        ░░░░░░░░░░░░░░░░░░       |");
		System.out.println("|          ░░░░░░░░░░░░░           |");
		System.out.println("|                                  |");
		System.out.println("|      Choose:    (X)  or  (O)      |");
		System.out.println("|                                  |");
		System.out.println("====================================");
		
		char selection=input.next().charAt(0);
		
		return selection;
	}
	
	public static void gameBoard(char playerTurn, char[][] scores, double turnCounter) {
		
		
		for(int i = 0; i<scores.length; i++) {

			System.out.println("-----------------");
			
			for(int j = 0; j<scores.length; j++) {
				
				System.out.printf("| %c ", scores[i][j]);
				
			}
			
			System.out.println("|");
		}

		System.out.println("-----------------");
		
		
	}
	
	public static char gridUpdate(char[][] scores, char playerTurn, int rowColArr[]) {
		int row = rowColArr[0];
		int col = rowColArr[1];
		
		if(scores[row][col] != ' ') {
			System.out.println("This cell is already filled! Place your marker elsewhere.");
			
			return 'n';
		}
		else {
			scores[row][col]=playerTurn;
			return 'y';
		}

	}
	
	public static int[] turn(char playerTurn) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("\nEnter a row [0, 1, 2, 3] for player " + playerTurn + ": ");
		int row = input.nextInt();
		
		System.out.println("\nEnter a column [0, 1, 2, 3] for player " + playerTurn + ": ");
		int col = input.nextInt();
		
		int[] rowColArr = new int[2];
		
		rowColArr[0]=row;
		rowColArr[1]=col;
				
		return rowColArr;
		
	}
	
	public static char gameOverChecker(char [][] scores) {
		
		if(scores[0][0]=='X' && scores[0][1]=='X' && scores[0][2]=='X' && scores[0][3]=='X') {
			System.out.println("X wins!");
			return 'w';
		}
		else if(scores[1][0]=='X' && scores[1][1]=='X' && scores[1][2]=='X' && scores[1][3]=='X') {
			System.out.println("X wins!");
			return 'w';
		}
		else if(scores[2][0]=='X' && scores[2][1]=='X' && scores[2][2]=='X' && scores[2][3]=='X') {
			System.out.println("X wins!");
			return 'w';
		}
		else if(scores[3][0]=='X' && scores[3][1]=='X' && scores[3][2]=='X' && scores[3][3]=='X') {
			System.out.println("X wins!");
			return 'w';
		}
		else if(scores[0][0]=='X' && scores[1][0]=='X' && scores[2][0]=='X' && scores[3][0]=='X') {
			System.out.println("X wins!");
			return 'w';
		}
		else if(scores[0][1]=='X' && scores[1][1]=='X' && scores[2][1]=='X' && scores[3][3]=='X') {
			System.out.println("X wins!");
			return 'w';
		}
		else if(scores[0][2]=='X' && scores[1][2]=='X' && scores[2][2]=='X' && scores[3][2]=='X') {
			System.out.println("X wins!");
			return 'w';
		}
		else if(scores[0][3]=='X' && scores[1][3]=='X' && scores[2][3]=='X' && scores[3][3]=='X') {
			System.out.println("X wins!");
			return 'w';
		}
		else if(scores[0][0]=='O' && scores[0][1]=='O' && scores[0][2]=='O' && scores[0][3]=='O') {
			System.out.println("O wins!");
			return 'w';
		}
		else if(scores[1][0]=='O' && scores[1][1]=='O' && scores[1][2]=='O' && scores[1][3]=='O') {
			System.out.println("O wins!");
			return 'w';
		}
		else if(scores[2][0]=='O' && scores[2][1]=='O' && scores[2][2]=='O' && scores[2][3]=='O') {
			System.out.println("O wins!");
			return 'w';
		}
		else if(scores[3][0]=='O' && scores[3][1]=='O' && scores[3][2]=='O' && scores[3][3]=='O') {
			System.out.println("O wins!");
			return 'w';
		}
		else if(scores[0][0]=='O' && scores[1][0]=='O' && scores[2][0]=='O' && scores[3][0]=='O') {
			System.out.println("O wins!");
			return 'w';
		}
		else if(scores[0][1]=='O' && scores[1][1]=='O' && scores[2][1]=='O' && scores[3][1]=='O') {
			System.out.println("O wins!");
			return 'w';
		}
		else if(scores[0][2]=='O' && scores[1][2]=='O' && scores[2][2]=='O' && scores[3][2]=='O') {
			System.out.println("O wins!");
			return 'w';
		}
		else if(scores[0][3]=='O' && scores[1][3]=='O' && scores[2][3]=='O' && scores[3][3]=='O') {
			System.out.println("O wins!");
			return 'w';
		}
		else if(scores[0][0]=='X' && scores[1][1]=='X' && scores[2][2]=='X' && scores[3][3]=='X') {
			System.out.println("X wins!");
			return 'w';
		}
		else if(scores[0][0]=='O' && scores[1][1]=='O' && scores[2][2]=='O' && scores[3][3]=='O') {
			System.out.println("O wins!");
			return 'w';
		}
		else if(scores[0][3]=='X' && scores[1][2]=='X' && scores[2][1]=='X' && scores[3][0]=='X') {
			System.out.println("X wins!");
			return 'w';
		}
		else if(scores[0][3]=='O' && scores[1][2]=='O' && scores[2][1]=='O' && scores[3][0]=='O') {
			System.out.println("O wins!");
			return 'w';
		}
		else {
			return 'n';
		}
	}
		
		
	

}
