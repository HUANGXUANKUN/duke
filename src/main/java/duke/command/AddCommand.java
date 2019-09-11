package duke.command;

import duke.core.DukeException;
import duke.core.Storage;
import duke.core.TaskList;
import duke.core.Ui;
import duke.task.Task;

/**
 * Represents a command to add a task.
 */
public class AddCommand extends Command {
    private Task task;

    /**
     * Constructer of command.AddCommand class
     *
     * @param task Specifies the task to be added.
     */
    public AddCommand(Task task) {
        super();
        this.task = task;
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
     * Executes the command with respect to tasks
     *
     * @param tasklist The Tasklist containing tasks
     * @param ui       The Duke UI system interacting with user
     * @param storage  The Storage handles read/write of data from hard disk
     * @throws DukeException If an exception occurs during execution of the
     *                       command.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        taskList.addTask(task);
        ui.showTaskAdded(task, taskList.getSize());
        storage.saveTasks(taskList);
    }
}