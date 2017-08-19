/**
 * 
 */
package guru.springframework.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class CategoryTest {

	Category category;
	
	@Before
	public void setUp() {
		// get new category on each test method
		category = new Category();
		
	}
	
	@Test
	public void getId() throws Exception{
		
		// Arrange
		Long idValue = 4L;
		
		//Act
		category.setId(idValue);
		
		//Assert
		assertEquals("id = 4",idValue, category.getId());
	}

	@Test
	public void getDescription() throws Exception{
		//fail("Not yet implemented");
	}

	@Test
	public void getRecipes() throws Exception{
		//fail("Not yet implemented");
	}

}
