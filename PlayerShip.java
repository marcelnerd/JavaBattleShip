
public class PlayerShip {

	private int shipX, shipY;
	private int health;
	
	PlayerShip(int x, int y) {
		shipX = x;
		shipY = y;
		health = 3;
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
	
	void attack(int x, int y, EnemyArray enemyGrid, EnemyShip eShip) {
		enemyGrid.checkIfPlayerHit(x, y, eShip);
	}
}
