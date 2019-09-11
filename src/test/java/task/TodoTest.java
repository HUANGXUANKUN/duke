package task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


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
}