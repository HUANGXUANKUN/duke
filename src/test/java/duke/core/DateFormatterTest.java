package duke.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateFormatterTest {
    @Test
    public void formattingTest1(){
        assertEquals("1st of January 1996, 10AM", DateFormatter.convertToDateAndTime("01/01/1996 1035"));
    }

    @Test
    public void formattingTest2(){
        assertEquals("22nd of February 1996, 12AM", DateFormatter.convertToDateAndTime("22/02/1996 0000"));
    }

    @Test
    public void formattingTest3(){
        assertEquals("3rd of June 1996, 5PM", DateFormatter.convertToDateAndTime("03/06/1996 1735"));
    }

    @Test
    public void formattingTest4(){
        assertEquals("14th of December 1996, 11PM", DateFormatter.convertToDateAndTime("14/12/1996 2359"));
    }




}
