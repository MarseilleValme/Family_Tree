package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class addChild extends Command {
    public addChild(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить потомка";
    }

    public void execute(){
        consoleUI.addChild();
    }
}