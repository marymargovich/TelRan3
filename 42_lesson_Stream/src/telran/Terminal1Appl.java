package telran;

import java.util.Optional;
import java.util.stream.*;

public class Terminal1Appl {
    public static void main(String[] args) {
       int sum1 = Stream.of(1,2,3,4,5,6,7,8,9)
               .reduce(0, (a,b)-> a + b);

        System.out.println(sum1);

        int sum2 = Stream.of(1,2,3,4,5,6,7,8,9)
                .reduce((a,b)-> a + b).orElse(0);
        System.out.println(sum2);

        Optional<Integer> sum3 = Stream.of(1,2,3,4,5,6,7,8,9)
                .reduce((a,b)-> a + b);
        System.out.println(sum3.orElse(0));


    }
}
