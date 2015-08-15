package simplelotro;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class WorkshopTest {

	Ingredients ingredients;
	Ingredient a;
	Ingredient b;
	Ingredient c;
	Ingredient d;
	Ingredient x;
	Ingredient y;
	Ingredient z;
	Workshop workshop;
	
	@Before
	public void setUp() throws Exception {
		ingredients = new Ingredients();
		x = ingredients.addIngredient("x", Arrays.asList());
		y = ingredients.addIngredient("y", Arrays.asList());
		z = ingredients.addIngredient("z", Arrays.asList());
		c = ingredients.addIngredient("c", Arrays.asList(x, y));
		d = ingredients.addIngredient("d", Arrays.asList(x, z));
		a = ingredients.addIngredient("a", Arrays.asList(x, y));
		b = ingredients.addIngredient("b", Arrays.asList(c, d));
		workshop = new Workshop();
	}

	@Test
	public void test_zero() {
		assertTrue(workshop.size() == 0);
		assertFalse(workshop.contains(x));
	}
	
	@Test
	public void test_one() {
		workshop.build(x, 1);
		assertTrue(workshop.size() == 1);
		assertTrue(workshop.contains(x));
		assertTrue(workshop.getCount(x) == 1);
		
	}

	@Test
	public void test_three() {
		workshop.build(c, 1);
		assertTrue(workshop.size() == 3);
		assertTrue(workshop.contains(c));
		assertTrue(workshop.contains(x));
		assertTrue(workshop.contains(y));
		assertTrue(workshop.getCount(x) == 1);
		assertTrue(workshop.getCount(y) == 1);
		assertTrue(workshop.getCount(c) == 1);
	}

	@Test
	public void test_lots() {
		workshop.build(b, 2);
		workshop.dump();
		assertEquals(6, workshop.size());
		assertTrue(workshop.contains(c));
		assertTrue(workshop.contains(x));
		assertTrue(workshop.contains(y));
		assertEquals(2, workshop.getCount(b));
		assertEquals(2, workshop.getCount(c));
		assertEquals(2, workshop.getCount(d));
		assertEquals(4, workshop.getCount(x));
		assertEquals(2, workshop.getCount(y));
		assertEquals(2, workshop.getCount(z));
		assertEquals(0, workshop.getCount(a));
	}
}
