import command.Command;
import core.*;

public class Duke {
    private Storage storage;

    private TaskList tasks;
    private Ui ui;

    /**
     * Start Duke by passing in a specific file
     * path where the task data is stored
     */
    public static void main(String[] args) {
        new Duke("data/duke.txt").run();
    }

    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.loadTasks());
        } catch (DukeException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    private void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                //If exitCommand is being execute, while loop will be terminate
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

}
