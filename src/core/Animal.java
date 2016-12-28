package core;

import java.util.ArrayList;   
import java.util.List;

public class Animal {
	
	private String name;
	private static List<Animal> animals = new ArrayList<Animal>();

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
