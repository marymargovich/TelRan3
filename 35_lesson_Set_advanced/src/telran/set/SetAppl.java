package telran.set;

import java.util.*;

public class SetAppl {
    public static void main(String[] args) {


        Set<Integer> set1 = new HashSet<>();
        set1.add(5);
        set1.add(6);
        set1.add(1);
        set1.add(9);
        set1.add(10);
        set1.add(3);
        System.out.println(set1);
        Set<Integer> set2 = new HashSet<>();
        set2.add(5);
        set2.add(6);
        set2.add(1);
        set2.add(9);
        set2.add(10);
        set2.add(3);
        System.out.println(set2);
        Integer[] numbers = {100, 400, 100, 5, 4, 1001, 9, 9, 400, 4, 5, 120};
        List<Integer> list1 = Arrays.asList(numbers);
        List<Integer> listLinked = removeDuplicatesLinked(list1);
        List<Integer> listArrayList = removeDuplicate(list1);
        System.out.println(" Linked HashSet============\n"+ listLinked);
        System.out.println(" Array List============\n"+ listArrayList);


    }

    private static List<Integer> removeDuplicate(List<Integer> list) {
        List<Integer> listResult = new ArrayList<>();
        for (int i = 0; i <list.size() ; i++) {
            if (!listResult.contains(list.get(i))){
                listResult.add(list.get(i));
            }
        }
        return listResult;


    }
    private static List<Integer> removeDuplicatesLinked(List <Integer> list){
        return new ArrayList<>(new LinkedHashSet<>(list));
    }

}
