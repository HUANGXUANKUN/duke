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
}