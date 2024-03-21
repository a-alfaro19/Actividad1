package ed;

public class ListaSimple<T> {
    private Nodo<T> head;
    private int size;
    private static class Nodo<T> {
        T data;
        Nodo<T> next;

        public Nodo(T data) {
            this.data = data;
            next = null;
        }
    }

    private boolean isEmpty() {
        return head == null;
    }

    public void insert(T data) {
        Nodo<T> newNodo =  new Nodo<T>(data);
        if (isEmpty()) {
            head = newNodo;

        } else {
            Nodo<T> aux = head;
            while (aux.next != null) {
                aux = aux.next;
            }
            aux.next = newNodo;

        }
        size++;

    }

    

}
