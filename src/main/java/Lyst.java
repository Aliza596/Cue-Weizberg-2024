import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

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

    /**
     * contains - check if element exists in our linked list
     *
     * @param value : T - value to be checked if it exists in the list
     */
    @Override
    public Boolean contains(T value)
    {
        return elements.containsKey(value);
    }


    /**
     * addFirst - add a new element to our linked list
     *
     * @param value : T - value to be added to the list
     * @param before : T - add the value before this element
     * @return found: whether the value was added or not
     */
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


    /**
     * addAfter - add a new element to our linked list
     *
     * @param value : T - value to be added to the list
     * @param after : T - add the value after this element
     * @return found : boolean - if the value was added to the list
     */
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

    /**
     * getFirst - returns the first value in a list
     *
     * @return value : T - value that is in the first position of the list
     */
    @Override
    public T getFirst()
    {
        return first == null ? null : (T) first.value;
    }


    /**
     * getLast - returns the last value in a list
     *
     * @return value : T - the last value in the list
     */
    @Override
    public T getLast()
    {
        return last == null ? null : (T) last.value;
    }

    /**
     * getNext - returns the next value in the list
     *
     * @param value : T - the value before the one that you want
     * @return value : T - the next value in the list
     */
    @Override
    public T getNext(T value)
    {
        Node curr = elements.get(value);
        Node next = curr.next;
        return next == null ? null : (T) next.value;
    }

    /**
     * getPrev - returns the previous value in the list
     *
     * @param value : T - value in which you want the one before it
     * @return value : T - the previous value in the list
     */
    @Override
    public T getPrev(T value)
    {
        Node curr = elements.get(value);
        Node previous = curr.prev;
        return previous == null ? null : (T) previous.value;
    }

    /**
     * toString - convert the list to a string
     *
     * @return String : the list as a string in order
     */
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

    public class ForwardLystIterator implements Iterator<T>
    {
        public Node<T> node;

        public ForwardLystIterator()
        {
            node = first;
        }

        /**
         * hasNext - checks if there is a next value in the list
         *
         * @return boolean: is there another value
         */
        @Override
        public boolean hasNext() {
            return node != null;
        }

        /**
         * next - returns the next value
         *
         * @return value : T - the next value in the list
         */

        @Override
        public T next() {
            if (node == null)
            {
                return null;
            }
            T val = node.value;
            node = node.next;
            return val;
        }

    }

    public class BackwardLystIterator implements Iterator<T>
    {
        public Node<T> node;

        public BackwardLystIterator()
        {
            node = last;
        }

        /**
         * hasPrev - checks if there is a previous value in the list
         *
         * @return boolean : if there is a previous value
         */
        public boolean hasPrev()
        {
            return hasNext();
        }
        @Override
        public boolean hasNext() {
            return node != null;
        }

        /**
         * prev - returns the previous value in the list
         *
         * @return T : The previous value in the list
         */
        public T prev()
        {
            return next();
        }
        @Override
        public T next() {
            if (node == null)
            {
                return null;
            }
            T val = node.value;
            node = node.prev;
            return val;
        }
    }


}
