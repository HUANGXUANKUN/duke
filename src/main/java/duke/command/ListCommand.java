package duke.command;

import duke.core.DukeException;
import duke.core.Storage;
import duke.core.TaskList;
import duke.core.Ui;

/**
 * Represents a command to list all task stored in taskList.
 */
public class ListCommand extends Command {
    /**
     * Constructs a command.ListCommand object.
     */
    public ListCommand() {
        super();
    }

    /**
     * Indicates whether this command tells Duke to exit.
     *
     * @return A boolean value false.
     */
    @Override
    public boolean isExit() {
        return false;
    }
    /**
     * @param taskList The Tasklist containing tasks.
     * @param ui The Duke UI system interacting with user.
     * @param storage The Storage handles read/write of data from hard disk.
     * @throws DukeException If an exception occurs during execution of the
     *      command.
     *
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        ui.showTaskList(taskList);
    }
}