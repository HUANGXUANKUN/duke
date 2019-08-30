public class Event extends Task {

    protected String at;

    public Event(String description, String at){
        super(description);
        this.at = at;
    }

    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }

    @Override
    public char type(){
        return 'E';
    }
    @Override
    public String writeToFile(){
        if (super.isDone()) {
            return type() + " | 1 | "  +  super.getDescription() + " | " + at;
        } else {
            return type() + " | 0 | "  +  super.getDescription() + " | " + at;
        }
    }


}