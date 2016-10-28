package org.elevenfifty.java301;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
	
	public static enum BreadType {WHEAT, WHITE};
	
	private BreadType breadType;
	
	private List<Ingredient> ingredients;
	
	public Sandwich(BreadType breadType){
		this.breadType = breadType;
		ingredients = new ArrayList<Ingredient>();
	}
	
	public void addIngredient (Ingredient i){
		this.ingredients.add(i);
	}

	public BreadType getBreadType() {
		return breadType;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	@Override
	public String toString() {
		return "Sandwich [breadType=" + breadType + ", ingredients=" + ingredients + "]";
	}
	
	

}
