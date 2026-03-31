import java.util.*;
public class ReverseList{
    public static void main(String[] args) {
        // arraylist example taken
        ArrayList<Integer> arrList = new ArrayList<>();
        arrList.add(1) ;
        arrList.add(2) ;
        arrList.add(3) ;
        arrList.add(4) ;
        arrList.add(5) ;

        System.out.println("original arraylist:"+arrList);
        reverseArrayList(arrList);
        System.out.println("reversed arraylist:"+arrList);

        // linkedlist example
        LinkedList<Integer> linkList = new LinkedList<>();
        linkList.add(1) ;
        linkList.add(2) ;
        linkList.add(3) ;
        linkList.add(4) ;
        linkList.add(5) ;

        System.out.println("original linkedlist:" +linkList);
        reverseLinkedList(linkList);
        System.out.println("reversed linkedlist:" +linkList);
    }

    // reversing arraylist using swapping
    static void reverseArrayList(ArrayList<Integer> list)  {

        int start =0;
        int end = list.size()-1;

        while (start < end){
            int temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp) ;

            start++ ;
            end--;
        }
    }

    // reversing linkedlist using two pointer idea
    static void reverseLinkedList(LinkedList<Integer> list) {

        int start = 0;
        int end = list.size()-1;

        while (start < end){
            int temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++ ;
            end-- ;
        }
    }
}