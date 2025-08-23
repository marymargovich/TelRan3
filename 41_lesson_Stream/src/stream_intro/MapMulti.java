package stream_intro;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MapMulti {
    public static void main(String[] args) {

        List<String> s1 = List.of("a,b" , "c", "d,e,f");

        List<String> out1 = s1.stream()
                .flatMap(s-> Arrays.stream(s.split(",")))
                .toList();
        System.out.println(out1);

        List<String> out2 = s1.stream()
                .<String> mapMulti((s, sink)-> {
                    for (String part : s.split(","))
                    {sink.accept(part);}
                }).toList();
        System.out.println(out2);

        Stream<String> digits = Stream.of("a1", "b23", "c", "009");

        Stream.of("a1", "b23", "c", "009").
                <Character> mapMulti((str, sink)-> {
                   for (Character c : str.toCharArray()){
                       if (Character.isDigit(c)) {
                           sink.accept(c);
                       }
                   }
                })
                //.mapToInt(ch -> ch - '0')
                .map(Character::getNumericValue)
                .forEach(System.out::println);
        };




    }
/*
Stream.of("sdafadfs", "jkoijoigf", "fgaewg")
                .<Character>mapMulti((str, sink)-> {
                    for(char c : str.toCharArray())sink.accept(c);
                }).forEach(System.out::println);
 */
