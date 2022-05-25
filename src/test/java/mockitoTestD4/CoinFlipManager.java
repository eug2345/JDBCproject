package mockitoTestD4;

import java.util.Random;

public class CoinFlipManager {
	
	Random rng = new Random();
	
	
	public String coinFlip() {
		
		int randNum = rng.nextInt(101);
		
		if(randNum <= 49) {
			return "HEADS";
		} else if(randNum <= 99) {
			return "TAILS";
		} else if(randNum == 100) {
			return "EDGE";
		}
		
		return null;
	}
	
	public String higherLower(int x) {
		
		int randNum = rng.nextInt(51);
		
		if(x > randNum) {
			return "Higher!";
		} else if (x < randNum) {
			return "Lower!";
		} else {
			return "Same Number..";
		}
	}

}


