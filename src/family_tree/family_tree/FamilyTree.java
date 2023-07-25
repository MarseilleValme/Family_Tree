package family_tree.family_tree;

import family_tree.human.Human;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private long humansId;
    private List<Human> humans;

    public FamilyTree(List<Human> humans){
        this.humans = humans;
    }

    public FamilyTree(){
        this(new ArrayList<>());
    }
    public boolean add(Human human){

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

    private void addToParents(Human human){
        for (Human parent: human.getParents())
            parent.addChild(human);
    }

    private void addToChildren(Human human){
        for (Human child: human.getChildren())
            child.addParent(human);
    }

//    public List<Human> getSiblings(int id){
//        Human human = getById(id);
//        if (human == null) return  null;
//
//        List<Human> res = new ArrayList<>();
//        for (Human parent: human.getParents())
//            for (Human child: parent.getChildren())
//                if (!child.equals(human))
//                    res.add(child);
//        return res;
//    }

    public Human getById (long id){
        for (Human human: humans)
            if (human.getId() == id)
                return human;
        return null;
    }

//    public List<Human> getByName(String name){
//        List<Human> res = new ArrayList<>();
//        for (Human human: humans)
//            if (human.getName().equalsIgnoreCase(name))
//                res.add(human);
//        return res;
//    }

    public boolean setWedding(long id1, long id2){
        if (checkId(id1) && checkId(id2)){
            Human human1 = getById(id1);
            Human human2 = getById(id2);
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
            Human human1 = getById(id1);
            Human human2 = getById(id2);
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
            Human e = getById(humansId);
            return humans.remove(e);
        }

        return false;
    }


    public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("В дереве ");
        stringBuilder.append(humans.size());
        stringBuilder.append(" объектов: \n");
        for (Human human: humans){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() { return getInfo(); }

}

