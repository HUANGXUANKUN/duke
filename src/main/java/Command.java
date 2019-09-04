/**
 * Represents a command from user. Abstract class to be
 * implemented by various command classes such as ExitCommand, AddCommand...
 */
public abstract class Command {
    /**
     * Indicates whether this command tells Duke to exit.
     *
     * @return A boolean. True to exit Duke.
     */
    public abstract boolean isExit();

    /**
     * Executes the command with respect to tasks
     *
     * @param tasklist The Tasklist containing tasks
     * @param ui The Duke UI system interacting with user
     * @param storage The Storage handles read/write of data from hard disk
     * @throws DukeException If an exception occurs during execution of the
     *      command.
     */
    public abstract void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException;
}