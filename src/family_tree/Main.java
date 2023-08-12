package family_tree;

import family_tree.view.ConsoleUI;
import family_tree.view.View;

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

}

