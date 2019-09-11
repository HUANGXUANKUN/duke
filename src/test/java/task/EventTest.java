package task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class EventTest {
    @Test
    public void EventStringTest() {
        assertEquals("[E][N] eventTest (at: 2nd of December 1996 , 12PM)", new Event("eventTest", "02/12/1996 1235").toString(), "Deadline string result is not expected");
    }

    @Test
    public void writeFormatTest() {
        assertEquals( "E | 0 | test | 02/12/1996 1235",new Event("test", "02/12/1996 1235").getFormat(), "The writeToFile format is not expected");
    }

    @Test
    public void doneStatusTest() {
        assertFalse(new Event("test", "02/12/1996 1235").isDone(), "The newly created Deadline should not be done");
    }
}