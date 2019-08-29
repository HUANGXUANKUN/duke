import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String greeting = "Hello from I'm Duke\n" +
                "What can I do for you?";
        String longDash = "_______________________________";
        System.out.println(greeting);

        ArrayList<Task> taskList = new ArrayList<Task>();

        while (true) {
            String userInput = input.nextLine();

            try{
                if (userInput.equals("bye")) {
                    System.out.println("Bye. Hope to see you again soon!");
                    break;
                } else if (userInput.startsWith("done")) {
                    String[] textList = userInput.split(" ");
                    int taskIndex = Integer.parseInt(textList[1]) - 1;
                    Task t = taskList.get(taskIndex);
                    t.markAsDone();
                    System.out.println("Nice! I've marked this task as done: \n");
                    System.out.println("[" + t.getStatusIcon() + "]" + t.description);
                } else if (userInput.equals("list")) {
                    System.out.println(longDash + "\n" + "Here are the tasks in your list:");
                    for (int i = 0; i < taskList.size(); i++) {
                        Task t = taskList.get(i);
                        System.out.println((i + 1) + ". " + t.toString());
                    }
                } else if (userInput.startsWith("Deadline") || userInput.startsWith("Event") || userInput.startsWith("Todo")) {
                    String[] textArr = userInput.split(" ", 2);

                    if (userInput.startsWith("Deadline")) {
                        String[] contentArr = textArr[1].split("/by");
                        String description = contentArr[0];
                        if (description.replaceAll("\\s+", "").isEmpty()){
                            throw new DukeException("☹ OOPS!!! The description of a Deadline cannot be empty.\n");
                        }
                        String by = contentArr[1];
                        Deadline deadline = new Deadline(description, by);
                        taskList.add(deadline);
                    } else if (userInput.startsWith("Event")) {
                        String[] contentArr = textArr[1].split("/at");
                        String description = contentArr[0];
                        if (description.replaceAll("\\s+", "").isEmpty()){
                            throw new DukeException("☹ OOPS!!! The description of a Event cannot be empty.\n");
                        }
                        String at = contentArr[1];
                        Event event = new Event(description, at);
                        taskList.add(event);
                    } else {
                        if (textArr[1].replaceAll("\\s+", "").isEmpty()){
                            throw new DukeException("☹ OOPS!!! The description of a Todo cannot be empty.\n");
                        }
                        Todo todo = new Todo(textArr[1]);
                        taskList.add(todo);
                    }

                    System.out.println(longDash);
                    System.out.println("Got it. I've added this task: \n");
                    System.out.println(taskList.get(taskList.size() - 1).toString());
                    System.out.println("Now you have " + taskList.size() + " tasks in the list.");
                    System.out.println(longDash);
                } else {
                    System.out.println(" ☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            } catch(DukeException e){
                System.out.println(e);
                continue;
            } catch(Exception e){
                System.out.println(" ☹ Exception e OOPS!!! I'm sorry, but I don't know what that means :-(");
                continue;
            }
        }
    }
}
