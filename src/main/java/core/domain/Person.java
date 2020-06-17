package core.domain;


public class Person implements Comparable<Person> {

    private int age;
    private String firstName;
    private String lastName;

    public Person(String name, int age) {
        this.firstName = name;
        this.age = age;
    }

    Person(int age, String name) {
        this.age = age;
        this.firstName = name;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + firstName + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public int compareTo(Person o) {
        int returnValue = 0;
        if (o != null && o instanceof Person) {
            returnValue = this.getAge() > o.getAge() ? 1 : -1;
        }
        return returnValue;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
