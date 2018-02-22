import java.util.Random;

public class RandomNumberGenerator {
	
	private int maxX;
	private int maxY;
	private int randNumX;
	private int randNumY;
	Random rand;
	
	RandomNumberGenerator() {
		rand = new Random();
	}

	
	int getRandomNumber(int min, int max) {
		int randNum = rand.nextInt((max - min) + 1) + min;
		return randNum;
	}
}
