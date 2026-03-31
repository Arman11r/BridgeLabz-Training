import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class ListManager {

    public void addElement(List<Integer> list,int element) {
        list.add(element);
    }

    public void removeElement(List<Integer> list,int element) {
        list.remove(Integer.valueOf(element));
    }

    public int getSize(List<Integer> list) {
        return list.size();
    }

    // Test cases for ListManager of junit
    @Test
    void testAddElement() {
        List<Integer> list=new ArrayList<>();
        addElement(list, 10);
        assertTrue(list.contains(10));
    }

    @Test
    void testRemoveElement() {
        List<Integer> list=new ArrayList<>();
        list.add(10);
        removeElement(list, 10 )   ;
        assertFalse(list.contains(10 ) );
    }

    @Test
    void testListSize() {
        List<Integer> list = new ArrayList<>();
        addElement(list, 1);
        addElement(list, 2);
        assertEquals(2, getSize(list ));
    }
}