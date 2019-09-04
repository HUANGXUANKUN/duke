/**
 * Represents a command to list all existing tasks in the task list. The
 * <code>ListCommand</code> class inherits from the <code>Command</code> class
 * to represent user instruction to display all existing tasks in the task list.
 */
public class ListCommand extends Command {
    /**
     * Constructs a <code>ListCommand</code> object.
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
     * @param tasklist The Tasklist containing tasks.
     * @param ui The Duke UI system interacting with user.
            * @param storage The Storage handles read/write of data from hard disk.
            * @throws DukeException If an exception occurs during execution of the
     *      command.
     *
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showTaskList(tasks);
    }
}