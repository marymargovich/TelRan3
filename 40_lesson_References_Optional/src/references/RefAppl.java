package references;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;

public class RefAppl {
    public static void main(String[] args) {
        int x = 10;
        int y = 0;
        y += x; //y = Y+x
        x++; //x = x+1

        // for (String s: list) System.out.println(s)
//       for(Iterator<String> it = list.iterator(); it.hasNext();){
//           String s = it.next();
//           System.out.println(s);


        Integer a = 5;// boxing Integer a = Integer.value.of(5);
        int b = a;// unboxing b = a.intValue()

        List<Integer> arr = Arrays.asList(10, 5, 78, 2, 18, 61);
        for (Integer in : arr) {
            System.out.print(in + " ");
        }
        System.out.println();
        System.out.println("========static============");
        System.out.println("========Functional interface");
        Consumer<Integer> printer1 = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.print(integer + " ");
            }
        };
        arr.forEach(printer1);
        System.out.println();
        System.out.println("============FI + lambda block");
        Consumer<Integer> printer2 = v -> {
            System.out.print(v + " ");
        };
        arr.forEach(printer2);
        System.out.println();

        System.out.println("(============FI + lambda");
        Consumer<Integer> printer3 = v -> System.out.print(v + " ");
        System.out.println(printer3);
        System.out.println();

        System.out.println("(============references");
        arr.forEach(System.out::println);
        arr.forEach(RefAppl:: printWithSpase);

        System.out.println();
        System.out.println("========OBJECT============");
        Person p1 = new Person("Name1");
        System.out.println("========FI");
        Runnable greet1 = new Runnable() {
            @Override
            public void run() {
                p1.greet();
            }
        };
        greet1.run();
        System.out.println("========FI lambda block");
        Runnable greet2 = ()-> {p1.greet(); return;};
        greet2.run();
        System.out.println("=========FI lambda");
        Runnable greet3 = ()-> p1.greet();
        greet3.run();
        System.out.println("========references");
        Runnable greet4 = p1:: greet;
        greet4.run();

        System.out.println("=========OBJECT======");
        System.out.println("==========FI=======");
        Function<String, Integer> length1 = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };

        Function<String, String > length11 = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        };



        System.out.println(" length of my string = "+ length1.apply("ghjdfjkfdkjdfkjdf"));
        System.out.println((" length of my string = "+ length11.apply("ghjdfjkfdkjdfkjdf")));
        Function<String, Integer> length2 = st->{return st.length();};
        System.out.println("length my string = " + length2.apply("dsfasfasdf"));
        System.out.println("=======Functional interface + lamba expression============");
        Function<String, Integer> length3 = st -> st.length();
        System.out.println("lenght" + length3.apply("jfhfdjhfgjh"));
        System.out.println("===========references");
        Function<String, Integer > length4 = String::length;
        System.out.println("lenght" + length4.apply("jfhfdjhfgjh"));
        Comparator<String> byIgnorCase = String :: compareToIgnoreCase;
        List<String> list1 = new ArrayList<String>(List.of("Fasfff", "adfe", "Adsfasf", "rwet", "fasf"));
        list1.sort(byIgnorCase);
        System.out.println(list1);
        Comparator <String> byIgnorCase1 = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        };

        System.out.println("==========CONSTRUCTOR");
        System.out.println(" =========FI");
        Supplier<Person> suppl1 = new Supplier<Person>() {
            @Override
            public Person get() {
                return new Person();
            }
        };
        Person p2 = suppl1.get();
        System.out.println(p2);
        String name = "name2";
        Supplier<Person> suppl11 = new Supplier<Person>() {
            @Override
            public Person get() {
                return new Person(name);
            }
        };
        Function<String, Person> suppl111 = new Function<String, Person>() {
            @Override
            public Person apply(String s) {
                return new Person();
            }
        };

        System.out.println("============FI + lambda block");
        Supplier<Person> suppl2 = ()-> {return new Person();};
        System.out.println("============FI + lambda ");
        Supplier<Person> suppl3 = () -> new Person();
        System.out.println("============references ");
        Supplier<Person> suppl4 = Person:: new;
        Person p11 = suppl4.get();
        System.out.println(p11);
        Function<String, Person> suppl41 = Person::new;
        Person p12 = suppl41.apply(name);
        System.out.println(p12);

        System.out.println("========Constructor");
        System.out.println("=====+FI");
        IntFunction<String[]> intF1 = new IntFunction<String[]>() {
            @Override
            public String[] apply(int value) {
                return new String[value];
            }
        };

        String [] str1 = intF1.apply(3);
        System.out.println(str1. length);
        String[] s = new String[10];

        System.out.println("=========lambbda");
        IntFunction<String[]> intF2 = n-> {return new String[n];};
        String[] str2 = intF2.apply(10);
        System.out.println("===========lambda2");
        IntFunction <String[]> intF3 = n-> new String[n];
        String []str3 = intF3.apply(10);
        System.out.println(str3.length);
        System.out.println("=======ref");;
        IntFunction<String[]>intF4 = String[]:: new;
        String[] str4 = intF4.apply(10);
        System.out.println(str4.length);





















    }

    static void printWithSpase(Object o){
        System.out.println( o+ " ");
    }
}


