import java.util.*;

public class SymmetricDifference {

    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2=new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(6);

        // making copy so original not change
        Set<Integer> result =new HashSet<> (set1);

        // removing common elements
        result.removeAll(set2);

        Set<Integer> temp =new HashSet<> (set2);
        temp.removeAll(set1);

        result.addAll(temp);

        System.out.println("symmetric differencess : " + result);
    }
}