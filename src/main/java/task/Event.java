package task;
import core.DateFormatter;

public class Event extends Task {

    private String date;
    private String formatted;

    public Event(String description, String at) {
        super(description);
        this.date = at;
        this.formatted = DateFormatter.convertToDateAndTime(at);
    }

    public String toString() {
        return "[E]" + super.toString() + " (at: " + formatted + ")";
    }

    @Override
    public String getFormat() {
        if (super.isDone()) {
            return "E | 1 | " + super.getDescription() + " | " + date;
        } else {
            return "E | 0 | " + super.getDescription() + " | " + date;
        }
    }
}