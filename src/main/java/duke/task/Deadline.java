package duke.task;
import duke.core.DateFormatter;

/**
 * Extends from Task, represents a Deadline task which required description and Date/Time info
 */
public class Deadline extends Task {

    private String date;
    private String formatted;

    /**
     * Constructor of Deadline task
     *
     * @param description represents the info/title of the task
     * @param by represents a string with date&time information
     */
    public Deadline(String description, String by) {
        super(description);
        this.date = by;
        this.formatted = DateFormatter.convertToDateAndTime(by);
    }

    /**
     * Output the String containing info of the task
     *
     * @return a String in format of "[D][Y] Homework (by: 15th of December 1200 , 1AM)"
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + formatted + ")";
    }

    /**
     * Output the info of the task to be written in local txt file
     *
     * @return a String in format of "D | 0 | Homework | 02/12/1996 1235"
     */
    @Override
    public String getFormat() {
        if (super.isDone()) {
            return "D | 1 | "  +  super.getDescription() + " | " + date;
        } else {
            return "D | 0 | "  +  super.getDescription() + " | " + date;
        }
    }

}