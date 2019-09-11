package duke.command;

import duke.core.DukeException;
import duke.core.Storage;
import duke.core.TaskList;
import duke.core.Ui;

/**
 * Represents a command to exit Duke.
 */
public class ExitCommand extends Command {
    public ExitCommand() {
        super();
    }

    /**
     * Indicates whether this command tells Duke to exit.
     *
     * @return A boolean value true.
     */
    @Override
    public boolean isExit() {
        return true;
    }

    /**
     * Executes the command with respect to tasks
     *
     * @param taskList containing tasks
     * @param ui The Duke UI system interacts with user
     * @param storage The Storage handles read/write of data from hard disk
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.showByeMessage();
    }
}