package duke.task;

/**
 * Extends from Task, represents a Todo task which required only the description info
 */
public class Todo extends Task {

    /**
     * Constructor of Todo task
     *
     * @param description represents the info/title of the task
     */
    public Todo(String description){
        super(description);
    }

    /**
     * Output the String containing info of the task
     *
     * @return a String in format of "[T][Y] Homework)"
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * Output the info of the task to be written in local txt file
     *
     * @return a String in format of "T | 0 | Homework"
     */
    @Override
    public String getFormat(){
        if (super.isDone()) {
            return "T | 1 | "  +  super.getDescription();
        } else {
            return "T | 0 | "  +  super.getDescription();
        }
    }
}