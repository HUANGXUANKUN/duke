/**
 * Represents a command to delete a task.
 */
public class DeleteCommand extends Command {
    /** The index of the task to be deleted, as specifed by this command. */
    private int Id;

    /**
     * Constructs a <code>DeleteCommand</code> object.
     *
     * @param taskId Specifies the index of the task to be deleted.
     */
    public DeleteCommand(int Id) {
        super();
        this.Id = Id;
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
     * @param ui The Duke UI system interacting with user
     * @param storage The Storage handles read/write of data from hard disk
     * @throws DukeException If an exception occurs during execution of the
     *      command.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        Task t = taskList.getTask(Id - 1);
        taskList.removeTask(Id - 1);
        ui.showRemovedTask(t, taskList.getSize());
        storage.saveTasks(taskList);
    }
}