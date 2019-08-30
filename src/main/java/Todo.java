public class Todo extends Task {

    public Todo(String description){
        super(description);
    }

    @Override
    public  String toString() {
        return "[T]" + super.toString();
    }

    public char type(){
        return 'T';
    }

    @Override
    public String writeToFile(){
        if (super.isDone()) {
            return type() + " | 1 | "  +  super.getDescription();
        } else {
            return type() + " | 0 | "  +  super.getDescription();
        }
    }
}