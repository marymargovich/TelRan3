package telran.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListAppl {
    //Хранить дубликаты.
    // Хранят в порядке добавления
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
       // List <String> list = new LinkedList<>();

        list.add("HTML");
        list.add("CSS");
        list.add("Javascript");
        list.add("Typescript");
        list.add("React");
        list.add("Redux");
        list.add("Bootstrap");
        list.add("Material UI");
        System.out.println(list);
        list.remove("Javascript");
        System.out.println(list);
        list.add(2, "Javascript");
        System.out.println(list);
        list.add(8,"Javascript");
        System.out.println(list);

        System.out.println();

        list.forEach(t -> System.out.println(t+ " "));
        String s1 = list.set(2, "Java");
        System.out.println(list);
        System.out.println(s1);

        List<String> list1 = Arrays.asList("HTML", "CSS", "Javascript", "Typescript",
                "React", "Redux", "Bootstrap", "Material UI");
        System.out.println(list1);

        String s2 = list1.set(2, "Java");
        System.out.println(list1);
        System.out.println(s2);

        String[]str = {"HTML", "Typescript",
                "React", "Redux", "Bootstrap", "Material UI"};
        List<String > list2 = Arrays.asList(str);
        System.out.println(list2);

        String s3 = list2.set(2, "Java");
        System.out.println(list2);
        System.out.println(s3);


        System.out.println(Arrays.toString(str));


        System.out.println("___________________________");

        List<String> list3 = List.of("HTML", "Typescript",
                "React", "Redux", "Bootstrap", "Material UI");

        //list3.add("HTML"); - нельзя!

        //String s4 = list3.set(2, "Java"); - нельзя
        //неизменяемые листы


        List <String> list4 = List.of(str);
        System.out.println(list.get(3));
        str[0] = "HTML5";

        System.out.println(list2);
        System.out.println(list4);


        StringBuilder sb = new StringBuilder("HTML");
        List<StringBuilder> l1 = List.of(sb);
        System.out.println(l1);
        sb.append(5);
        System.out.println(l1);
        //неизменяемы списки
        System.out.println("++++++++++++++++++++++++++");
        list4 = new ArrayList<>(list4);
        list4.add("HTML");
        list4.set(3, "Node.js");
        System.out.println(list4);

        System.out.println("+++++++++++++++++");
        System.out.println(sum(2,5, 4));
        System.out.println(sum(2,5, 4, 5,5,5,6,7));


    }

    public static int sum (int a, int b, int ... rest){
        int res = a+b;
        for (int i = 0; i < rest.length; i++) {
            res+= rest[i];
        }
        return res;
    }
}
