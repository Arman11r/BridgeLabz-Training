import java.util.*;

public class SetEquality {

    public static void main(String[] args) {

        Set<Integer> set1= new  HashSet<>();
        set1.add(1) ;
        set1.add(2) ;
        set1.add(3) ;

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(2);
        set2.add(1);

        // checking both sets same or not
        boolean same = set1.equals(set2);

        System.out.println("are sets equals? : " + same);
    }
}