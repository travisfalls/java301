//package org.elevenfifty.java301;
//
//import java.math.BigDecimal;
//
//import org.elevenfifty.java301.Sandwich.BreadType;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.annotation.Bean;
//
//
//@SpringBootApplication
//
//public class ApplicationSandwichMaker {
//	
//
//	public static void main(String[] args) {
//
//		// SpringApplication.run(Application.class, args);
//
//		ConfigurableApplicationContext context = new SpringApplicationBuilder().sources(ApplicationSandwichMaker.class).run(args);
//
//		
//		System.out.println("-----------------------------------------------------------------------------------------");
//		//CODE HERE
//		
//		Sandwich sando = new Sandwich(BreadType.WHITE);
//		sando.addIngredient(context.getBean("ham", Ingredient.class));
//		sando.addIngredient(context.getBean("provolone", Ingredient.class));
//		sando.addIngredient(context.getBean("swiss", Ingredient.class));
//		sando.addIngredient(context.getBean("lettuce", Ingredient.class));
//		sando.addIngredient(context.getBean("pickles", Ingredient.class));
//		sando.addIngredient(context.getBean("mayo", Ingredient.class));
//		
//		
//		//System.out.println("Sandwich: " + sando);
//		System.out.println("Sandwich:");
//		System.out.println("\t" + sando.getBreadType());
//		System.out.println("\tIngredients:");
//		sando.getIngredients().forEach(i -> System.out.println("\t\t" + i.getName()));
//		
//		BigDecimal cost = sando.getIngredients().stream().map(Ingredient::getCost).reduce(BigDecimal.ZERO, BigDecimal::add);
////		BigDecimal tax = cost.multiply(0.07);
//		System.out.println("\tTotal: $" + cost);
//		
//		Sandwich mySandwich = new Sandwich(BreadType.WHEAT);
//		mySandwich.addIngredient(context.getBean("ham", Ingredient.class));
//		mySandwich.addIngredient(context.getBean("turkey", Ingredient.class));
//		mySandwich.addIngredient(context.getBean("roastBeef", Ingredient.class));
//		mySandwich.addIngredient(context.getBean("provolone", Ingredient.class));
//		mySandwich.addIngredient(context.getBean("cheddar", Ingredient.class));
//		mySandwich.addIngredient(context.getBean("provolone", Ingredient.class));
//		mySandwich.addIngredient(context.getBean("lettuce", Ingredient.class));
//		mySandwich.addIngredient(context.getBean("tomato", Ingredient.class));
//		mySandwich.addIngredient(context.getBean("pickles", Ingredient.class));
//		mySandwich.addIngredient(context.getBean("mayo", Ingredient.class));
//		
//		System.out.println("Sandwich:");
//		System.out.println("\t" + mySandwich.getBreadType());
//		System.out.println("\tIngredients:");
//		mySandwich.getIngredients().forEach(i -> System.out.println("\t\t" + i.getName()));
//		
//		BigDecimal total2 = mySandwich.getIngredients().stream().map(Ingredient::getCost).reduce(BigDecimal.ZERO, BigDecimal::add);
//		System.out.println("\tTotal: $" + total2);
//		
//		System.out.println("-----------------------------------------------------------------------------------------");
//		
//	}
//
//	@Bean
//	public Ingredient provolone() {
//		return new Ingredient("Provolone cheese", new BigDecimal(0.25d));
//	}
//	
//	@Bean
//	public Ingredient cheddar() {
//		return new Ingredient("Cheddar cheese", new BigDecimal(0.35d));
//	}
//	
//	@Bean
//	public Ingredient swiss() {
//		return new Ingredient("Swiss cheese", new BigDecimal(0.30d));
//	}
//	
//	@Bean
//	public Ingredient turkey() {
//		return new Ingredient("Turkey", new BigDecimal(1.00d));
//	}
//	
//	@Bean
//	public Ingredient ham() {
//		return new Ingredient("Ham", new BigDecimal(1.00d));
//	}
//	
//	@Bean
//	public Ingredient roastBeef() {
//		return new Ingredient("Roast Beef", new BigDecimal(2.00d));
//	}
//	
//	@Bean
//	public Ingredient tomato() {
//		return new Ingredient("Tomato", new BigDecimal(0.15d));
//	}
//	
//	@Bean
//	public Ingredient lettuce() {
//		return new Ingredient("Lettuce", new BigDecimal(0.15d));
//	}
//	
//	@Bean
//	public Ingredient mayo() {
//		return new Ingredient("Mayo", new BigDecimal(0.15d));
//	}
//	
//	@Bean
//	public Ingredient pickles() {
//		return new Ingredient("Pickles", new BigDecimal(0.25d));
//	}
//
//}
