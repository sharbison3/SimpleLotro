package simplelotro;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class IngredientsTest {

	Ingredients ingredients;
	final List<Ingredient>EMPTY_LIST = new ArrayList<Ingredient>();
	
	@Before
	public void setUp() throws Exception {
		ingredients = new Ingredients();
	}

	@Test
	public void test_empty() {
		assertTrue(ingredients.size() == 0);
		assertTrue(ingredients.getIngredients().size() == 0);
	}

	@Test
	public void test_one() {
		ingredients.addIngredient("a", EMPTY_LIST);
		assertTrue(ingredients.size() == 1);
		assertTrue(ingredients.getIngredients().size() == 1);
		assertTrue(ingredients.getIngredients().get(0).getName().equals("a"));
	}

	@Test
	public void test_two() {
		ingredients.addIngredient("a", EMPTY_LIST);
		ingredients.addIngredient("b", EMPTY_LIST);
		assertTrue(ingredients.size() == 2);
		assertTrue(ingredients.getIngredients().size() == 2);
		assertTrue(ingredients.getIngredients().get(0).getName().equals("a"));
		assertTrue(ingredients.getIngredients().get(1).getName().equals("b"));
	}

	@Test
	public void test_duplicate() {
		ingredients.addIngredient("a", EMPTY_LIST);
		try {
			ingredients.addIngredient("a", EMPTY_LIST);			
		}
		catch (RuntimeException e) {
			assertTrue(e.getMessage().equals("Duplicate ingredient: a"));
		}
	}

}
