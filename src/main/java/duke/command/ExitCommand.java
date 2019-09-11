package duke.command;

import duke.core.DukeException;
import duke.core.Storage;
import duke.core.TaskList;
import duke.core.Ui;

/**
 * Represents a duke.command to exit duke.Duke.
 */
public class ExitCommand extends Command {
    public ExitCommand() {
        super();
    }

    /**
     * Indicates whether this duke.command tells duke.Duke to exit.
     *
     * @return A boolean value true.
     */
    @Override
    public boolean isExit() {
        return true;
    }

    /**
     * Executes the duke.command with respect to tasks
     *
     * @param taskList containing tasks
     * @param ui The duke.Duke UI system interacts with user
     * @param storage The duke.core.Storage handles read/write of data from hard disk
     * @throws DukeException If an exception occurs during execution of the
     *      duke.command.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.showByeMessage();
    }
}