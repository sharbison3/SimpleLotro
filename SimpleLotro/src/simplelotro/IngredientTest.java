package simplelotro;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class IngredientTest {

	@Test
	public void test_Constructor() {
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
		Ingredient a = new Ingredient(null, Arrays.asList());
		@SuppressWarnings("unused")
		Ingredient b = new Ingredient("b", Arrays.asList(a, null));
	}
}
