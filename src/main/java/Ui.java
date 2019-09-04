import java.util.*;

/**
 * The UI system that provides conversation with user.
 */
public class Ui {
    private Scanner scanner;

    /**
     * Constructer to initialize object UI and allow user to type command
     */
    public Ui() {
        scanner = new Scanner(System.in);
    }

    /**
     * Shows Greating message
     */
    public void showWelcome() {
        String greeting = "Hello from I'm Duke\n" + "What can I do for you?";
        System.out.println(greeting);
    }

    /**
     * Display an loading error log when loading of data fails
     */
    public void showLoadingError() {
        System.out.println("There is a loading error");
    }

    /**
     * Reads one line of user instruction.
     *
     * @return a string of user command
     */
    public String readCommand() {
        return scanner.nextLine();
    }

    /**
     * Display a long dash line to divide the prompt message
     */
    public void showLine() {
        System.out.println("_____________________________________________________");
    }

    /**
     * Shows that a Task is added to the task list, and then displays
     * that task and the number of tasks in task list.
     *
     * @param t    The <code>Task</code> that is added to the list.
     * @param size The number of tasks stored in the <code>TaskList</code>.
     */
    public void showTaskAdded(Task t, int taskListSize) {
        System.out.println("Got it. I've added this task: ");
        System.out.println(t);
        System.out.println("Now you have " + taskListSize + " tasks in the list.");
    }

    /**
     * Shows an error.
     *
     * @param str A string representing the description of the error.
     */
    public void showError(String str) {
        System.out.println(str);
    }

    /**
     * Show the message of a Task that has been marked as 'done'.
     *
     * @param t A Task that has its status marked as 'done'.
     */
    public void markedAsDone(Task t) {
        System.out.println("Nice! I've marked this task as done: \n  " + t);
    }

    /**
     * Shows the removed task and the current number of tasks in the task list
     *
     * @param t            The Task that is removed from the task list
     * @param taskListSize the size of the task list which the Task t is being
     *                     removed from.
     */
    public void showRemovedTask(Task t, int taskListSize) {
        System.out.println("Noted. I've removed this task:\n");
        System.out.println(t);
        System.out.println("Now you have " + taskListSize + " tasks in the list.");
    }

    /**
     * Displays all tasks in the taskList.
     *
     * @param taskList The TaskList that contains all the tasks
     */
    public void showTaskList(TaskList taskList) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < taskList.getSize(); i++) {
            System.out.println((i + 1) + ". " + taskList.getTask(i));
        }
    }

    /**
     * Shows search results for finding a keyword in the task list. Displays
     * all tasks that contain the keyword.
     *
     * @param tasks   The <code>TaskList</code> where keyword is searched.
     * @param keyword A string representation of the keyword.
     */
    public void showFoundResult(TaskList taskList, String keyword) {
        System.out.println("Here are the matching tasks in your list:");
        int i = 0, j = 0;
        for (; i < taskList.getSize(); i++) {
            Task t = taskList.getTask(i);
            boolean isFound = Arrays.asList(t.description.toLowerCase().split(" ")).contains(keyword.toLowerCase());
            if (isFound) {
                System.out.println(j + ". " + t);
                j++;
            }
        }
    }

    /**
     * Shows exit message to user
     */
    public void showByeMessage() {
        System.out.println("Bye. Hope to see you again soon!");
    }
}