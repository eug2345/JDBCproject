package mockitoTestD4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import exception.DivideBy10.ExceptionsExercise;
import exception.ExcetionDemo.ExceptionsDemo;

public class CoinFlipTest {
	
		public static final ExceptionsDemo demo = null;

		CoinFlipManager coin = new CoinFlipManager();
		
		CoinFlipManager mockCoin = Mockito.mock(CoinFlipManager.class);
		
		@Disabled
		@Test
		public void coinFlipHeads() {
			// Arrange
			String result;
			
			// Act
			result = coin.coinFlip();
			
			// Assert
			Assertions.assertEquals("HEADS", result);
		}
		
		@Test 
		public void coinFlipMock() {
			String result;
			
			Mockito.when(Mock.rng.nextInt(101)).thenReturn(33);
			
			result = Mockito.coinFlipTest();
			System.out.println(Mock.rng.nextInt(101));
			
			// Assert 
			Assertions.assertEquals("HEADS", result);
		}
		public class Runner {

			public void main(String[] args) {
				new CoinFlipTest();
//				demo.arrayException(); // This causes the exception stopping the app completely
				demo.handleException(); // When we handle an exception, the app still runs 
				System.out.println("Let's see if this prints.. ");
				demo.twoTypesExceptions();
				demo.makeNewException();
				
				ExceptionsExercise exer = new ExceptionsExercise();
				System.out.println(exer.divideNums(53, 7));
			}

		}
	}