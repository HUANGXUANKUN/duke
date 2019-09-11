package duke.task;

public abstract class Task {

    private String description;
    private boolean isDone;

    public Task(String description){
        this.description = description;
        this.isDone = false;
    }

    public boolean isDone(){
        return isDone;
    }

    public void markAsDone(){
        isDone = true;
    }

    private String getStatusIcon() {
        return (isDone ? "Y" : "N");
    }

    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }

    public String getDescription(){
        return this.description;
    }

    /**
     * Turn the info of the duke.task in proper format to be written in local
     *
     * @return A string that contains info of a duke.task.
     */
    public abstract String getFormat();
}