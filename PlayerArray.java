
public class PlayerArray {

	private char[][] playerGrid;
	private int shipSectionsRemaining = 0;

	PlayerArray(int maxX, int maxY) {
		playerGrid = new char[maxX][maxY];
	}
	
	boolean checkShipInArray(int X, int Y, int Xmax, int Ymax) {
		if( (X <= Xmax) && (Y <= Ymax) && (X >= 1) && (Y>= 1) ) {
			return true;
		}
		else {
			System.out.println("Invalid Coordinants");
			return false;
		}
	}
	
	void placeShips(PlayerShip ship, char[][] grid) {
		grid[ship.getX()][ship.getY()] = '#';
		grid[ship.getX()][ship.getY() + 1] = '#';
		grid[ship.getX()][ship.getY() + 2] = '#';
	}
	
	void setBoard() {
		for (int i = 1; i < 9; i++) {
			for (int l = 1; l < 9; l++) {
				playerGrid[i][l] = '~';
			}
		}
		playerGrid[1][0] = '1'; playerGrid[2][0] = '2'; playerGrid[3][0] = '3'; playerGrid[4][0] = '4'; playerGrid[5][0] = '5'; playerGrid[6][0] = '6'; playerGrid[7][0] = '7'; playerGrid[8][0] = '8';
		playerGrid[0][1] = '1'; playerGrid[0][2] = '2'; playerGrid[0][3] = '3'; playerGrid[0][4] = '4'; playerGrid[0][5] = '5'; playerGrid[0][6] = '6'; playerGrid[0][7] = '7'; playerGrid[0][8] = '8';
	}
	
	char[][] getArray() { // Returns the array of the object
		return this.playerGrid;
	}
	
	void displayBoard() {

		System.out.println("Player Board");
		for (int i = 0; i < 9; i++) {
			for (int l = 0; l < 9; l++) {
				System.out.print(playerGrid[l][i]);
			}
			System.out.println();
		}
	}
	
	boolean checkIfShipsRemain(PlayerShip ship) {
		if(ship.getHealth() <= 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	void checkIfEnemyHit(int x, int y, PlayerShip ship) {
		if(playerGrid[x][y] == '#') {
			playerGrid[x][y] = '!';
			System.out.println("The enemy hit!");
			ship.takeDamage(1);
			
		}
		else {
			playerGrid[x][y] = '@';
			System.out.println("The enemy missed");
		}
	}
}
