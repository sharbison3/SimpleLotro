package simplelotro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ingredient {
	String name;
	List<Ingredient> components;
	static Map<String, Ingredient> allIngredients;
	
	static {
		clear();
	}
	
	public Ingredient(String name, List<Ingredient> components) {
		super();
		this.name = name;
		this.components = components;
		if (allIngredients.get(name) != null) {
			throw new RuntimeException("Duplicate ingredient: " + name);
		}
		allIngredients.put(name, this);
	}

	public String getName() {
		return name;
	}

	public List<Ingredient> getComponents() {
		return components;
	}

	public static Map<String, Ingredient> getAllIngredients() {
		return allIngredients;
	}

	static public Ingredient find(String name) {
		return allIngredients.get(name);
	}
	public static void clear() {
		allIngredients = new HashMap<String, Ingredient>();
	}
}