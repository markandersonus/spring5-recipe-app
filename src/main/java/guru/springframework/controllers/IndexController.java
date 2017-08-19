package guru.springframework.controllers;


import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import guru.springframework.services.RecipeService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {

	private final RecipeService recipeService;
	
	public IndexController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	
	
	@RequestMapping({ "", "/", "/index" })
	public String getIndexPage(Model model) {
		log.debug("Getting Index Page");
		
		// call recipe service and get set of recipes
		// assign to view model property "recipes"
		model.addAttribute("recipes", recipeService.getRecipes());
		return "index";
	}

	
}
