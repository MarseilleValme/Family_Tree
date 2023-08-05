package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class Load extends Command {
    public Load(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить древо из файла";
    }

    public void execute(){
        consoleUI.load();
    }
}