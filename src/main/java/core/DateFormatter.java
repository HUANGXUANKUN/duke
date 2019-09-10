package core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateFormatter {

    public static String convertToDateAndTime(String formatInput) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");
        DateTimeFormatter stFormatter = DateTimeFormatter.ofPattern("d'st of' MMMM yyyy , ha");
        DateTimeFormatter ndFormatter = DateTimeFormatter.ofPattern("d'nd of' MMMM yyyy , ha");
        DateTimeFormatter rdFormatter = DateTimeFormatter.ofPattern("d'rd of' MMMM yyyy , ha");
        DateTimeFormatter thFormatter = DateTimeFormatter.ofPattern("d'th of' MMMM yyyy , ha");
        try {
            LocalDateTime formatted = LocalDateTime.parse(formatInput, formatter);
            formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            if ((formatted.getDayOfMonth()%10) == 1){
                return formatted.format(stFormatter);
            }else if ((formatted.getDayOfMonth()%10) == 2) {
                return formatted.format(ndFormatter);
            }else if ((formatted.getDayOfMonth()%10) == 3) {
                return formatted.format(rdFormatter);
            }else{
                return formatted.format(thFormatter);
            }
        } catch (DateTimeParseException error) {
            return formatInput;
        }
    }
}
