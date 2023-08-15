package family_tree.model.service;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.Gender;
import family_tree.model.human.Human;

import java.time.LocalDate;

public class Service {
    private long id;
    private Writable fileHandler = new FileHandler();
    private FamilyTree<Human> tree;

    public Service(){
    }

    public void addHuman(String name, LocalDate dateOfBirth, String pol){
        Gender gender;
        if (pol.equalsIgnoreCase("Male"))
            gender = Gender.Male;
        else gender = Gender.Female;
        Human human = new Human(name, dateOfBirth, null, gender, null, null, null);
        tree.add(human);
    }
    public void sortByName(){ tree.sortByName(); }

    public void sortByAge(){ tree.sortByAge(); }
    public void sortById(){ tree.sortById(); }
    public void remove(long id){ tree.remove(id); }

    public void setWedding(long id1, long id2){  tree.setWedding(id1, id2);  }

    public void setDivorce(long id1, long id2){  tree.setDivorce(id1, id2);  }

    public void addParent(long id1, long id2){
            Human child = tree.getById(id1);
            Human parent = tree.getById(id2);
        child.addParent(parent);
    }

    public void addChild(long id1, long id2){
        Human parent = tree.getById(id1);
        Human child = tree.getById(id2);
        parent.addChild(child);
    }

    public String getTreeInfo(){ return tree.getInfo(); }
    public void load(){
        tree = (FamilyTree) fileHandler.load();
//        if (tree == null) tree = Tree();
    }

    public void save(){
//        fileHandler.save(tree);
        if (fileHandler.save(tree)) System.out.println("Файл успешно сохранён");
    }

    //—————————————————————————————————КОСТЫЛЬ ДЛЯ ОТЛАДКИ—————————————————————————————————————————
//    static FamilyTree Tree() {
//        FamilyTree tree = new FamilyTree();
//
//        Human oleg = new Human("Янковский Олег Иванович", LocalDate.of(1944, 2, 23), Gender.Male);
//        Human ludmila = new Human("Янковская Зорина Людмила Александровна", LocalDate.of(1941, 5, 1), Gender.Female);
//        Human philipp = new Human("Янковский Филипп Олегович", LocalDate.of(1968, 10, 10), Gender.Male, ludmila, oleg);
//        Human oksana = new Human("Фандера Оксана Олеговна", LocalDate.of(1967, 11, 7), Gender.Female);
//        Human john = new Human("Янковский Иван Филиппович", LocalDate.of(1990, 10, 30), Gender.Male);
//        Human elizabeth = new Human("Янковская Елизавета Филипповна", LocalDate.of(1995, 5, 1), Gender.Female);
//
//        tree.add(oleg);
//        tree.add(ludmila);
//        tree.add(philipp);
//        tree.add(oksana);
//        tree.add(john);
//        tree.add(elizabeth);
//
//        oleg.setSpouse(ludmila);
//        ludmila.setSpouse(oleg);
//
//        tree.setWedding(philipp.getId(), oksana.getId());
//
//        philipp.addChild(john);
//        philipp.addChild(elizabeth);
//        oksana.addChild(john);
//        oksana.addChild(elizabeth);
//
//        john.addParent(philipp);
//        john.addParent(oksana);
//        elizabeth.addParent(philipp);
//        elizabeth.addParent(oksana);
//        oleg.setDateOfDeath(LocalDate.of(2009, 5, 20));
//
//        return tree;
//    }
}