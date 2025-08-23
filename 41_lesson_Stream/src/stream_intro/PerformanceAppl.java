package stream_intro;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class PerformanceAppl {
    final static int N = 50_000_000;
    final static int MAX = 16;

    public static void main(String[] args) {

        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = i % (MAX + 1);


        System.out.println("==================");
        long start = System.currentTimeMillis();
        long s = IntStream.of(arr)
                .flatMap(x -> IntStream.range(0, x))// декларативный
                .asLongStream()
                .sum();

        System.out.println("flat sum " + (System.currentTimeMillis() - start + "ms" + " sum = " + s));


        start = System.currentTimeMillis();
        s = IntStream.of(arr)
                .mapMulti((x, sink) -> {// императивный код
                    for (int i = 0; i < x; i++)
                        sink.accept(i);
                })
                .asLongStream()
                .sum();

        System.out.println("Multi sum " + (System.currentTimeMillis() - start) + "ms" + " sum= " + s);

        System.out.println("========FILTER==========");
        start = System.currentTimeMillis();
        s = IntStream.of(arr)
                .flatMap(x -> IntStream.range(0, x))// стрим
                .filter(k -> k % 2 == 0)
                .asLongStream()
                .sum();

        System.out.println("flat filter " + (System.currentTimeMillis() - start + "ms" + " sum = " + s));

        start = System.currentTimeMillis();
        s = IntStream.of(arr)
                .mapMulti((x, sink) -> {// императивный код
                    for (int i = 0; i < x; i++)
                        if (i % 2 == 0)
                            sink.accept(i);
                })
                .asLongStream()
                .sum();

        System.out.println("Multi filter " + (System.currentTimeMillis() - start) + "ms" + " sum= " + s);

        System.out.println("==========BOXED===========");

        Integer[] b = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        start = System.currentTimeMillis();
        s = Arrays.stream(b)
                .flatMap(x -> IntStream.range(0, x).boxed())
                .mapToLong(Integer::longValue)
                .sum();

        System.out.println("flat boxed " + (System.currentTimeMillis() - start + "ms" + " sum = " + s));

        start = System.currentTimeMillis();
        s = Arrays.stream(b).<Integer>mapMulti((x, sink)-> {
            for (int i = 0; i < x; i++)
                sink.accept(i);})
                .mapToLong(Integer::longValue)
                .sum();


        System.out.println("Multi boxed " + (System.currentTimeMillis()-start)+ "ms"+" sum= "+ s);





    }
}
