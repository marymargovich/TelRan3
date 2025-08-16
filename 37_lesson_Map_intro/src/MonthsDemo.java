import java.util.*;
import java.util.function.Predicate;

public class MonthsDemo {
    public static void main(String[] args) {
       // Map<String, Integer> months = new HashMap<>();
        Map<String, Integer> months = new LinkedHashMap<>();
        //Map<String, Integer> months = new TreeMap<>();
         Map<Map <String, Integer>, List<Integer> > monthsList = new HashMap<>();
        // двойная типизация
        fillMap (months);
        System.out.println(months);
        System.out.println("put jan = 100 old value =  "+ months.put("jan", 100));
        System.out.println(months);
        System.out.println("put jan = 100 old value =  "+ months.put(" may", 5));

        System.out.println("//========putAll - нe возвращает ничего - объединить две мэп");

        System.out.println("// ========putIfAbsent - добавляет только если нет такого ключа");
        System.out.println( months.putIfAbsent("jan", 1));
        System.out.println(months);
        System.out.println( months.putIfAbsent("jun", 6));
        System.out.println(months+ " months");
        Map <String, Integer> months1 = new HashMap<>();
        months1.put("jan", 1000);
        months1.put("feb", 20);
        months1.put("jul", 399);
        months1.put("aug", 48);
        System.out.println();
        System.out.println(" months1 "+ months1 );
        months.putAll(months1);
        System.out.println( months+ " months + months1 ");
        months1.putAll(months);
        System.out.println(months1);

        System.out.println("// ===========Contains Key - возращает тру/фолс");
        System.out.println(months.containsKey("jan"));
        System.out.println(months.containsKey("Jan"));

        System.out.println("//=============Contains Value");
        System.out.println(months.containsValue(100));
        System.out.println(months.containsValue(1001));

        System.out.println("=================get - объект по ключу");
        System.out.println(months.get("jan"));
        System.out.println(months.get("Jan"));

        System.out.println("==================getOrDefault - значение по ключу. " +
                                             "если нет - верни не нал?");
        System.out.println(months.getOrDefault("jan", 0));
        System.out.println(months.getOrDefault("Jan", 0));

        System.out.println("==================remove");
        System.out.println(months.remove("jan"));
        System.out.println(months);
        System.out.println(months.remove("jan"));
        System.out.println(months);
        System.out.println(months.remove("jun", 6));
        System.out.println(months);
        System.out.println(months.remove("jun", 6));


        System.out.println("===============clear - зачистка");
        months1.clear();
        System.out.println(months1);

        System.out.println("========entrySet() - возражает  сет пар - ");
        System.out.println("=========keySet() - возвращает ключи, уникальные");
        System.out.println("==========values() - list -коллекция одинаковые значения могут быть");


        iterateEntries(months);
        iterateMonthsNames(months);
        iterateMonthsNumbers(months);

        System.out.println();
        System.out.println("=============Predicate");
        System.out.println();

        months.values().removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer t) {
                return t%2 == 0;
            }
        });

        System.out.println(months);

























    }

    private static void iterateMonthsNumbers(Map<String, Integer> months) {
        System.out.println("=============values  iterate========");
        for (Integer v : months.values()) {
            System.out.print(v + " ");

        }
    }

    private static void iterateMonthsNames(Map<String, Integer> months) {
        System.out.println("=============key iterate========");
        for (String name : months.keySet()) {
            System.out.print(name+ " ");
            System.out.println();

        }
    }

    private static void iterateEntries(Map<String, Integer> months) {
        System.out.println("=============Entry iterate========");
        for (Map.Entry<String, Integer> entry : months.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("Entry " + entry +
                    " key  "+ key + " value " + value);
            System.out.print("Entry " + entry + " " + key + " => " + value);
            System.out.println();

        };
    }

    private static void fillMap(Map<String, Integer> months) {
        months.put("jan", 1);
        months.put("feb", 2);
        months.put("mar", 3);
        months.put("apr", 4);



    }
}
