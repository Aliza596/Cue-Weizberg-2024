import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LystTest
{

    @Test
    void addFirst()
    {
        Lyst<Integer> lyst = new Lyst<>();
        assertEquals("->", lyst.toString());
        lyst.addFirst(678);
        assertEquals("->678->", lyst.toString());
        lyst.addFirst(379);
        assertEquals("->379<->678->", lyst.toString());
        assertEquals(379, lyst.getFirst());
        assertEquals(678, lyst.getLast());
    }

    @Test
    void addLast()
    {
        Lyst<Integer> lyst = new Lyst<>();
        assertEquals("->", lyst.toString());
        lyst.addLast(345);
        assertEquals("->345->", lyst.toString());
        lyst.addLast(321);
        assertEquals("->345<->321->", lyst.toString());
        assertEquals(345, lyst.getFirst());
        assertEquals(321, lyst.getLast());
    }

    @Test
    void addAfter()
    {
        Lyst<Integer> lyst = new Lyst<>();
        assertEquals("->", lyst.toString());
        lyst.addFirst(4);
        assertEquals("->4->", lyst.toString());
        lyst.addFirst(3);
        assertEquals("->3<->4->", lyst.toString());
        lyst.addFirst(1);
        assertEquals("->1<->3<->4->", lyst.toString());
        lyst.addAfter(2, 1);
        assertEquals("->1<->2<->3<->4->", lyst.toString());
    }

    @Test
    void addBefore()
    {
        Lyst<Integer> lyst = new Lyst<>();
        assertEquals("->", lyst.toString());
        lyst.addFirst(4);
        assertEquals("->4->", lyst.toString());
        lyst.addFirst(3);
        assertEquals("->3<->4->", lyst.toString());
        lyst.addFirst(1);
        assertEquals("->1<->3<->4->", lyst.toString());
        lyst.addBefore(2, 3);
        assertEquals("->1<->2<->3<->4->", lyst.toString());
    }

    @Test
    void getFirst()
    {
        Lyst<Integer> lyst = new Lyst<>();
        assertEquals("->", lyst.toString());
        lyst.addFirst(4);
        assertEquals("->4->", lyst.toString());
        lyst.addFirst(3);
        assertEquals("->3<->4->", lyst.toString());
        lyst.addFirst(1);
        assertEquals(1, lyst.getFirst());
    }

    @Test
    void getLast()
    {
        Lyst<Integer> lyst = new Lyst<>();
        assertEquals("->", lyst.toString());
        lyst.addFirst(4);
        assertEquals("->4->", lyst.toString());
        lyst.addFirst(3);
        assertEquals("->3<->4->", lyst.toString());
        lyst.addLast(1);
        assertEquals(1, lyst.getLast());
    }

    @Test
    void getNext()
    {
        Lyst<Integer> lyst = new Lyst<>();
        assertEquals("->", lyst.toString());
        lyst.addFirst(4);
        assertEquals("->4->", lyst.toString());
        lyst.addFirst(3);
        assertEquals("->3<->4->", lyst.toString());
        lyst.addFirst(1);
        assertEquals("->1<->3<->4->", lyst.toString());
        lyst.addBefore(2, 3);
        assertEquals("->1<->2<->3<->4->", lyst.toString());
        assertEquals(2, lyst.getNext(1));
    }

    @Test
    void getPrev()
    {
        Lyst<Integer> lyst = new Lyst<>();
        assertEquals("->", lyst.toString());
        lyst.addFirst(4);
        assertEquals("->4->", lyst.toString());
        lyst.addFirst(3);
        assertEquals("->3<->4->", lyst.toString());
        lyst.addFirst(1);
        assertEquals("->1<->3<->4->", lyst.toString());
        lyst.addBefore(2, 3);
        assertEquals("->1<->2<->3<->4->", lyst.toString());
        assertEquals(2, lyst.getPrev(3));
    }

    @Test
    void backwardIterator()
    {
        Lyst<Integer> lyst = new Lyst<>();
        assertEquals("->", lyst.toString());
        lyst.addFirst(4);
        assertEquals("->4->", lyst.toString());
        lyst.addFirst(3);
        assertEquals("->3<->4->", lyst.toString());
        lyst.addFirst(1);
        assertEquals("->1<->3<->4->", lyst.toString());
        lyst.addBefore(2, 3);
        assertEquals("->1<->2<->3<->4->", lyst.toString());
        assertEquals("->4<->3<->2<->1->", lyst.backwardIterator());
    }

}