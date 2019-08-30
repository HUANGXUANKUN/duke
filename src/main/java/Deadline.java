import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = convertToDateAndTime(by);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    @Override
    public char type(){
        return 'D';
    }

    public String convertToDateAndTime(String at) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");
        try {
            LocalDateTime dateTime = LocalDateTime.parse(at, formatter);
            formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            return formatter.format(dateTime);
        } catch (DateTimeParseException error) {
            System.out.println("Data and Time are not in proper format\n");
            return at;
        }
    }

    @Override
    public String writeToFile() {
        if (super.isDone()) {
            return type() + " | 1 | "  +  super.getDescription() + " | " + by;
        } else {
            return type() + " | 0 | "  +  super.getDescription() + " | " + by;
        }
    }


}