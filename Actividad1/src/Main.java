import ed.SimpleList;
import ed.iterator.Iterator;

public class Main {
    public static void main(String[] args) {
        SimpleList<Integer> list = new SimpleList<>();
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        SimpleList<Integer> list2 = list.invertList(list);

        Iterator<Integer> iterator = list2.createIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next().data);
        }
    }
}