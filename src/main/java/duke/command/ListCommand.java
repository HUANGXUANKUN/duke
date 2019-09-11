package duke.command;

import duke.core.DukeException;
import duke.core.Storage;
import duke.core.TaskList;
import duke.core.Ui;

/**
 * Represents a duke.command to list all duke.task stored in taskList.
 */
public class ListCommand extends Command {
    /**
     * Constructs a <code>duke.command.ListCommand</code> object.
     */
    public ListCommand() {
        super();
    }

    /**
     * Indicates whether this duke.command tells duke.Duke to exit.
     *
     * @return A boolean value false.
     */
    @Override
    public boolean isExit() {
        return false;
    }
    /**
     * @param taskList The Tasklist containing tasks.
     * @param ui The duke.Duke UI system interacting with user.
     * @param storage The duke.core.Storage handles read/write of data from hard disk.
     * @throws DukeException If an exception occurs during execution of the
     *      duke.command.
     *
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        ui.showTaskList(taskList);
    }
}