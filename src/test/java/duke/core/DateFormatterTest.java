package duke.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateFormatterTest {
    /**
     * Test the DateFormatter.convertToDateAndTime with valid input Date&Time format, verify if the outputs are expected
     */
    @Test
    public void validFormattingTest(){
        assertEquals("1st of January 1996, 10AM", DateFormatter.convertToDateAndTime("01/01/1996 1035"), "The date&time is not converted into proper format");
        assertEquals("22nd of February 1996, 12AM", DateFormatter.convertToDateAndTime("22/02/1996 0000"), "The date&time is not converted into proper format");
        assertEquals("3rd of June 1996, 5PM", DateFormatter.convertToDateAndTime("03/06/1996 1735"),"The date&time is not converted into proper format");
        assertEquals("14th of December 1996, 11PM", DateFormatter.convertToDateAndTime("14/12/1996 2359"),"The date&time is not converted into proper format");
    }

    /**
     * Test the DateFormatter.convertToDateAndTime with invalid input Date&Time format, verify if the outputs are equal to inputs
     */
    @Test
    public void invalidFormattingTest(){
        assertEquals("1/01/2000 1035", DateFormatter.convertToDateAndTime("1/01/2000 1035"), "Invalid date format is given, input String should be returned");
        assertEquals("1/01/2000 1035", DateFormatter.convertToDateAndTime("1/01/2000 1035"), "Invalid date format is given, input String should be returned");
        assertEquals("01/01/2000 2500", DateFormatter.convertToDateAndTime("01/01/2000 2500"), "Invalid time is given, input String should be returned");
    }
}
