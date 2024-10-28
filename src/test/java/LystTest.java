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
    void ForwardIterator()
    {
        Lyst<Integer> list = new Lyst<>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        Lyst<Integer>.ForwardLystIterator iterator = list.new ForwardLystIterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext())
        {
            sb.append(iterator.next());
        }
        assertEquals("123", sb.toString());
    }

    @Test
    void BackwardIterator()
    {
        Lyst<Integer> list = new Lyst<>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        Lyst<Integer>.BackwardLystIterator iterator = list.new BackwardLystIterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasPrev())
        {
            sb.append(iterator.prev());
        }
        assertEquals("321", sb.toString());
    }

    @Test
    void contains()
    {
        Lyst<Integer> lyst = new Lyst<>();
        lyst.addFirst(1);
        lyst.addLast(2);
        lyst.addLast(3);
        assertEquals(true, lyst.contains(2));
    }

    @Test
    void remove()
    {
        Lyst<Integer> lyst = new Lyst<>();
        lyst.addFirst(1);
        lyst.addLast(2);
        lyst.addLast(3);
        lyst.remove(2);
        assertEquals("->1<->3->", lyst.toString());
    }

    @Test
    void removeFirstWithRemove()
    {
        Lyst<Integer> lyst = new Lyst<>();
        lyst.addFirst(1);
        lyst.addLast(2);
        lyst.addLast(3);
        lyst.remove(1);
        assertEquals("->2<->3->", lyst.toString());
    }

    @Test
    void removeLastWithRemove()
    {
        Lyst<Integer> lyst = new Lyst<>();
        lyst.addFirst(1);
        lyst.addLast(2);
        lyst.addLast(3);
        lyst.remove(3);
        assertEquals("->1<->2->", lyst.toString());
    }

    @Test
    void removeFirst()
    {
        Lyst<Integer> lyst = new Lyst<>();
        lyst.addFirst(1);
        lyst.addLast(2);
        lyst.addLast(3);
        lyst.removeFirst();
        assertEquals("->2<->3->", lyst.toString());
    }

    @Test
    void removeLast()
    {
        Lyst<Integer> lyst = new Lyst<>();
        lyst.addFirst(1);
        lyst.addLast(2);
        lyst.addLast(3);
        lyst.removeLast();
        assertEquals("->1<->2->", lyst.toString());
    }

}