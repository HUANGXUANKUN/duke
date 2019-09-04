import java.util.*;
import java.io.*;

public class Duke {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String greeting = "Hello from I'm Duke\n" +
                "What can I do for you?";
        System.out.println(greeting);
        ArrayList<Task> taskList = readTask();

        while (true) {
            String userInput = input.nextLine();

            try {
                if (userInput.equals("bye")) {
                    System.out.println("Bye. Hope to see you again soon!");
                    break;
                } else if (userInput.startsWith("done")) {
                    String[] textList = userInput.split(" ");
                    int taskIndex = Integer.parseInt(textList[1]) - 1;
                    Task t = taskList.get(taskIndex);
                    t.markAsDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println(t.toString());
                    writeTask(taskList);
                } else if (userInput.equals("list")) {
                    System.out.println("Here are the tasks in your list:");
                    for (int i = 0; i < taskList.size(); i++) {
                        Task t = taskList.get(i);
                        System.out.println((i + 1) + ". " + t.toString());
                    }
                } else if (userInput.startsWith("find")) {
                    String[] textArr = userInput.split(" ");
                    if (textArr.length != 2 || textArr[1].isEmpty()) {
                        throw new DukeException("☹ OOPS!!! Please enter a non-empty keyword");
                    } else {
                        System.out.println("Here are the matching tasks in your list:");
                        for (int i = 0, j = 1; i < taskList.size(); i++) {
                            Task t = taskList.get(i);
                            boolean isFound = Arrays.asList(t.description.toLowerCase().split(" ")).contains(textArr[1].toLowerCase());
                            if (isFound) {
                                System.out.println(j + ". " + t.toString());
                                j++;
                            }
                        }
                    }
                } else if (userInput.startsWith("delete")) {
                    String[] textList = userInput.split(" ");
                    int taskIndex = Integer.parseInt(textList[1]) - 1;
                    System.out.println("Noted. I've removed this task:");
                    System.out.println(taskList.get(taskIndex).toString());
                    taskList.remove(taskIndex);
                    writeTask(taskList);
                } else if (userInput.startsWith("deadline") || userInput.startsWith("event") || userInput.startsWith("todo")) {
                    String[] textArr = userInput.split(" ", 2);

                    if (userInput.startsWith("deadline")) {
                        String[] contentArr = textArr[1].split(" /by ");
                        String description = contentArr[0];
                        if (description.replaceAll("\\s+", "").isEmpty()) {
                            throw new DukeException("☹ OOPS!!! The description of a Deadline cannot be empty.");
                        }
                        String by = contentArr[1];
                        Deadline deadline = new Deadline(description, by);
                        taskList.add(deadline);
                    } else if (userInput.startsWith("event")) {
                        String[] contentArr = textArr[1].split(" /at ");
                        String description = contentArr[0];
                        if (description.replaceAll("\\s+", "").isEmpty()) {
                            throw new DukeException("☹ OOPS!!! The description of a Event cannot be empty.");
                        }
                        String at = contentArr[1];
                        Event event = new Event(description, at);
                        taskList.add(event);
                    } else {
                        if (textArr[1].replaceAll("\\s+", "").isEmpty()) {
                            throw new DukeException("☹ OOPS!!! The description of a Todo cannot be empty.");
                        }
                        Todo todo = new Todo(textArr[1]);
                        taskList.add(todo);
                    }

                    writeTask(taskList);
                    System.out.println("Got it. I've added this task: ");
                    System.out.println(taskList.get(taskList.size() - 1).toString());
                    System.out.println("Now you have " + taskList.size() + " tasks in the list.");
                } else {
                    System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            } catch (DukeException e) {
                System.out.println(e);
                continue;
            } catch (Exception e) {
                System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                continue;
            }
        }
    }

    public static ArrayList readTask() {
        System.out.println("Reading Task List ...");
        ArrayList<Task> taskList = new ArrayList<Task>();

        File file = new File("data\\duke.txt");
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(" \\| ", 4);
                if (data[0].equals("T")) {
                    Todo todo = new Todo(data[2]);
                    if (data[1].equals("1")) todo.markAsDone();
                    taskList.add(todo);
                } else if (data[0].equals("D")) {
                    Deadline deadline = new Deadline(data[2], data[3]);
                    if (data[1].equals("1")) deadline.markAsDone();
                    taskList.add(deadline);
                } else if (data[0].equals("E")) {
                    Event event = new Event(data[2], data[3]);
                    if (data[1].equals("1")) event.markAsDone();
                    taskList.add(event);
                }
            }
            System.out.println("Loading of task list is completed");
        } catch (FileNotFoundException error) {
            System.out.println("There is a loading error");
        }

        return taskList;
    }

    public static void writeTask(ArrayList<Task> taskList) {
        File file = new File("data\\duke.txt");

        try {
            PrintWriter writeIn = new PrintWriter(file);
            for (int i = 0; i < taskList.size(); i++) {
                int status = 0;

                Task task = taskList.get(i);
                if (task.isDone()) {
                    status = 1;
                }

                writeIn.println(task.writeToFile());
            }
            writeIn.close();
        } catch (FileNotFoundException e) {
            System.out.println("There is a write error");
        }
    }
}
