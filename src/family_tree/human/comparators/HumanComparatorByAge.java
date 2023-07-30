package family_tree.human.comparators;
import family_tree.family_tree.PersonIterator;
import family_tree.family_tree.TreeItem;
import family_tree.human.Human;
import java.util.Comparator;
public class HumanComparatorByAge<E extends TreeItem> implements Comparator<E>{
    @Override
    public int compare(E o1, E o2) {
        return o1.getAge() - o2.getAge();
    }
}
