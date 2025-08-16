package telran.person;

import telran.set.MyHashSet;

import java.util.*;

public class PersonAppl  {
    public static void main(String[] args) {


    Person p1 = new Person(1, "name1", "surname1");
    Person p2 = new Person(2, "name1", "surname2");
    Person p3 = new Person(3, "name3", "surname1");
    MyHashSet<Person> persons = new MyHashSet<Person>();
    persons.add(p1);
    persons.add(p2);
    persons.add(p3);
    display(persons);
    System.out.println(persons.add(new Person(1, "name1", "surname1")));
    display(persons);
    Person p4 = new Person(1, "name1", "surname1");
    System.out.println(persons.contains(p4));
    System.out.println(persons.contains(p4));
    p1.setLastName("surname5");
    display(persons);

    Set<Person> personsSet = new HashSet<>();
    personsSet.add(p1);
    personsSet.add(p2);
    personsSet.add(p3);
    System.out.println(personsSet);
    persons.forEach(p -> System.out.println(p));
    List <Person> list = new ArrayList<>(personsSet);
    Set <Person> set1 = new TreeSet<>(personsSet);
    System.out.println(set1);
    System.out.println(list);
    Set <Person> set11 = new LinkedHashSet<Person>(list);
    System.out.println(set11);



//    System.out.println(personsSet.add(new Person(1, "name1", "surname5")));
//    System.out.println(personsSet);

    persons.forEach(p -> System.out.println(p));


    }

    public static  void display(MyHashSet<Person> per){
        for(Person p : per){
            System.out.print(p+ ", ");
        }
        System.out.println();
    }
}
