package duke.task;

import duke.core.DukeException;

/**
 * An abstract class to be extended into Deadline, Todo and Event classes
 */
public abstract class Task {

    private String description;
    private boolean isDone;

    public Task(String description){
        this.description = description;
        this.isDone = false;
    }

    /**
     * To check if the task is done
     *
     * @return boolean value of the isDone status
     */
    public boolean isDone(){
        return isDone;
    }

    /**
     * To change the status of the task from isDone = false to isDone = true
     * If the task is already done, throw an DukeException with log to inform the user
     *
     * @throws DukeException with log "This task is already done"
     */
    public void markAsDone() throws DukeException {
        if (this.isDone){
            throw new DukeException("This task is already done");
        }
        isDone = true;
    }

    /**
     * Get the icon representing the isDone status of the task
     * If the task is done, icon = "Y", "N" otherwise.
     *
     * @return a String representing the isDone status icon
     */
    private String getStatusIcon() {
        return (isDone ? "Y" : "N");
    }

    /**
     * Output the String containing info of the task with isDone status icon
     *
     * @return a String in format of "[Y] Homework"
     */
    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }

    /**
     * Output the description info of the task
     *
     * @return a String of task info
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * Turn the info of the duke.task in proper format to be written in local
     * Implemented differently in sub-class Deadline, Todo and Event
     *
     * @return A string that contains info of a duke.task.
     */
    public abstract String getFormat();
}