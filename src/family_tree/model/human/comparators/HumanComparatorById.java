package family_tree.model.human.comparators;
import family_tree.model.family_tree.TreeItem;

import java.util.Comparator;

public class HumanComparatorById<E extends TreeItem> implements Comparator<E>{
    @Override
    public int compare(E o1, E o2) {
        return (int)(o1.getId() - o2.getId());
    }
}