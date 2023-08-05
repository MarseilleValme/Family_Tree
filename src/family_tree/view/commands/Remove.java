package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class Remove extends Command {
    public Remove(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Удалить запись";
    }

    public void execute(){
        consoleUI.remove();
    }


}