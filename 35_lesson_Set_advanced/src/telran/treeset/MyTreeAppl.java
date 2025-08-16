package telran.treeset;

import java.util.LinkedHashSet;
import java.util.Set;

public class MyTreeAppl {
    public static void main(String[] args) {
        MyTree tree = new MyTree();
        tree.add(10);
        tree.add(15);
        tree.add(2);
        tree.add(19);
        tree.add(25);
        tree.add(39);
        tree.add(1);
        tree.add(4);
        tree.add(11);
        tree.add(16);
        tree.add(20);
        tree.add(7);
        tree.add(0);
        tree.add(17);

        tree.traverse();
        System.out.println("\n" +tree.contains(4));
        System.out.println(tree.contains(3));
//        tree.remove(15);
//        tree.traverse();
//        System.out.println();
//        tree.remove(0);
//        tree.traverse();
//        System.out.println();
//        tree.remove(10);
//        tree.traverse();

        System.out.println("\n==========new Tree");
        tree.traverse();
        System.out.println();
        MyTree newTree = new MyTree();
        newTree = tree.subSet(11,19);
        newTree.traverse();


        System.out.println("\n==========Trim myTree");
        tree.traverse();
        System.out.println();
        tree.trim(2,11);
        tree.traverse();


    }


}
