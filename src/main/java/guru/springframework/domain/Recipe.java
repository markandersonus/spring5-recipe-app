package guru.springframework.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Data
@Entity
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	private Integer prepTime;
	private Integer cookTime;
	private Integer servings;
	private String source;
	private String url;
	
	@Lob
	private String directions;
	
	@Enumerated(value = EnumType.STRING)
	private Difficulty difficulty;
	
	// init to avoid get null pointer exception
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
	private Set<Ingredient> ingredients = new HashSet<>();
	
	//hibernate makes default field size of 255 chars if @Lob not used
	@Lob
	private Byte[] image;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Notes notes;
	
	@ManyToMany
	@JoinTable(name="recipe_category", 
	joinColumns = @JoinColumn(name = "recipe_id"), 
	inverseJoinColumns = @JoinColumn(name="category_id"))
	
	// init to avoid get null pointer exception
	private Set<Category> categories = new HashSet<>();




	public void setNotes(Notes notes) {
		this.notes = notes;
		notes.setRecipe(this); //updates recipeId on note. keeps logic of adding bi-di link in one place
	}


	public Recipe addIngredient(Ingredient ingredient) {
		 ingredient.setRecipe(this); //updates recipeId on ingredient
	        this.ingredients.add(ingredient);
	        return this;
		
	}

	
}
