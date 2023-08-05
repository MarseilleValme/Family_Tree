package family_tree;

import family_tree.model.human.Human;
import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.Gender;
import family_tree.model.service.FileHandler;
import family_tree.model.service.Service;
import family_tree.view.ConsoleUI;
import family_tree.view.View;

import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();
//        String filePath = "src/family_tree/model/data/tree.out";
//        FileHandler fileHandler = new FileHandler();
//        FamilyTree tree = (FamilyTree) fileHandler.load(filePath);

//        Service service = new Service();
//        service.load();
//        System.out.println(service.getTreeInfo());

//        String filePath = "src/family_tree/model/data/tree.out";
//        FileHandler fileHandler = new FileHandler();

//        FamilyTree tree = Tree(); // Создать новое древо

//        FamilyTree tree = (FamilyTree) fileHandler.load(filePath); // Загрузить древо из файла
//        if (tree == null) tree = Tree();    // Создать новое древо

//        System.out.println(tree);
//
//        tree.sortByName();
//        System.out.println("Сортировка по ФИО. "+tree);
//
//        tree.sortByAge();
//        System.out.println("Сортировка по возрасту. "+tree);
//
//        tree.sortById();
//        System.out.println("Сортировка по номеру. "+tree);

//        fileHandler.save(tree, filePath); // Сохранить древо в файл
    }

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

