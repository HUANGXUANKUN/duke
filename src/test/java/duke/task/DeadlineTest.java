package duke.task;

import duke.core.DukeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


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

    @Test
    public void deadlineTestCase() throws DukeException {
        // Creata a new deadline and check its toString() and getFormat()
        Deadline deadline = new Deadline("deadlineTest", "02/12/1996 1235");
        assertFalse(deadline.isDone(), "The newly created deadline should not be done");
        assertEquals( "[D][N] deadlineTest (by: 2nd of December 1996 , 12PM)",deadline.toString(), "The writeToFile format is not expected");
        assertEquals( "D | 0 | deadlineTest | 02/12/1996 1235",deadline.getFormat(), "The writeToFile format is not expected");

        // Mark the deadline as done and check its toString() and getFormat()
        deadline.markAsDone();
        assertTrue(deadline.isDone(), "The deadline should be marked as done");
        assertEquals("[D][Y] deadlineTest (by: 2nd of December 1996 , 12PM)", deadline.toString(), "The deadline.toString() is not expected");
        assertEquals( "D | 1 | deadlineTest | 02/12/1996 1235",deadline.getFormat(), "The writeToFile format is not expected");
    }
}
