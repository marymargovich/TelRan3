package telran.collection;

import java.util.*;

public class CollectionsAppl {
    public static void main(String[] args) {


        List<String> list1 = Arrays.asList("HTML", "CSS",
                "Javascript", "Typescript", "React", "Redux", "Bootstrap",
                "Material UI");
        String[] str = {"HTML", "CSS", "Javascript",
                "Typescript", "React", "Redux", "Bootstrap", "Material UI"};

        List<String> list2 = List.of(str);
        List<String> list3 = Arrays.asList(str);

        Collections.sort(list1);
        System.out.println(list1);

        Arrays.sort(str);
        System.out.println(Arrays.toString(str));

//        Collections.sort(listNew, (s1, s2)->
//                Integer.compare(s1.length(), s2.length()));
//        System.out.println(listNew);

        System.out.println(Collections.binarySearch(list1, "J"));

//        Collections.fill(listNew, "Java");
//        System.out.println(listNew);
//        //Collections.fill(list2, "Java"); нельзя
//
//        Collections.fill(list3, "Java");
        System.out.println(list3);
       // Collections.sort(list2);
        Collections.sort(list3);
        System.out.println(list3);

        System.out.println("===================SHUFFLE");
        Collections.shuffle(list1);
        System.out.println(list1);
        Random r = new Random(123);
        Collections.shuffle(list1, r);
        System.out.println(list1);
        // next = (a* current + c) % m



        System.out.println("==============Collections ");
        String  min = Collections.min(list1);
        String  max = Collections.max(list1);
        System.out.println("min: "+ min + " max: "+ max);

        min = Collections.min(list1, (s1, s2)->  Integer.compare(s1.length(), s2.length()));
        max = Collections.max(list1, (s1, s2)->  Integer.compare(s1.length(), s2.length()));



        System.out.println("min: "+ min + " max: "+ max);


        System.out.println("=============frequency");
        List<String> listFrequency = Arrays.asList("HTML", "CSS", "Javascript", "Typescript", "React", "Redux", "Bootstrap",
                "Material UI", "HTML", "CSS", "HTML");
        int count = Collections.frequency(listFrequency, "CSS");
        System.out.println(count);

        Collections.replaceAll(listFrequency, "HTML", "HTML5");
        System.out.println(list2);


        System.out.println("=========rotate");
        List<String> listNew = Arrays.asList("HTML", "CSS", "Javascript", "Typescript", "React", "Redux", "Bootstrap",
                "Material UI", "HTML", "CSS", "HTML");
        Collections.rotate(listNew, 3);
        System.out.println(listNew);

        System.out.println("===========reverse");
        List<String> listReverse = Arrays.asList("HTML", "CSS", "Javascript", "Typescript", "React", "Redux", "Bootstrap",
                "Material UI", "HTML", "CSS", "HTML");
        Collections.reverse(listReverse);
        System.out.println(listReverse);
        Collections.reverse(listReverse);

        List<String> listNew1 = Arrays.asList("C", "C++");
        System.out.println(Collections.disjoint(list1, listNew1));
        Collections.emptyList();











    }

}
