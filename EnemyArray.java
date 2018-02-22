
public class EnemyArray {
	
	private char[][] enemyGrid;
	private char[][] playerEnemView;
	private int xMax, yMax;
	int shipSectionsRemaining;
	
	EnemyArray(int maxX, int maxY) {
		enemyGrid = new char[maxX][maxY];
		playerEnemView = new char[maxX][maxY];
		xMax = maxX;
		yMax = maxY;
	}
	
	char[][] getEnemyArray() {
		return enemyGrid;
	}
	
	char[][] getplayerEnemView() {
		return playerEnemView;
	}
	
	void generateBoard(EnemyShip enemyShip) {
		for (int i = 1; i < 9; i++) {
			for (int l = 1; l < 9; l++) {
				enemyGrid[i][l] = '~';
			}
		}
		enemyGrid[1][0] = '1'; enemyGrid[2][0] = '2'; enemyGrid[3][0] = '3'; enemyGrid[4][0] = '4'; enemyGrid[5][0] = '5'; enemyGrid[6][0] = '6'; enemyGrid[7][0] = '7'; enemyGrid[8][0] = '8';
		enemyGrid[0][1] = '1'; enemyGrid[0][2] = '2'; enemyGrid[0][3] = '3'; enemyGrid[0][4] = '4'; enemyGrid[0][5] = '5'; enemyGrid[0][6] = '6'; enemyGrid[0][7] = '7'; enemyGrid[0][8] = '8';
	
		enemyGrid[enemyShip.getX()][enemyShip.getY()] = '#';
		enemyGrid[enemyShip.getX()][enemyShip.getY() + 1] = '#';
		enemyGrid[enemyShip.getX()][enemyShip.getY() + 2] = '#';
		
		for (int i = 1; i <= 8; i++) {
			for (int l = 1; l <= 8; l++) {
				playerEnemView[i][l] = '~';
			}
		}
		playerEnemView[1][0] = '1'; playerEnemView[2][0] = '2'; playerEnemView[3][0] = '3'; playerEnemView[4][0] = '4'; playerEnemView[5][0] = '5'; playerEnemView[6][0] = '6'; playerEnemView[7][0] = '7'; playerEnemView[8][0] = '8';
		playerEnemView[0][1] = '1'; playerEnemView[0][2] = '2'; playerEnemView[0][3] = '3'; playerEnemView[0][4] = '4'; playerEnemView[0][5] = '5'; playerEnemView[0][6] = '6'; playerEnemView[0][7] = '7'; playerEnemView[0][8] = '8';
	}
	
	void displayPlayerView() {
		System.out.println("Player View of Enemy Board");
		for (int i = 0; i < 9; i++) {
			for (int l = 0; l < 9; l++) {
				System.out.print(playerEnemView[l][i]);
			}
			System.out.println();
		}
	}
	
	boolean checkCoorsInArray(int X, int Y) {
		if( (X <= xMax) && (Y <= yMax) && (X >= 1) && (Y>= 1) ) {
			return true;
		}
		else {
			System.out.println("Invalid Coordinants");
			return false;
		}
	}
	
	void checkIfPlayerHit(int x, int y, EnemyShip ship) {
		if(enemyGrid[x][y] == '#') {
			playerEnemView[x][y] = '!';
			System.out.println("You hit!");
			ship.takeDamage(1);
			
		}
		else {
			playerEnemView[x][y] = '@';
			System.out.println("You missed.");
		}
	}
	
	boolean checkIfShipsRemain(EnemyShip ship) {
		if(ship.getHealth() <= 0) {
			return false;
		}
		else {
			return true;
		}
	}
	

}
