package simplelotro;

import java.util.List;

public class Ingredient {
	String name;
	List<Ingredient> components;
	
	public Ingredient(String name, List<Ingredient> components) {
		assert name.length() > 0;
		for (Object o : components) {
			assert o != null;
		}
		this.name = name;
		this.components = components;
	}

	/**
	 * Two ingredients are the same if their names are the same.
	 */
	public boolean equals(Object o) {
		return (o instanceof Ingredient) &&
				((Ingredient)o).getName().equals(this.getName());
	}
	
	public String getName() {
		return name;
	}

	public List<Ingredient> getComponents() {
		return components;
	}
}