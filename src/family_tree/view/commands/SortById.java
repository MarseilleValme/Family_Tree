package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SortById extends Command {
    public SortById(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать древо по порядку";
    }

    public void execute(){
        consoleUI.sortById();
    }
}
