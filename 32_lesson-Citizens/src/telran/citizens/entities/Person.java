package telran.citizens.entities;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Person  implements Comparable<Person>{
    private  int id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    static final LocalDate NOW = LocalDate.now();


    public Person() {};

    public Person(int id, String firstName,
                  String lastName, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        if(birthDate == null || birthDate.isAfter(NOW))
            throw new IllegalArgumentException("Enter correct date");

        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person person)) return false;
        return id == person.id;
    }


    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getAge(){
        if(birthDate == null){
            return -1;
        }
        return (int) ChronoUnit.YEARS.between(birthDate, LocalDate.now());


    }

    @Override
    public int compareTo(Person p) {
        return Integer.compare(id, p.id);
    }

    @Override
    public String toString() {
        return "Person: " +
                "id=\u001B[32m" + id + "\u001B[0m, " +
                "firstName=\u001B[34m" + firstName + "\u001B[0m, " +
                "lastName=\u001B[34m" + lastName + "\u001B[0m, " +
                "birthDate=\u001B[35m" + birthDate + "\u001B[0m" +"\n";
    }
}
