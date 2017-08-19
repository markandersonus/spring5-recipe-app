package guru.springframework.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;

public class RecipeServiceImplTest {

	// inject dependencies (real and mock)
	RecipeServiceImpl recipeService;

	@Mock
	RecipeRepository recipeRepository;
	

	@Before
	public void setUp() throws Exception {
		// initialise mock recipeRepo
		MockitoAnnotations.initMocks(this);
		recipeService = new RecipeServiceImpl(recipeRepository);	
	}

	

	

	@Test
	public void getRecipes() {
		
		// Setup recipe data fro mockito
		Recipe recipe = new Recipe();
		HashSet recipesData = new HashSet();
		recipesData.add(recipe);
		
		//when recipes service called return above data
		when(recipeService.getRecipes()).thenReturn(recipesData);
		
		Set<Recipe> recipes = recipeService.getRecipes();
		
		assertEquals(recipes.size(), 1);
		
		// make sure findAll was called once and only once
		verify(recipeRepository, times(1)).findAll();

	}

}

