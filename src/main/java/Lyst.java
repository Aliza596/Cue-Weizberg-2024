import java.util.HashMap;
import java.util.HashSet;

/**
 * Lyst - our implementation of a doubly linked list
 *
 * @param <T> generic class with parameter T
 * @author MCON 364
 */
public class Lyst<T> implements ILyst<T>
{
    private class Node<T>
    {
        T value;
        Node<T> prev = null;
        Node<T> next = null;

        public Node(T val)
        {
            value = val;
        }

        @Override
        public String toString()
        {
            return value.toString();
        }
    }

    private Node first = null;
    private Node last = null;

    HashMap<T, Node> elements = new HashMap<>();

    /**
     * addFirst - add a new element to our linked list
     *
     * @param value : T - value to be added as the first node on the list
     */
    @Override
    public void addFirst(T value)
    {
        Node node = new Node(value);
        if (first == null)
        {
            first = last = node;
        } else if (first == last)
        {
            first = node;
            first.next = last;
            last.prev = first;
        } else
        {
            first.prev = node;
            node.next = first;
            first = node;
        }
        elements.put(value, node);
    }

    /**
     * addLast - add an element to the tail of the Lyst
     *
     * @param value : T - value to be added
     */
    @Override
    public void addLast(T value)
    {
        Node node = new Node(value);
        if (first == null)
        {
            addFirst(value);
        } else
        {
            last.next = node;
            node.prev = last;
            last = node;
        }
        elements.put(value, node);
    }

    @Override
    public Boolean contains(T value)
    {
        return elements.containsKey(value);
    }


    public Boolean addBefore(T value, T before)
    {
        boolean found = elements.containsKey(before);
        if (found)
        {
            Node curr = elements.get(before);
            Node node = new Node(value);

            if (curr.prev != null)
            {
                Node previous = curr.prev;
                node.prev = previous;
                previous.next = node;
            } else {
                node.prev = null;
            }
            curr.prev = node;
            node.next = curr;
        }
        return found;
    }


    public Boolean addAfter(T value, T after)
    {
        boolean found = elements.containsKey(after);
        if (found)
        {
            Node curr = elements.get(after);
            Node node = new Node(value);

            if (curr.next != null) {
                Node next = curr.next;
                node.next = next;
                next.prev = node;
            } else {
                node.next = null;
            }
            curr.next = node;
            node.prev = curr;
        }
        return found;
    }

    @Override
    public T getFirst()
    {
        return first == null ? null : (T) first.value;
    }

    @Override
    public T getLast()
    {
        return last == null ? null : (T) last.value;
    }

    @Override
    public T getNext(T value)
    {
        Node curr = elements.get(value);
        Node next = curr.next;
        return next == null ? null : (T) next.value;
    }

    @Override
    public T getPrev(T value)
    {
        Node curr = elements.get(value);
        Node previous = curr.prev;
        return previous == null ? null : (T) previous.value;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder("->");
        Node<T> curr = first;
        while (curr != null)
        {
            sb.append(curr.value.toString());
            sb.append(curr.next == null ? "->" : "<->");
            curr = curr.next;
        }
        return sb.toString();
    }

    public String forwardIterator()
    {
        StringBuilder sb = new StringBuilder("->");
        Node<T> curr = first;
        while (curr != null)
        {
            sb.append(curr.value.toString());
            sb.append(curr.next == null ? "->" : "<->");
            curr = curr.next;
        }
        return sb.toString();
    }

    public String backwardIterator()
    {
        StringBuilder sb = new StringBuilder("->");
        Node<T> curr = last;
        while (curr != null)
        {
            sb.append(curr.value.toString());
            sb.append(curr.prev == null ? "->" : "<->");
            curr = curr.prev;
        }
        return sb.toString();
    }
}
