package duke;

import duke.command.Command;
import duke.core.*;

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

    /**
     * Constructor of the main Duke class
     * Initialize the ui, storage and taskList objects
     *
     * @param filePath The relative local path where task data is being stored
     */
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

    /**
     * Run the program with ui in recursive loop
     * In each loop, ask the user to input command and execute it.
     * If the command "bye" is entered by user, exit the program
     */
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
