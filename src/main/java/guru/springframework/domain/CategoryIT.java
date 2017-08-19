package guru.springframework.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import guru.springframework.repositories.CategoryRepository;


@RunWith(SpringRunner.class)  // brings up the app context
@DataJpaTest // bring up embedded db and configure spring-data-jpa
public class CategoryIT {

	@Autowired
	CategoryRepository categoryRepository;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testHashCode() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetId() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetDescription() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetRecipes() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetId() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetDescription() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetRecipes() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testToString() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testCategory() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testEqualsObject() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testCanEqual() {
		fail("Not yet implemented"); // TODO
	}

}
