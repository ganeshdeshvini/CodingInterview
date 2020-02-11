package miscellaneous;

import java.util.HashSet;
import java.util.Set;

public class HashCodeEqualWrongImplementation {
    static class Person {
        final String name;
        final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // @Override
        // public int hashCode() {
        // return name.hashCode() * age;
        // }
    }

    public static void main(String[] args) {
        final Set<Person> people = new HashSet<>();
        final Person person1 = new Person("Alice", 28);
        final Person person2 = new Person("Bob", 30);
        final Person person3 = new Person("Charlie", 22);
        final boolean person1Added = people.add(person1);
        final boolean person2Added = people.add(person2);
        final boolean person3Added = people.add(person3);

        // logically equal to person1
        final Person person1Again = new Person("Alice", 28);
        // should return false, as Alice is already in the set
        final boolean person1AgainAdded = people.add(person1Again);
        // But will return true as the equals method has not been implemented
        System.out.println(4 == people.size() ? "True" : "False");

        for (Person p : people) {
            System.out.println(p.name + ", " + p.age);
        }
    }
}
