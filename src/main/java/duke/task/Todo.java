package duke.task;

public class Todo extends Task {

    public Todo(String description){
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public String getFormat(){
        if (super.isDone()) {
            return "T | 1 | "  +  super.getDescription();
        } else {
            return "T | 0 | "  +  super.getDescription();
        }
    }
}