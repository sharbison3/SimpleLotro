package simplelotro;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * An assembly of ingredients.
 * @author harbison
 */
public class Workshop {

	Map<Ingredient, Integer> theWorkshop;
	
	public Workshop() {
		super();
		this.theWorkshop = new HashMap<Ingredient, Integer>();
	}
	
	public boolean contains(Ingredient i) {
		return theWorkshop.containsKey(i);
	}
	
	public Set<Ingredient> getIngredients() {
		return theWorkshop.keySet();
	}
	
	public int getCount(Ingredient i) {
		if (contains(i)) {
			return theWorkshop.get(i);
		} else {
			return 0;
		}
	}
	
	public int size() {
		return theWorkshop.size();
	}
	
	/**
	 * Add delta more units of ingredient i to the workshop.
	 * If the workshop does not contain the ingrediat, it will be added.
	 * @param i
	 * @param delta
	 */
	private void addIngredient(Ingredient i, int delta) {
		Integer count = theWorkshop.get(i);
		if (count == null) {
			theWorkshop.put(i, delta);
		} else {
			theWorkshop.put(i, count + delta);
		}
	}

	public void build(Ingredient ingredient, int count) {
		for (Ingredient i : ingredient.getComponents()) {
			build(i, count);
		}
		addIngredient(ingredient, count);
	}
	
	public void dump() {
		for (Ingredient i : getIngredients()) {
			System.out.println(i.getName() + ":" + getCount(i));
		}
	}
}
