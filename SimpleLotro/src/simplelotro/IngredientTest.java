package simplelotro;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class IngredientTest {

	@Test
	public void test_Constructor() {
		Ingredient.clear();
		Ingredient a = new Ingredient("a name", Arrays.asList());
		Ingredient b = new Ingredient("b name", Arrays.asList());
		Ingredient i = new Ingredient("name of it", Arrays.asList(a, b));
		assertTrue(i.getName().equals("name of it"));
		assertTrue(i.getComponents().get(0) == a);
		assertTrue(i.getComponents().get(1) == b);
		assertTrue(i.getComponents().size() == 2);
	}
	
	@Test
	public void test_empty() {
		Ingredient.clear();
		assertTrue(Ingredient.getAllIngredients().size() == 0);
		assertNull(Ingredient.find("x"));
	}

	@Test
	public void test_find() {
		Ingredient.clear();
		Ingredient a = new Ingredient("a name", Arrays.asList());
		Ingredient b = new Ingredient("b name", Arrays.asList());
		assertTrue(Ingredient.find("a name") == a);
		assertTrue(Ingredient.find("b name") == b);
		assertNull(Ingredient.find("A name"));
		assertTrue(Ingredient.getAllIngredients().size() == 2);
	}

	@Test
	public void test_duplicate() {
		Ingredient.clear();
		@SuppressWarnings("unused")
		Ingredient a1 = new Ingredient("a name", Arrays.asList());
		try {
			@SuppressWarnings("unused")
			Ingredient a2 = new Ingredient("a name", Arrays.asList());			
		}
		catch (RuntimeException e) {
			assertTrue(e.getMessage().equals("Duplicate ingredient: a name"));
		}
	}
}
