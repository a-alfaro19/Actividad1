package ed.iterator;

/**
 * An interface representing an aggregate object that can be iterated over.
 *
 * @param <T> the type of elements contained in the aggregate
 */
public interface Aggregate <T> {
    /**
     * Creates an iterator for traversing the elements of the aggregate.
     *
     * @return an iterator over the elements of the aggregate
     */
    Iterator<T> createIterator();
}
