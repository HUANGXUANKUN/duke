/**
 * Represents a command to find if any task with specific
 * keyword exists in the taskList.
 */
public class FindCommand extends Command {
    /** A string representation of the keyword for searching. */
    private String keyword;

    /**
     * Constructor of a FindCommand class. Take in a keyword to find
     * if the task exists in the taskList.
     *
     * @param keyword Specifies the keyword for searching.
     */
    public FindCommand(String keyword) {
        super();
        this.keyword = keyword;
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
     * @param taskList The Tasklist containing tasks.
     * @param ui The Duke UI system interacting with user.
     * @param storage The Storage handles read/write of data from hard disk.
     * @throws DukeException If an exception occurs during execution of the
     *      command.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.showFoundResult(taskList, keyword);
    }
}