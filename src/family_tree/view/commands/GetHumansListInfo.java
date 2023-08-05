package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class GetHumansListInfo extends Command {
    public GetHumansListInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести фамильное древо";
    }

    public void execute(){
        consoleUI.getHumansListInfo();
    }
}
