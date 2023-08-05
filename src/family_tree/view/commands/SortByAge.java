package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SortByAge extends Command {
    public SortByAge(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать древо по возрасту";
    }

    public void execute(){
        consoleUI.sortByAge();
    }
}
