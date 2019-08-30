public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    @Override
    public char type(){
        return 'D';
    }

    @Override
    public String writeToFile() {
        if (super.isDone()) {
            return type() + " | 1 | "  +  super.getDescription() + " | " + by;
        } else {
            return type() + " | 0 | "  +  super.getDescription() + " | " + by;
        }
    }


}