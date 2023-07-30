package family_tree.family_tree;

import family_tree.human.comparators.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeItem<E>> implements Serializable, Iterable<E> {
    private long humansId;
    private List<E> humans;

    public FamilyTree(List<E> humans){
        this.humans = humans;
    }

    public FamilyTree(){
        this(new ArrayList<>());
    }
    public boolean add(E human){

        if (human == null) return false;

        if (!humans.contains(human)){
            humans.add(human);
            human.setId(humansId++);

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    private void addToParents(E human){
        for (E parent: human.getParents())
            parent.addChild(human);
    }

    private void addToChildren(E human){
        for (E child: human.getChildren())
            child.addParent(human);
    }

//    public List<E> getSiblings(int id){
//        E human = getById(id);
//        if (human == null) return  null;
//
//        List<E> res = new ArrayList<>();
//        for (E parent: human.getParents())
//            for (E child: parent.getChildren())
//                if (!child.equals(human))
//                    res.add(child);
//        return res;
//    }

    public E getById (long id){
        for (E human: humans)
            if (human.getId() == id)
                return human;
        return null;
    }

//    public List<E> getByName(String name){
//        List<E> res = new ArrayList<>();
//        for (E human: humans)
//            if (human.getName().equalsIgnoreCase(name))
//                res.add(human);
//        return res;
//    }

    public boolean setWedding(long id1, long id2){
        if (checkId(id1) && checkId(id2)){
            E human1 = getById(id1);
            E human2 = getById(id2);
            if (human1.getSpouse() == null && human2.getSpouse() == null){
                human1.setSpouse(human2);
                human2.setSpouse(human1);
            }
            else return false;
        }
        return false;
    }

    public boolean setDivorce(long id1, long id2){
        if (checkId(id1) && checkId(id2)){
            E human1 = getById(id1);
            E human2 = getById(id2);
            if (human1.getSpouse() != null && human2.getSpouse() != null){
                human1.setSpouse(null);
                human2.setSpouse(null);
            }
            else return false;
        }
        return false;
    }

    private boolean checkId(long id){ return getById(id) != null;
//        if (id >= humansId || id < 0) return false;
//
////        for (Human human: humans)
////            if (human.getId() == id)
//                return true;
    }

    public boolean remove(long id){
        if (checkId(humansId)){
            E person = getById(humansId);
            return humans.remove(person);
        }

        return false;
    }


    public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("В дереве ");
        stringBuilder.append(humans.size());
        stringBuilder.append(" объектов: \n");
        for (E human: humans){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() { return getInfo(); }
    @Override
    public Iterator<E> iterator() {
        return new PersonIterator<>(humans);
    }
    public void sortByName() {
        humans.sort(new HumanComparatorByName<>());
    }
    public void sortByAge() {
        humans.sort(new HumanComparatorByAge<>());
    }
    public void sortById() {
        humans.sort(new HumanComparatorById<>());
    }
}

