package duke.task;
import duke.core.DateFormatter;

public class Deadline extends Task {

    private String date;
    private String formatted;
    public Deadline(String description, String by) {
        super(description);
        this.date = by;
        this.formatted = DateFormatter.convertToDateAndTime(by);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + formatted + ")";
    }

    @Override
    public String getFormat() {
        if (super.isDone()) {
            return "D | 1 | "  +  super.getDescription() + " | " + date;
        } else {
            return "D | 0 | "  +  super.getDescription() + " | " + date;
        }
    }

}