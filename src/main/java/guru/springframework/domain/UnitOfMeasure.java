package guru.springframework.domain;


import javax.persistence.*;

@Entity
public class UnitOfMeasure {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String description;
	
	@OneToOne
	private Recipe recipe;

	public String getDescription() {
		return description;
	}

	public void setDescription(String uom) {
		this.description = uom;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	
}
