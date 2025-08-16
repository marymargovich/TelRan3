package telran.citizens.tests;

import telran.citizens.dao.CitizensImpl;
import telran.citizens.entities.Person;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CitizensImplTests {
    private CitizensImpl citizens;
    private Person [] persons;



    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        citizens = new CitizensImpl();

        persons = new Person[] {
                createPerson(1, "FirstName1", "LastName1", 1990),
                createPerson(2, "FirstName2", "LastName1", 1985),
                createPerson(3, "FirstName3", "LastName1", 1995)
        };

        for (Person p : persons) {
            citizens.add(p);
        }

    }

    private Person createPerson(int id, String firstName, String lastName, int birthYear) {
        return new Person(id, firstName, lastName, LocalDate.of(2000, 12, 6));
    }


    @org.junit.jupiter.api.Test
    void addPositive() {

        assertTrue(citizens.add(createPerson(4, "FirstName4", "LastName1", 2000)));
        assertFalse(citizens.add(persons[0]));
        assertFalse(citizens.add(null));
        assertEquals(4, citizens.size());



    }

    @org.junit.jupiter.api.Test
    void addNegative() {
        assertFalse(citizens.add(persons[0]));
        assertFalse(citizens.add(null));
        assertEquals(3, citizens.size());

    }

    @org.junit.jupiter.api.Test
    void removePositive() {

        assertTrue(citizens.remove(persons[0].getId()));
        assertEquals(2, citizens.size());
        assertNull(citizens.find(persons[0].getId()));
    }

    @org.junit.jupiter.api.Test
    void removeNegative() {
        assertFalse(citizens.remove(999));
        CitizensImpl emptyCitizens = new CitizensImpl();
        assertFalse(emptyCitizens.remove(1));

    }}