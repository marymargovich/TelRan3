package telran.list.performance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListPerformanceTest {
    public static void main(String[] args) {
        int size = 100_000;
        int middleIndex = size/2;
        int searchValue = middleIndex;


        List<Integer> arrayList = new ArrayList<>();
        List <Integer> linkedList = new LinkedList<>();


        for (int i = 1; i <= size; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        //=======================Insert to start

        testAddAtIndex(arrayList, 0, 999999, "array");
        testAddAtIndex(linkedList, 0, 999999, "linked");

        //=======================Insert to center

        testAddAtIndex(arrayList, middleIndex, 999999, "array");
        testAddAtIndex(linkedList, middleIndex, 999999, "linked");

        //=======================Insert to end

        testAddAtIndex(arrayList, size, 999999, "array");
        testAddAtIndex(linkedList, size, 999999, "linked");

        //=======================Insert bulk to start

        testInsertBulkAtIndex(arrayList, 0, 10_000, "array", true);
        testInsertBulkAtIndex(linkedList, 0, 10_000, "linked", false);

        //=======================Insert bulk to center

        testInsertBulkAtIndex(arrayList, middleIndex, 999999, "array", true);
        testInsertBulkAtIndex(linkedList, middleIndex, 999999, "linked", false);

        //=======================Insert bulk to end

        testInsertBulkAtIndex(arrayList, size, 999999, "array", true);
        testInsertBulkAtIndex(linkedList, size, 999999, "linked", false);





    }

    private static void testAddAtIndex(List<Integer> list, int index, int value, String listName) {
        long start = System.nanoTime();
        list.add(index, value);
        long end = System.nanoTime();
        System.out.println(listName+ " insert by imdex"+ " : "+ (end-start)/1000 + "mc");

    }

    private static void  testInsertBulkAtIndex(List<Integer> list, int index,int count,
                                               String listName, boolean useArrayList ){
        List <Integer> bulk;
        if(useArrayList)
            bulk = new ArrayList<>();
        else
            bulk = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            bulk.add(i);}

        long start = System.nanoTime();
        list.addAll(index, bulk);
        long end = System.nanoTime();
        System.out.println(listName+ " insert by index "+ index+ " group "+ count+ " elements: "+  (end-start)/1000 + "mc");


    }



    }
