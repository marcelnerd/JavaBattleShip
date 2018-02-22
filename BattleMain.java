import java.util.Scanner;

public class BattleMain {

	public static void main(String[] args) {
		int maxX = 9, maxY = 9;
		Scanner sc;
		PlayerArray playerGrid = new PlayerArray(maxX, maxY);
		EnemyArray enemyGrid = new EnemyArray(maxX, maxY);
		PlayerShip pShip;
		EnemyShip eShip;
		RandomNumberGenerator RandGen = new RandomNumberGenerator();
		int curCoX, curCoY; // Coordinants entered by the player
		int atakCoorX, atakCoorY; // Coordinants of where the player is firing
		boolean playerShipsRemain = true;
		boolean enemyShipsRemain = true;
		boolean coorsInArray = true;
		sc = new Scanner(System.in);
		
		playerGrid.setBoard();

		
		System.out.println("Welcome to HostileInteractionAquaticVessel 2018");
		do {
			System.out.println("You have on ship on an 8 by 8 board. What is the X coordinant of where you would like to place the front of your ship?");
			curCoX = sc.nextInt();
			System.out.println("What is the X coordinant of where you would like to place the front of your ship?");
			curCoY = sc.nextInt();
			
		}
		while(playerGrid.checkShipInArray(curCoX, curCoY, maxX, maxY) == false);
		
		pShip = new PlayerShip(curCoX, curCoY);
		eShip = new EnemyShip(RandGen.getRandomNumber(1, 8), RandGen.getRandomNumber(1, 8));
		playerGrid.placeShips(pShip, playerGrid.getArray());
		enemyGrid.generateBoard(eShip);
		System.out.println("Ready for battle.");
		
		while( (playerShipsRemain == true) && (enemyShipsRemain == true) ) {
			
			playerGrid.displayBoard();
			enemyGrid.displayPlayerView();
			
			do {
				
				System.out.println("What is the X coordinant of where you would like to shoot?");
				atakCoorX = sc.nextInt();
				System.out.println("What is the Y coordinant of where you would like to shoot?");
				atakCoorY = sc.nextInt();
			}
			while(enemyGrid.checkCoorsInArray(atakCoorX, atakCoorY) == false);
			
			pShip.attack(atakCoorX, atakCoorY, enemyGrid, eShip);
			eShip.enemyTurn(playerGrid, pShip); //WRITE CODE
			
			playerShipsRemain = playerGrid.checkIfShipsRemain(pShip);
			enemyShipsRemain = enemyGrid.checkIfShipsRemain(eShip);
		}
		
		System.out.println("Game Over");
		sc.close();

	}

}
