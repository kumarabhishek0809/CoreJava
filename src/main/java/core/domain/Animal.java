package core.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Animal {
	
	private String name;
	private static List<Animal> animals = new ArrayList<Animal>();
private AtomicInteger a;


	public Animal(String name){
		this.setName(name);
	}

	public static void main(String[] args) {
		
		
		 
		
		for(int i =0; i<5; i++){
			animals.add(new Animal("Test"+i));
		}
		
		Animal mainAnimal = new Animal("main");
		mainAnimal.setAnimals(animals);
		
		for(Animal animal : mainAnimal.getAnimals()){
			System.out.println(animal.getName());
		}
		
	}

	public static List<Animal> getAnimals() {
		return animals;
	}

	public static void setAnimals(List<Animal> animals) {
		Animal.animals = animals;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
