package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class addParent extends Command {
    public addParent(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить предка";
    }

    public void execute(){
        consoleUI.addParent();
    }
}