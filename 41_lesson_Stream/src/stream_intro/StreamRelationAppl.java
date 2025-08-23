package stream_intro;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamRelationAppl {


    final static long N_NUMBERS = 10;
    public  static void main(String[] args) {

        //one-to - one: map, boxed, peek
        //one - to many - >>many - to-one: flatMap,mapMulty
        //many - to -many: skip, limit, takeWhile, dropWhile

        List<Integer> list = getRandomNumbers();
        //System.out.println(list);
        long sum = getSumEven(list);
        System.out.println(sum);
        IntSummaryStatistics stats = list.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();
        System.out.println(stats);
        OptionalInt maxOp = list.stream()
                .mapToInt(n -> n)
                .max();
        maxOp.ifPresent(s->System.out.println("max = "+ s));
        int max1 = maxOp.orElse(Integer.MAX_VALUE);
        System.out.println("max = "+ max1);
        long count = list.stream().mapToInt(n-> n). count();
        System.out.println("count " + count);
        System.out.println(stats.getAverage());

        OptionalInt max_ = IntStream.empty().max();
        int safeMax = max_.orElse(Integer.MAX_VALUE);
        System.out.println(safeMax);
       // int safeMax_ = max_.orElseThrow();



    }
    private static List<Integer> getRandomNumbers(){
        return new Random()
                .ints(N_NUMBERS, 1, Integer.MAX_VALUE)
                .boxed()
                .collect(Collectors.toList());



    }

    private static long getSumEven(List<Integer> list){
        return list.stream()
                .filter(n-> n%2 == 0)
                .mapToLong(n-> n)
                .sum();

    }





}
