package deque;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class MaxArrayDequeTest {
    @Test
    public void testInt(){
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        };

        Comparator<Integer> newcomparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        };
        MaxArrayDeque test = new MaxArrayDeque<>(comparator);
        test.addFirst(1);
        test.addFirst(2);
        test.addFirst(3);
        assertTrue(3==(int) test.max());
        assertTrue(1==(int) test.max(newcomparator));
    }
}
