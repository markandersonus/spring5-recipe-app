package guru.springframework.domain;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import guru.springframework.repositories.UnitOfMeasureRepository;

@RunWith(SpringRunner.class) // brings up the app context ONCE (unless @DirtiesContext is set on a test), which makes it an integration test
@DataJpaTest // bring up embedded db and configure spring-data-jpa
public class UnitOfMeasureIT {

	@Autowired // inject UoM repo
	UnitOfMeasureRepository unitOfMeasureRepository;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	//@DirtiesContext  // causes Spring Context to relaod
	public void findByDescription() {

		Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

		assertEquals("Teaspoon", uomOptional.get().getDescription());
	}
	
	@Test
	public void findByDescriptionCup() {

		Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Cup");

		assertEquals("Cup", uomOptional.get().getDescription());
	}
}
