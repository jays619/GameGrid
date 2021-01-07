import java.security.SecureRandom;
import java.util.Scanner;

/**
 * 
 * @author said.hofiani37790
 */
public class GameGrid1 {

	SecureRandom oRandom = new SecureRandom();
	Scanner keyboard = new Scanner(System.in);
	SinglyLinkedList link = new SinglyLinkedList();
	
	public void GameGrid() {
		int iChanceofWall = 15;
		int[][] GameGrid = new int[10][10];
		int Random;

		// populate game grid
		for (int x = 0; x < GameGrid.length; x++) {
			for (int y = 0; y < GameGrid[x].length; y++) {
				Random = oRandom.nextInt(100);
				if (Random < iChanceofWall) {
					GameGrid[x][y] = 1;
				} else {
					GameGrid[x][y] = 0;
				}
			}
		}

		GameGrid[0][0] = 2;
		GameGrid[9][9] = 9;
		PrintDetails(GameGrid);
		Game(GameGrid);
	}

	// Fill in the values
	public void PrintDetails(int[][] GameGrid) {
		System.out.println();
		for (int x = 0; x < GameGrid.length; x++) {
			for (int y = 0; y < GameGrid.length; y++) {
				if (GameGrid[x][y] == 1) {
					System.out.print("1");
				} else if (GameGrid[x][y] == 0) {
					System.out.print("0");
				} else if (GameGrid[x][y] == 2) {
					System.out.print("X");
				} else if (GameGrid[x][y] == 9) {
					System.out.print("O");
				}
			}
			System.out.println();
			System.out.println();
		}
	}

	public void Game(int[][] GameGrid) {
		int IUserCol = 0;
		int IUserRow = 0;
		boolean exit = false;

		while (exit != true) {

			System.out.println("Use WASD to move the X. Hit ENTER after each input."+
							"Get to the bottom right corner! ");
			String User_R = keyboard.next();

			link.addHeadNode(IUserRow, IUserCol);
			
			if (User_R.equals("s")){
				GameGrid[IUserRow][IUserCol] = 0;
				IUserRow++;
			}
			else if (User_R.equals("d")){
				GameGrid[IUserRow][IUserCol] = 0;
				IUserCol++;
			}
			else if (User_R.equals("w")){
				GameGrid[IUserRow][IUserCol] = 0;
				IUserRow--;
			}
			else if(User_R.equals("a")){
				GameGrid[IUserRow][IUserCol] = 0;
				IUserCol--;
			}
			
			
			
			switch (GameGrid[IUserRow][IUserCol]) {
			case 1:
				System.out.print("You lose! ");
				exit = true;
				break;
			case 9:
				System.out.print("You win! ");
				exit = true;
				break;
			default:
				GameGrid[IUserRow][IUserCol] = 2;
				PrintDetails(GameGrid);
				
			}
			
			}
			
		    int playerMoves = 0;
			NODE tempNode = link.removeHeadNode();
			while(tempNode != null){
				playerMoves++;
				GameGrid[tempNode.xPosition][tempNode.yPosition] = 2;
				
				tempNode = link.removeHeadNode();
			}
			GameGrid[IUserRow][IUserCol] = 2;
			
			System.out.println("The number of moves the player enter was: " + playerMoves);
			PrintDetails(GameGrid);
			
	}
}
