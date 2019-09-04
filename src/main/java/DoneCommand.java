/**
 * Represents a command to mark the task as done.
 */
public class DoneCommand extends Command {
    /** The index of the task to be marked as done, as specifed by this command. */
    private int Id;

    /**
     * Constructer of DoneCommand class. Use to mark the task with specific
     * id in the list to done.
     *
     * @param taskId Specifies the index of the task to be marked as done.
     */
    public DoneCommand(int Id) {
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
        t.markAsDone();
        storage.saveTasks(taskList);
        ui.markedAsDone(t);
    }
}