package simplelotro;

import java.util.ArrayList;
import java.util.List;

/**
 * Keeps track of all ingredients.
 * @author harbison
 *
 */
public class Ingredients {
	List<Ingredient> allIngredients;
	
	public Ingredients() {
		allIngredients = new ArrayList<Ingredient>();
	}

	public Ingredient addIngredient(String name, List<Ingredient> components) {
		Ingredient i = new Ingredient(name, components);
		if (allIngredients.contains(i)) {
			throw new RuntimeException("Duplicate ingredient: " + name);
		}
		allIngredients.add(i);
		return i;
	}
	
	public int size() {
		return allIngredients.size();
	}
	
	public List<Ingredient> getIngredients() {
		return allIngredients;
	}
}
