import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Event extends Task {

    protected String at;

    public Event(String description, String at) {
        super(description);
        this.at = convertToDateAndTime(at);
    }

    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }

    public String convertToDateAndTime(String at) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");
        try {
            LocalDateTime dateTime = LocalDateTime.parse(at, formatter);
            formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            return formatter.format(dateTime);
        } catch (DateTimeParseException error) {
            return at;
        }
    }

    @Override
    public char type() {
        return 'E';
    }

    @Override
    public String writeToFile() {
        if (super.isDone()) {
            return type() + " | 1 | " + super.getDescription() + " | " + at;
        } else {
            return type() + " | 0 | " + super.getDescription() + " | " + at;
        }
    }
}