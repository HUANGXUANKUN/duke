package duke.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TodoTest {

    @Test
    public void todoTest1(){
        // Creata a new task and check its toString() and getFormat()
        Todo todo = new Todo("todoTest");
        assertFalse(todo.isDone(), "The newly created Deadline should not be done");
        assertEquals( "[T][N] todoTest",todo.toString(), "The writeToFile format is not expected");
        assertEquals( "T | 0 | todoTest",todo.getFormat(), "The writeToFile format is not expected");

        // Mark the task as done and check its toString() and getFormat()
        todo.markAsDone();
        assertTrue(todo.isDone(), "The todo should be marked as done");
        assertEquals("[T][Y] todoTest", todo.toString(), "The todo.toString() is not expected");
        assertEquals( "T | 1 | todoTest",todo.getFormat(), "The writeToFile format is not expected");
    }
}