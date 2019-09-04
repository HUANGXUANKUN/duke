/**
 * Represents a command to exit Duke.
 */
public class ExitCommand extends Command {
    public ExitCommand() {
        super();
    }

    /**
     * Indicates whether this command tells Duke to exit.
     *
     * @return A boolean value true.
     */
    @Override
    public boolean isExit() {
        return true;
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
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.showByeMessage();
    }
}