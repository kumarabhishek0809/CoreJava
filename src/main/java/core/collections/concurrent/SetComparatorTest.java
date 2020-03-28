package core.collections.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import core.domain.Person;

public class SetComparatorTest {
	private List<Person> persons;
	
	public static void main(String[] args, Function Person) {
		SetComparatorTest setComparatorTest = new SetComparatorTest();
		setComparatorTest.setPersons(setComparatorTest.createPersons());
		//setComparatorTest.getPersons().forEach( person -> {System.out.println(person);});
		
		Collections.sort(setComparatorTest.getPersons(),nameComparator);
		
		setComparatorTest.getPersons().forEach( person -> {System.out.println(person);});
		
		
		
	}
	
	private static Function getName() {
		// TODO Auto-generated method stub
		return null;
	}

	private static Comparator<Person> nameComparator = new Comparator<Person>(){

		@Override
		public int compare(Person person1, Person person2) {
			return person1.getName().compareTo(person2.getName());
		}
		
	};
	
	
	private static Comparator<Person> ageComparator = new Comparator<Person>(){

		@Override
		public int compare(Person person1, Person person2) {
			return person1.getAge() > person2.getAge() ? 1: -1;
		}
		
	};
	
	private List<Person> createPersons(){
		List<Person>persons = new ArrayList<>();
		persons.add(new Person("A",35));
		persons.add(new Person("A",29));
		persons.add(new Person("A",31));
		persons.add(new Person("B",36));
		persons.add(new Person("C",36));
		/*persons.add(new Person("Kumar",29));
		persons.add(new Person("A",33));
		persons.add(new Person("B",44));
		persons.add(new Person("C",77));*/
		return persons;
	} 

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

}
