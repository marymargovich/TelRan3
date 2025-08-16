import java.util.*;

public class Collections {

    static final int N = 10_000;
    static final int CONTAINS = 10_000;
    static final int REMOVE = 1000;

    public static void main(String[] args) {
        int[] values = fillArrow(N);
        int [] containsArr = fillArrayForContains(values,CONTAINS);
        int [] removeArr = fillArrRemoveExists(values, REMOVE);
        int [] removeArrNorExists = fillArrRemoveNotExists(values, REMOVE);



        System.out.println("=============ADD================");
        add_ArrayList(values);
        add_LinkedList(values);
        add_HashSet(values);
        add_LinkedHashSet(values);
        add_TreeSet(values);
        System.out.println("=============CONTAINS================");
        contains_ArrayList(values, containsArr );
        contains_LinkedList(values, containsArr);
        contains_HashSet(values, containsArr);
        contains_LinkedHashSet(values, containsArr);
        contains_TreeSet(values,containsArr);
        System.out.println("=============Remove================");
        remove_ArrayList(values,removeArr );
        remove_LinkedList(values,removeArr);
        remove_HashSet(values, removeArr);
        remove_LinkedHashSet(values, removeArr);
        remove_TreeSet(values, removeArr);
        System.out.println("=============RemoveNotExists================");
        remove_ArrayList(values,removeArrNorExists );
        remove_LinkedList(values,removeArrNorExists);
        remove_HashSet(values, removeArrNorExists);
        remove_LinkedHashSet(values, removeArrNorExists);
        remove_TreeSet(values, removeArrNorExists);
        System.out.println("=============Iterate forEach================");
        iterate_ArrayList(values);
        iterate_LinkedList(values);
        iterate_HashSet(values);
        iterate_LinkedHashSet(values);
        iterate_TreeSet(values);



    }

    private static void iterate_TreeSet(int[] values) {
        Set<Integer> set = new TreeSet<>();

        for (int i : values) set.add(i);
        long sum = 0;
        long start = System.nanoTime();
        for (int i : set) sum+=i;
        long end = System.nanoTime();
        System.out.println("time for iterate TreeSet= " + (end - start)/100 + " ms and sum is " + sum);

    }

    private static void iterate_LinkedHashSet(int[] values) {
        Set<Integer> set = new LinkedHashSet<>();

        for (int i : values) set.add(i);
        long sum = 0;
        long start = System.nanoTime();
        for (int i : set) sum+=i;
        long end = System.nanoTime();
        System.out.println("time for iterate LinkedHasSet= " + (end - start)/100 + " ms and sum is " + sum);

    }

    private static void iterate_HashSet(int[] values) {
        Set<Integer> set = new HashSet<>();

        for (int i : values) set.add(i);
        long sum = 0;
        long start = System.nanoTime();
        for (int i : set) sum+=i;
        long end = System.nanoTime();
        System.out.println("time for iterate HashSet= " + (end - start)/100 + " ms and sum is " + sum);
    }

    private static void iterate_ArrayList(int[] values) {
        List<Integer> list = new ArrayList<>();

        for (int i : values) list.add(i);
        long sum = 0;
        long start = System.nanoTime();
        for (int i : list) sum+=i;
        long end = System.nanoTime();
        System.out.println("time for iterate ArraList= " + (end - start)/100 + " ms and sum is " + sum);
    }

    private static void iterate_LinkedList(int[] values) {
        List<Integer> list = new LinkedList<>();

        for (int i : values) list.add(i);
        long sum = 0;
        long start = System.nanoTime();
        for (int i : list) sum+=i;
        long end = System.nanoTime();
        System.out.println("time for iterate LinkedList= " + (end - start)/100 + " ms and sum is " + sum);
    }

    private static void remove_TreeSet(int[] values, int[] removeArr) {
        Set<Integer> set = new TreeSet<>();
        for (int i : values)
            set. add (i);
        long start = System.nanoTime();
        int count = 0;
        for (int i : removeArr)
            if(set.remove (i))
                count++;
        long end = System.nanoTime();
        System.out.println("Time for remove in TreeSet is "
                + (end - start) /100 + " mc" + " we removed "+count);

    }

    private static void remove_LinkedHashSet(int[] values, int[] removeArr) {
        Set<Integer> set = new LinkedHashSet<>(N);
        for (int i : values)
            set. add (i);
        long start = System.nanoTime();
        int count = 0;
        for (int i : removeArr)
            if(set.remove (i))
                count++;
        long end = System.nanoTime();
        System.out.println("Time for remove in LinkedHasSet is "
                + (end - start) /100 + " mc" + " we removed "+count);

    }

    private static void remove_HashSet(int[] values, int[] removeArr) {
        Set<Integer> set = new HashSet<>(N);
        for (int i : values)
            set. add (i);
        long start = System.nanoTime();
        int count = 0;
        for (int i : removeArr)
            if(set.remove (i))
                count++;
        long end = System.nanoTime();
        System.out.println("Time for remove in HashSet is "
                + (end - start) /100 + " mc" + " we removed "+count);

    }

    private static void remove_LinkedList(int[] values, int[] removeArr) {
        List<Integer> list = new LinkedList<>();
        for (int i : values)
            list. add (i);
        long start = System.nanoTime();
        int count = 0;
        for (int i : removeArr)
            if(list.remove ((Integer)i))
                count++;
        long end = System.nanoTime();
        System.out.println("Time for remove in LinkedList is "
                + (end - start) /100 + " mc" + " we removed "+count);

    }

    private static void remove_ArrayList(int[] values, int[] removeArr) {
        List<Integer> list = new ArrayList<>(N);
        for (int i : values)
            list. add (i);
        long start = System.nanoTime();
        int count = 0;
        for (int i : removeArr)
            if(list.remove ((Integer)i))
                count++;
        long end = System.nanoTime();
        System.out.println("Time for remove in ArrayList is "
                + (end - start) /100 + " mc" + " we removed "+count);

    }

    private static int[] fillArrRemoveNotExists(int[] values, int remove) {
        Random r = new Random();
        int [] ar = new int[remove];
        for (int i = 0; i < ar.length; i++)
            ar[i]= r.nextInt(100_000, 200_000);
        return ar;
    }


    private static int[] fillArrRemoveExists(int[] values, int remove) {
        Random r = new Random();
        int [] ar = new int[remove];
        for (int i = 0; i < ar.length; i++)
            ar[i]=values[r.nextInt(values.length)];
        return ar;
    }

    private static void contains_TreeSet(int[] values, int[] containsArr) {
        Set<Integer> set = new TreeSet<>();
        for (int i : values)
            set. add (i);
        long start = System.nanoTime();
        int count = 0;
        for (int i : containsArr) if(set.contains (i)) count++;
        long end = System.nanoTime();
        System.out.println("Time for contains in TreeSet is "
                + (end - start) /100 + " mc" + " we found "+count);


    }

    private static void contains_LinkedHashSet(int[] values, int[] containsArr) {
        Set<Integer> set = new LinkedHashSet<>(N);
        for (int i : values)
            set. add (i);
        long start = System.nanoTime();
        int count = 0;
        for (int i : containsArr) if(set.contains (i)) count++;
        long end = System.nanoTime();
        System.out.println("Time for contains in LinkedHashSet is "
                + (end - start) /100 + " mc" + " we found "+count);

    }

    private static void contains_HashSet(int[] values, int[] containsArr) {
        Set<Integer> set = new HashSet<>(N);
        for (int i : values)
            set. add (i);
        long start = System.nanoTime();
        int count = 0;
        for (int i : containsArr) if(set.contains (i)) count++;
        long end = System.nanoTime();
        System.out.println("Time for contains in HashSet is "
                + (end - start) /100 + " mc" + " we found "+count);


    }

    private static void contains_LinkedList(int[] values, int[]
            containsArr) {
        List<Integer> list = new LinkedList<>();
        for (int i : values)
            list. add (i);
        long start = System.nanoTime();
        int count = 0;
        for (int i : containsArr) if(list.contains (i)) count++;
        long end = System.nanoTime();
        System.out.println("Time for contains in linked list is "
                + (end - start) /100 + " mc" + " we found "+count);

    }

    private static void contains_ArrayList(int[] values, int[] containsArr) {
        List< Integer> list = new ArrayList<>(N);
        for (int i : values)
            list.add (i);
        long start = System.nanoTime();
        int count = 0;
        for (int i : containsArr) if(list.contains(i)) count++;
        long end = System.nanoTime();
        System.out.println("Time for contains in array list is " + (end - start) / 100 + " mc" + " we found "+ count);

    }



    private static int[] fillArrayForContains(int[] values,
                                              int contains) {
        Random r = new Random();
        int [] ar = new int[contains];
        int half = contains/2;
        for (int i = 0; i < half; i++) ar[i]=values[r.nextInt(values.length)]; for (int i = half; i < ar.length; i++) ar[i] = r.nextInt (100_000,200_000);
        return ar;
    }

    private static void   add_TreeSet(int[] values) {
        Set<Integer> set = new TreeSet<>();
        long start = System.nanoTime();
        for (int i : values) set.add(i);
        long end = System.nanoTime();
        System.out.println("Add to TreeSet time = " + (end - start)/100 + " ms");
    }

    private static void  add_LinkedHashSet(int[] values) {
        Set<Integer> set = new LinkedHashSet<>(N);
        long start = System.nanoTime();
        for (int i : values) set.add(i);
        long end = System.nanoTime();
        System.out.println("Add to LinkedHashSet time = " + (end - start)/100 + " ms");
    }

    private static void  add_HashSet(int[] values) {
        Set<Integer> set = new HashSet<>(N);
        long start = System.nanoTime();
        for (int i : values) set.add(i);
        long end = System.nanoTime();
        System.out.println("Add to HashSet time = " + (end - start)/100 + " ms");
    }

    private static void  add_LinkedList(int[] values) {
        List<Integer> list = new LinkedList<>();
        long start = System.nanoTime();
        for (int i : values) list.add(i);
        long end = System.nanoTime();
        System.out.println("Add to LinkedList time = " + (end - start)/100 + " ms");
    }

    private static void add_ArrayList(int[] values) {
        List<Integer> list = new ArrayList<>(N);
        long start = System.nanoTime();
        for (int i : values) list.add(i);
        long end = System.nanoTime();
        System.out.println("Add ArrayList time = " + (end - start)/100 + " ms");
    }

    private static int[] fillArrow(int n) {
        int[] ar = new int[n];
        Random r = new Random();
        for (int i = 0; i < ar.length; i++) {
            ar[i] = r.nextInt(0, 100_000)             ;

        }
        return ar;
    }
}


