
public class EnemyShip {

	private int shipX, shipY, health;
	RandomNumberGenerator randGen;
	
	
	EnemyShip(int x, int y) {
		shipX = x;
		shipY = y;
		health = 3;
		randGen = new RandomNumberGenerator();
	}
	
	int getX() {
		return shipX;
	}
	
	int getY() {
		return shipY;
	}
	
	int getHealth() {
		return health;
	}
	
	void takeDamage(int damage) {
		health = health - damage;
	}
	
	
	void enemyTurn(PlayerArray playerGrid, PlayerShip pShip) {
		int randNumX = randGen.getRandomNumber(1, 8);
		int randNumY = randGen.getRandomNumber(1, 8);
		
		playerGrid.checkIfEnemyHit(randNumX, randNumY, pShip);
	}
	
}
