package duke.command;

import duke.core.DukeException;
import duke.core.Storage;
import duke.core.TaskList;
import duke.core.Ui;
import duke.task.Task;

/**
 * Represents a duke.command to mark the duke.task as done.
 */
public class DoneCommand extends Command {
    /** The index of the duke.task to be marked as done, as specifed by this duke.command. */
    private int Id;

    /**
     * Constructor of duke.command.DoneCommand class. Use to mark the duke.task with specific
     * id in the list to done.
     *
     * @param Id Specifies the index of the duke.task to be marked as done.
     */
    public DoneCommand(int Id) {
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
     * @param taskList Container for tasks
     * @param ui The duke.Duke UI system interacting with user
     * @param storage The duke.core.Storage handles read/write of data from hard disk
     * @throws DukeException If an exception occurs during execution of the
     *      duke.command.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        Task t = taskList.getTask(Id - 1);
        t.markAsDone();
        storage.saveTasks(taskList);
        ui.markedAsDone(t);
    }
}