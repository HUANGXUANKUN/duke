package duke.command;

import duke.core.DukeException;
import duke.core.Storage;
import duke.core.TaskList;
import duke.core.Ui;

/**
 * Represents a duke.command to find if any duke.task with specific
 * keyword exists in the taskList.
 */
public class FindCommand extends Command {
    /** A string representation of the keyword for searching. */
    private String keyword;

    /**
     * Constructor of a duke.command.FindCommand class. Take in a keyword to find
     * if the duke.task exists in the taskList.
     *
     * @param keyword Specifies the keyword for searching.
     */
    public FindCommand(String keyword) {
        super();
        this.keyword = keyword;
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
     * @param taskList The Tasklist containing tasks.
     * @param ui The duke.Duke UI system interacting with user.
     * @param storage The duke.core.Storage handles read/write of data from hard disk.
     * @throws DukeException If an exception occurs during execution of the
     *      duke.command.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.showFoundResult(taskList, keyword);
    }
}