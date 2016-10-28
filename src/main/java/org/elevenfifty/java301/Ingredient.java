package org.elevenfifty.java301;

import java.math.BigDecimal;

public class Ingredient {
	
	private final String name;
	
	private final BigDecimal cost;
	
	public Ingredient(String name, BigDecimal cost){
		this.name = name.toLowerCase();
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getCost() {
		return cost;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ingredient [name=");
		builder.append(name);
		builder.append(", cost=");
		builder.append(cost);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingredient other = (Ingredient) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equalsIgnoreCase(other.name))
			return false;
		return true;
	}
	
	

}
