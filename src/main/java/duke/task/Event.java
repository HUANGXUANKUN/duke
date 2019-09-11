package duke.task;
import duke.core.DateFormatter;

/**
 * Extends from Task, represents a Event task which required description and Date/Time info
 */
public class Event extends Task {

    private String date;
    private String formatted;

    /**
     * Constructor of Event task
     *
     * @param description represents the info/title of the task
     * @param at represents a string with date&time information
     */
    public Event(String description, String at) {
        super(description);
        this.date = at;
        this.formatted = DateFormatter.convertToDateAndTime(at);
    }

    /**
     * Output the String containing info of the task
     *
     * @return a String in format of "[E][Y] event ABC (by: 15th of December 1200 , 1AM)"
     */
    public String toString() {
        return "[E]" + super.toString() + " (at: " + formatted + ")";
    }

    /**
     * Output the info of the task to be written in local txt file
     *
     * @return a String in format of "E | 1 | event ABC | 02/12/1996 1235"
     */
    @Override
    public String getFormat() {
        if (super.isDone()) {
            return "E | 1 | " + super.getDescription() + " | " + date;
        } else {
            return "E | 0 | " + super.getDescription() + " | " + date;
        }
    }
}