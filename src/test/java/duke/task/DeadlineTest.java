package duke.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class DeadlineTest {
    @Test
    public void deadlineStringTest() {
        assertEquals( "[D][N] abc (by: 2nd of December 1996 , 12PM)", new Deadline("abc", "02/12/1996 1235").toString(),"Deadline toString() is not expected");
    }

    @Test
    public void writeFormatTest() {
        assertEquals( "D | 0 | deadlineTest | 02/12/1996 1235",new Deadline("deadlineTest", "02/12/1996 1235").getFormat(), "The writeToFile format is not expected");
    }

    @Test
    public void doneStatusTest() {
        assertFalse(new Deadline("abc", "02/12/1996 1235").isDone(), "The newly created Deadline should not be done");
    }
}
