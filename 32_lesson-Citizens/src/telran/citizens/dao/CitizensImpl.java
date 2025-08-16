package telran.citizens.dao;

import telran.citizens.entities.Person;

import java.util.Comparator;
import java.util.*;

public class CitizensImpl implements Citizens{

    private static Comparator<Person> lastNameComparator;
    private static Comparator<Person> ageComparator;
    static {
        lastNameComparator = (p1, p2) -> {
            String ln1 = p1.getLastName();
            String ln2 = p2.getLastName();
            int res =ln1 == null && ln2 == null ? 0
                    : ln1 == null ? 1
                    : ln2 == null ? -1
                    : ln1.compareTo(ln2);

            return res != 0 ? res : Integer.compare(p1.getId(), p2.getId());
        };
        ageComparator = (p1, p2) -> {
            Integer age1 = p1.getBirthDate()== null? null : p1.getAge();
            Integer age2 = p2.getBirthDate()== null? null : p2.getAge();

            int res =age1 == null && age2 == null ? 0
                    : age1 == null ? 1
                    : age2 == null ? -1
                    : age1.compareTo(age2);
            return res != 0 ? res : Integer.compare(p1.getId(), p2.getId());
        };
    }

    private List<Person> idList;
    private List<Person> lastNameList;
    private List<Person> ageList;

    public CitizensImpl() {
        idList = new ArrayList<>();
        lastNameList = new ArrayList<>();
        ageList = new ArrayList<>();
    }

    public CitizensImpl(List<Person> citizens) {
        this();
        citizens.forEach(p -> add(p));
    }

    @Override
    public boolean add(Person person) {
        if (person == null)
            return false;
        int index = Collections.binarySearch(idList, person);
        if (index >= 0)
            return false;
        index = -index - 1;
        idList.add(index, person);
        index = Collections.binarySearch(ageList, person, ageComparator);
        index = -index - 1;
        ageList.add(index, person);
        index = Collections.binarySearch(lastNameList, person, lastNameComparator);
        index = -index - 1;
        lastNameList.add(index, person);
        return true;
    }

    @Override
    public boolean remove(int id) {
        Person victim = find(id);
        if (victim == null)
            return false;
        idList.remove(victim);
        ageList.remove(victim);
        lastNameList.remove(victim);
        return true;
    }

    @Override
    public Person find(int id) {
        Person p = new Person(id, null, null, null);
        int index = Collections.binarySearch(idList, p);

        return index < 0 ? null : idList.get(index);
    }

    @Override
    public Iterable<Person> find(int minAge, int maxAge) {
        List<Person> res = new ArrayList<>();
        for (Person p : ageList) {
            if (p.getAge() >= minAge && p.getAge() <= maxAge)
                res.add(p);

        }
        return res;
    }

    @Override
    public Iterable<Person> find(String lastname) {
        Person p = new Person(Integer.MIN_VALUE, null, lastname, null);
        int from = -Collections.binarySearch(lastNameList, p, lastNameComparator) - 1;
        p = new Person(Integer.MAX_VALUE, null, lastname, null);
        int to = -Collections.binarySearch(lastNameList, p, lastNameComparator) - 1;
        return lastNameList.subList(from, to);
    }

    @Override
    public Iterable<Person> getAllPersonsSortedById() {
        return idList;
    }

    @Override
    public Iterable<Person> getAllPersonsSortedByLastName() {
        return lastNameList;
    }

    @Override
    public Iterable<Person> getAllPersonsSortedByAge() {
        return ageList;
    }

    @Override
    public int size() {

        return idList.size();
    }

}
