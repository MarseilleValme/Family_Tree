package family_tree;

import family_tree.human.Human;
import family_tree.family_tree.FamilyTree;
import family_tree.human.Gender;
import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {

        FamilyTree tree = Tree();
        System.out.println(tree);
    }

    static FamilyTree Tree() {
        FamilyTree tree = new FamilyTree();

        Human oleg = new Human("Олег", LocalDate.of(1944, 2, 23), Gender.Male);
        Human ludmila = new Human("Людмила", LocalDate.of(1941, 5, 1), Gender.Female);
        Human philipp = new Human("Филипп Олегович", LocalDate.of(1968, 10, 10), Gender.Male, ludmila, oleg);
        Human oksana = new Human("Оксана Олеговна", LocalDate.of(1967, 11, 7), Gender.Female);
        Human john = new Human("Иван Филиппович", LocalDate.of(1990, 10, 30), Gender.Male);
        Human elizabeth = new Human("Елизавета Филипповна", LocalDate.of(1995, 5, 1), Gender.Female);

        tree.add(oleg);
        tree.add(ludmila);
        tree.add(philipp);
        tree.add(oksana);
        tree.add(john);
        tree.add(elizabeth);

        oleg.setSpouse(ludmila);
        ludmila.setSpouse(oleg);

        tree.setWedding(philipp.getId(), oksana.getId());

        philipp.addChild(john);
        philipp.addChild(elizabeth);
        oksana.addChild(john);
        oksana.addChild(elizabeth);

        john.addParent(philipp);
        john.addParent(oksana);
        elizabeth.addParent(philipp);
        elizabeth.addParent(oksana);

        return tree;
    }
}

