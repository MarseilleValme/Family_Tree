package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class Save extends Command {
    public Save(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить древо в файл";
    }

    public void execute(){
        consoleUI.save();
    }
}