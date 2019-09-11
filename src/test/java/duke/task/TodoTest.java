package duke.task;

import duke.core.DukeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TodoTest {

    /**
     * Test the todo.toString()
     */
    @Test
    public void todoStringTest(){
        assertEquals(new Todo("todoTest").toString(), "[T][N] todoTest", "todo string test fails");
    }

    /**
     * Test the todo.getFormat()
     */
    @Test
    public void writeFormatTest() {
        assertEquals( "T | 0 | todoTest",new Todo("todoTest").getFormat(), "The writeToFile format is not expected");
    }

    /**
     * Test the todo.isDone() after a new Todo object is being initialized
     */
    @Test
    public void doneStatusTest() {
        assertFalse(new Todo("abc").isDone(), "The newly created Deadline should not be done");
    }

    /**
     * A general test case to test Todo class
     * Test steps:
     * 1. Create a Todo object
     * 2. Verify todo.isdone(), todo.toString(), todo.getFormat()
     * 3. Mark the todo object to isDone status.
     * 4. Repeat step 2
     *
     * @throws DukeException if markAsDone is applied to a done task, throw exception with log
     */
    @Test
    public void todoTestCase() throws DukeException {
        // Creata a new task and check its toString() and getFormat()
        Todo todo = new Todo("todoTest");
        assertFalse(todo.isDone(), "The newly created todo should not be done");
        assertEquals( "[T][N] todoTest",todo.toString(), "The writeToFile format is not expected");
        assertEquals( "T | 0 | todoTest",todo.getFormat(), "The writeToFile format is not expected");

        // Mark the task as done and check its toString() and getFormat()
        todo.markAsDone();
        assertTrue(todo.isDone(), "The todo should be marked as done");
        assertEquals("[T][Y] todoTest", todo.toString(), "The todo.toString() is not expected");
        assertEquals( "T | 1 | todoTest",todo.getFormat(), "The writeToFile format is not expected");
    }
}