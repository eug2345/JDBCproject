package exception;

public class RunnerException {
	
	// Intentionally make some errors for exceptions to be thrown 
	
		public void arrayException() {
			
			int[] numArray = {1,2,3};
			
			// What's going to happen here? 
			System.out.println(numArray[4]);
			
			// When an exception is thrown, the entire app stops
			// We want to stop this default behaviour and do something useful with the error
			System.out.println("Will this print?");
		}
		
		public void handleException() {
			// When writing code, anything in the try block will attempt to run
			try {
				String[] fruitArray = {"kiwi", "banana", "mango"};
				System.out.println(fruitArray[4]);
				
				// syso after the exception is thrown, still in the try{}
				System.out.println("What about this?");
				// If an error is thrown, the catch block will handle it
			} catch (ArrayIndexOutOfBoundsException e) { 
				// ArrayIndex..Exception is of type Exception
				
				
				// syso in our catch block
				e.printStackTrace();
				System.out.println("Will this print?");
			}
			
		}
		
		public void twoTypesExceptions() {
			
			try {
				// ArrayIndexOutOfBounds 
				// Divide / 0 
				
				int[] numbers = {1,2,3,4};
//				System.out.println(numbers[5]);
				int sum = 5/0;
				
			} catch (ArrayIndexOutOfBoundsException arrayException) {
				arrayException.printStackTrace(); // print off the exception error
			} catch (ArithmeticException divideZero) {
				divideZero.printStackTrace();
			} catch (Exception catchAll) {
				catchAll.printStackTrace();
				System.out.println("Will always run regardless of the exception");
			}
			
		}
		
		public void makeNewException() {
			try {
				
				int num = 4; 
				
				// Custom if statement in your code, that forces a new exception to be thrown 
				// if the user id is "seven" it causes a bug, you can make an exception be thrown for this case
				if(num > 2) {
					throw new Exception("Fancy Error Message..");
				}
				
			} catch (Exception fancyException) {
				fancyException.printStackTrace(); // print our "Fancy Error Message.."
			}
			
		}
		
	}


