package duke.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateFormatter {


    /**
     * Try to convert the input string from dd/MM/yyyy HHmm to English representation.
     * For example 15/12/2019 can be converted to (15th of December 1200 , 1AM)
     * If the input string is not in dd/MM/yyyy, return input string
     *
     * @param formatInput represents a string input which might in the format of dd/MM/yyyy HHmm
     * @return A string that either in converted date and time format or same as the input string(Formatting fails)
     */
    public static String convertToDateAndTime(String formatInput) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");
        DateTimeFormatter stFormatter = DateTimeFormatter.ofPattern("d'st of' MMMM yyyy, ha");
        DateTimeFormatter ndFormatter = DateTimeFormatter.ofPattern("d'nd of' MMMM yyyy, ha");
        DateTimeFormatter rdFormatter = DateTimeFormatter.ofPattern("d'rd of' MMMM yyyy, ha");
        DateTimeFormatter thFormatter = DateTimeFormatter.ofPattern("d'th of' MMMM yyyy, ha");
        try {
            LocalDateTime formatted = LocalDateTime.parse(formatInput, formatter);
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
