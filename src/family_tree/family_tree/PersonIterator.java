package family_tree.family_tree;
import java.util.Iterator;
import java.util.List;
public class PersonIterator<E> implements Iterator<E>{
    private int index;
    private List<E> personList;

    public PersonIterator(List<E> personList) {
        this.personList = personList;
    }

    @Override
    public boolean hasNext() {
        return personList.size() > index;
    }

    @Override
    public E next() {
        return personList.get(index++);
    }
}
