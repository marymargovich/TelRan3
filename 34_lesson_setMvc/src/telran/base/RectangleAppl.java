package telran.base;

import java.sql.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RectangleAppl {
    public static void main(String[] args) {


        Rectangle r1 = new Rectangle(10, 20);
        Rectangle r2 = new Rectangle(20, 10);

        System.out.println(r1.hashCode());
        System.out.println(r2.hashCode());

        Rectangle r3 = new Rectangle(1, 1);
        Rectangle r4 = new Rectangle(0, 32);

        System.out.println(r3.hashCode());
        System.out.println(r4.hashCode());

        Set<Rectangle> collection = new HashSet<>
                (Arrays.asList(r1, r2, r3, r4));
        System.out.println(collection);
        Rectangle r5 = new Rectangle(1,1);
        collection.add(r5);
        System.out.println(collection);
        String [] str = {"asv","dfg", "dsff", "erwer",
                "aaad", "aaa", "as", "dfge", "dsffq", "erwerf", "aaada", "gsdf"};

        Set <String> strings = new HashSet<>(Arrays.asList(str));
        System.out.println(strings);
        strings.add("FGHHHJJKL");
        strings.add("2344566");
        System.out.println(strings);




    }
}
