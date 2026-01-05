import java.util.*;

public class UnionIntersection {

    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(6);

        // union logic
        Set<Integer> unions=new HashSet<>(set1);
        unions.addAll(set2);

        // intersection logic
        Set<Integer> intersections=new HashSet<>(set1);
        intersections.retainAll(set2);

        System.out.println("union:" + unions);
        System.out.println("intersection:" + intersections );
    }
}