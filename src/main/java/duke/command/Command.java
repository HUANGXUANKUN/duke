package duke.command;

import duke.core.DukeException;
import duke.core.Storage;
import duke.core.TaskList;
import duke.core.Ui;

/**
 * Represents a duke.command from user. Abstract class to be
 * implemented by various duke.command classes such as duke.command.ExitCommand, duke.command.AddCommand...
 */
public abstract class Command {
    /**
     * Indicates whether this duke.command tells duke.Duke to exit.
     *
     * @return A boolean. True to exit duke.Duke.
     */
    public abstract boolean isExit();

    /**
     * Executes the duke.command with respect to tasks
     *
     * @param tasklist The Tasklist containing tasks
     * @param ui The duke.Duke UI system interacting with user
     * @param storage The duke.core.Storage handles read/write of data from hard disk
     * @throws DukeException If an exception occurs during execution of the
     *      duke.command.
     */
    public abstract void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException;
}