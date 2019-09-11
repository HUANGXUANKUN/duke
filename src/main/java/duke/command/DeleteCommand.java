package duke.command;

import duke.core.DukeException;
import duke.core.Storage;
import duke.core.TaskList;
import duke.core.Ui;
import duke.task.Task;

/**
 * Represents a duke.command to delete a duke.task.
 */
public class DeleteCommand extends Command {
    /** The index of the duke.task to be deleted, as specified by this duke.command. */
    private int Id;

    /**
     * Constructs a duke.command.DeleteCommand object.
     *
     * @param Id Specifies the index of the duke.task to be deleted.
     */
    public DeleteCommand(int Id) {
        super();
        this.Id = Id;
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
     * Executes the duke.command with respect to tasks
     *
     * @param taskList container for tasks
     * @param ui The duke.Duke UI system interacting with user
     * @param storage The duke.core.Storage handles read/write of data from hard disk
     * @throws DukeException If an exception occurs during execution of the
     *      duke.command.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        Task t = taskList.getTask(Id - 1);
        taskList.removeTask(Id - 1);
        ui.showRemovedTask(t, taskList.getSize());
        storage.saveTasks(taskList);
    }
}