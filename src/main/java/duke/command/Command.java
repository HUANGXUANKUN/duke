package duke.command;

import duke.core.DukeException;
import duke.core.Storage;
import duke.core.TaskList;
import duke.core.Ui;

/**
 * Represents a command from user. Abstract class to be
 * implemented by various command classes such as command.ExitCommand, command.AddCommand...
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
     * @param taskList Storage of tasks
     * @param ui The Duke UI system interacting with user
     * @param storage The Storage handles read/write of data from hard disk
     * @throws DukeException If an exception occurs during execution of the
     *      command.
     */
    public abstract void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException;
}