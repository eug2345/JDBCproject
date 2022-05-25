package mockitoTestD4;

	import org.junit.jupiter.api.Assertions;
	import org.junit.jupiter.api.Test;
	import org.junit.jupiter.api.extension.ExtendWith;
	import org.mockito.InjectMocks;
	import org.mockito.Mock;
	import org.mockito.Mockito;
	import org.mockito.junit.jupiter.MockitoExtension;

import petShopJDBC.Bird;
import petShopJDBC.Controller;
import petShopJDBC.PetShop2;

	@ExtendWith(MockitoExtension.class)
	public class ControllerTest {
		
		
		@Mock
		private PetShop2 mockShop;
		
		@InjectMocks
		private Controller controller;
		
		
		Bird bird1 = new Bird("test colour", 1, "test name");     
		Bird bird1ID = new Bird(1,"test colour", 1, "test name"); 
		Bird bird5ID = new Bird(5,"test colour", 1, "test name");
		
		@Test
		public void createBirdTest() {
			
			Mockito.when(mockShop.addBird(bird1)).thenReturn(bird1ID);
			Bird result;
			
			result = controller.createBird(bird1);
			
			Assertions.assertEquals(bird1ID, result);
			
			Mockito.verify(mockShop, Mockito.times(1)).addBird(bird1);
			Mockito.verify(mockShop, Mockito.atLeast(1)).addBird(bird1);
			Mockito.verify(mockShop, Mockito.atLeastOnce()).addBird(bird1);
			Mockito.verify(mockShop, Mockito.atMostOnce()).addBird(bird1);
			Mockito.verify(mockShop, Mockito.never()).addBird(bird1ID);
			
		}
		
		@Test
		public void readByIDTest() {
			
			Mockito.when(mockShop.getBirdById(1)).thenReturn(bird1ID);
			Bird result;
			
			result = controller.readBirdById(1);
			
			Assertions.assertEquals(bird1ID, result);
			
			Mockito.verify(mockShop, Mockito.times(1)).getBirdById(1);
			Mockito.verify(mockShop, Mockito.never()).addBird(bird1);		
			
			
		}

	}




