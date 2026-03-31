import java.util.*;

public class RotateList {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(15);
        list.add(20);
        list.add(25);
        list.add(30);
        list.add(40);

        int rotateBy = 2;

        System.out.println("original list: "+list);
        rotatelist(list, rotateBy);
        System.out.println("rotated list:"+list);
    }

    // rotating list without using collections rotate
    static void rotatelist(ArrayList<Integer> list, int rot) {

        int n = list.size();
        rot = rot % n;   // handle large rotation

        ArrayList<Integer> temp=new ArrayList<>();

        // add from rot to end
        for (int i = rot; i < n; i++) 
            {
            temp.add(list.get(i));
        }

        // add from start to rot
        for (int i = 0; i < rot; i++) 
            {
            temp.add(list.get(i));
        }

        // copy back to original list
        for (int i = 0; i < n; i++)
             {
            list.set(i, temp.get(i) );
        }
    }
}