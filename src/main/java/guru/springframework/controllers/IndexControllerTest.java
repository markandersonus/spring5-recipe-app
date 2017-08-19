package guru.springframework.controllers;

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
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import org.springframework.ui.Model;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.services.RecipeService;
import guru.springframework.services.RecipeServiceImpl;


public class IndexControllerTest {

	// inject dependencies (real and mock)
	//RecipeServiceImpl recipeService;

	@Mock
	RecipeService recipeService;
	
	@Mock
	Model model;
	
	IndexController controller;

	@Before
	public void setUp() throws Exception {
		// initialise mock controller
		MockitoAnnotations.initMocks(this);
		controller = new IndexController(recipeService);
	}

	@Test
	public void indexController() {

		// when recipes service called return above data
		//when(recipeService.getRecipes()).thenReturn(recipesData);

		//Set<Recipe> recipes = recipeService.getRecipes();

		//assertEquals(recipes.size(), 1);

		// make sure findAll was called once and only once
		//verify(recipeRepository, times(1)).findAll();
	}

	@Test
	public void getIndexPage() {
		
		//given
		Set<Recipe> recipes = new HashSet();
		recipes.add(new Recipe());
		
		// Create 2nd recipe and add
		Recipe recipe = new Recipe();
		recipe.setId(1L);
		
		recipes.add(recipe);
		
		when(recipeService.getRecipes()).thenReturn(recipes);
		// Create actual set instead of anySet()
		ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
		
		//when
		String viewName = controller.getIndexPage(model);
		
		//then
		assertEquals("index", viewName);

		// make sure findAll was called once and only once
		verify(recipeService, times(1)).getRecipes();
		verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
		Set<Recipe> setInController = argumentCaptor.getValue();
		assertEquals(2, setInController.size());
	}

}
