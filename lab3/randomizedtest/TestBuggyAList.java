package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
  @Test
  public void testThreeAddThreeRemove() {
      AListNoResizing<Integer> a = new AListNoResizing<>();
      BuggyAList<Integer> b = new BuggyAList<>();
      a.addLast(4);
      a.addLast(5);
      a.addLast(6);
      b.addLast(4);
      b.addLast(5);
      b.addLast(6);

      assertEquals(a.removeLast(), b.removeLast());
      assertEquals(a.removeLast(), b.removeLast());
      assertEquals(a.removeLast(), b.removeLast());
  }

  @Test
  public void randomizedTest() {
      AListNoResizing<Integer> L = new AListNoResizing<>();
       BuggyAList<Integer> BL = new BuggyAList<>();

       int N = 50000;
       for (int i = 0; i < N; i += 1) {
           int operationNumber = StdRandom.uniform(0, 3);
           if (operationNumber == 0) {
               // addLast
               int randVal = StdRandom.uniform(0, 100);
               L.addLast(randVal);
               BL.addLast(randVal);
           } else if (operationNumber == 1) {
               // size
               assertEquals(L.size(), BL.size());
           } else {
               if (L.size() > 0) {
                   L.removeLast();
                   BL.removeLast();
               }
           }
       }
  }
}

