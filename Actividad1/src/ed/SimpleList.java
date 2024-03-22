package ed;

import ed.iterator.Aggregate;
import ed.iterator.Iterator;

import java.util.NoSuchElementException;

/**
 * Represents a simple singly linked list.
 *
 * @param <T> the type of elements stored in the list
 */
public class SimpleList<T> implements Aggregate<T> {
    private Node<T> head;
    private int size;

    /**
     * Represents an iterator for traversing the elements of the list.
     */
    private class SimpleListIterator implements Iterator<T> {
        private Node<T> current;

        public SimpleListIterator(Node<T> head) {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Node<T> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Node<T> currentNode = current;
            current = current.next;
            return currentNode;
        }
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    private boolean isEmpty() {
        return head == null;
    }

    /**
     * Inserts a new node with the given data at the end of the list.
     *
     * @param data the data to be inserted
     */
    public void insert(T data) {
        Node<T> newNode =  new Node<T>(data);
        if (isEmpty()) {
            head = newNode;

        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;

        }
        size++;

    }

    /**
     * Inserts a new node with the given data at the beginning of the list.
     *
     * @param data the data to be inserted
     */
    private void insertFirst(T data) {
        Node<T> newNode =  new Node<T>(data);
        if (!isEmpty()) {
            newNode.next = head;
        }
        head = newNode;
        size++;
    }

    @Override
    public Iterator<T> createIterator() {
        return new SimpleListIterator(head);
    }

    /**
     * Inserts all elements from the given list into this list.
     *
     * @param list the list from which elements are to be inserted
     */
    public void insertList(SimpleList<T> list) {
        Iterator<T> iterator = list.createIterator();

        while (iterator.hasNext()) {
            insert(iterator.next().data);
        }

    }

    /**
     * Returns a sublist of this list from the specified start index (inclusive)
     * to the specified end index (exclusive).
     *
     * @param start the start index of the sublist (inclusive)
     * @param end   the end index of the sublist (exclusive)
     * @return the sublist
     * @throws IndexOutOfBoundsException if the start or end index is out of bounds
     */
    public SimpleList<T> subList(int start, int end) {
        if (start < size && end < size) {
            SimpleList<T> subList = new SimpleList<>();
            Iterator<T> iterator = createIterator();

            int currentIndex = 0;
            while (iterator.hasNext()) {
                if (currentIndex >= start && currentIndex < end) {
                    subList.insert(iterator.next().data);
                } else if (currentIndex == end) {
                    break;
                }
                currentIndex++;
            }
            return subList;

        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Returns a new list that is a reversed version of the given list.
     *
     * @param list the list to be reversed
     * @return the reversed list
     */
    public SimpleList<T> invertList(SimpleList<T> list) {
        if (list.isEmpty()) {
            return list;
        } else {
            SimpleList<T> newList = new SimpleList<>();
            Iterator<T> iterator = createIterator();
            while (iterator.hasNext()) {
                newList.insertFirst(iterator.next().data);
            }
            return newList;
        }
    }

}
