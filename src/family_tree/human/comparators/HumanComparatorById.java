package family_tree.human.comparators;
import family_tree.family_tree.TreeItem;
import family_tree.human.Human;
import java.util.Comparator;

public class HumanComparatorById<E extends TreeItem> implements Comparator<E>{
    @Override
    public int compare(E o1, E o2) {
        return (int)(o1.getId() - o2.getId());
    }
}