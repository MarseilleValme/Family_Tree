package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SetWedding extends Command {
    public SetWedding(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Установить супружескую связь";
    }

    public void execute(){
        consoleUI.setWedding();
    }
}
