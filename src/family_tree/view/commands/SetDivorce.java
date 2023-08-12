package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SetDivorce extends Command {
    public SetDivorce(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Удалить супружескую связь";
    }

    public void execute(){
        consoleUI.setDivorce();
    }
}
