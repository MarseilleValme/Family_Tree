package family_tree.family_tree;

import java.util.List;

public interface TreeItem<E> {
    long getId();
    String getName();
    int getAge();
    List<E> getParents();
    List<E> getChildren();
    E getSpouse();
    boolean addChild(E human);
    boolean addParent(E human);
    void setId(long l);
    void setSpouse(E human);
}
