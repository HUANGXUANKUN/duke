public abstract class Task {

    protected String description;
    protected boolean isDone;

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

    public String getStatusIcon() {
        return (isDone ? "Y" : "N");
    }

    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }

    public String getDescription(){
        return this.description;
    }

    public abstract char type();

    public abstract String writeToFile();
}