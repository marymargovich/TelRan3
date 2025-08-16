import java.util.HashMap;
import java.util.*;
import java.util.Random;

public class MapAppl {
    public static void main(String[] args) {
        // геренация от 0 до 10 - 100 раз
        // мэпа подсчитывает какое кол-во раз

        Random r = new Random();
        Map<Integer, Integer> dice = new HashMap<>(16, 0.5f);

        for (int i = 0; i < 100; i++) {
            int number =r.nextInt(10,22);
            dice.put(number, dice.getOrDefault(number, 0)+1);
        }

        System.out.println(dice);
    }
}
