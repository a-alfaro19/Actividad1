package ed;

/**
 * Represents a node in a singly linked list.
 *
 * @param <T> the type of data stored in the node
 */
public class Node<T> {
    /**
     * The data stored in the node.
     */
    public T data;
    /**
     * Reference to the next node in the linked list.
     */
    public Node<T> next;

    /**
     * Constructs a new node with the given data.
     *
     * @param data the data to be stored in the node
     */
    public Node(T data) {
        this.data = data;
        next = null;
    }

}
