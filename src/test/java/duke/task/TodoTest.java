package duke.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TodoTest {
    @Test
    public void todoStringTest(){
        assertEquals(new Todo("todoTest").toString(), "[T][N] todoTest", "todo string test fails");
    }

    @Test
    public void writeFormatTest() {
        assertEquals( "T | 0 | todoTest",new Todo("todoTest").getFormat(), "The writeToFile format is not expected");
    }

    @Test
    public void doneStatusTest() {
        assertFalse(new Todo("abc").isDone(), "The newly created Deadline should not be done");
    }

    @Test
    public void todoTestCase(){
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