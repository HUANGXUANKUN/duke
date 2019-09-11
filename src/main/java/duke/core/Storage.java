package duke.core;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a duke.core.Storage that perform reading and writing of data
 * from hard disk.
 */
public class Storage {
    private String path;

    /**
     * Constructs a duke.core.Storage object with a file path.
     *
     * @param path A string that represents the path of the file
     *                where data is being stored and read from
     */
    public Storage(String path) {
        this.path = path;
    }

    /**
     * Read the tasks from the file to a ArrayList<duke.task.Task>
     *
     * @return taskList A ArrayList of tasks as recorded in the file.
     * @throw duke.core.DukeException A Exception when file is not found.
     */
    public ArrayList<Task> loadTasks() throws DukeException {
        ArrayList<Task> taskList = new ArrayList<Task>();

        File file = new File(this.path);
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
            System.out.println("Loading of duke.task list is completed");
        } catch (FileNotFoundException error) {
            System.out.println("There is a loading error");
        }
        return taskList;
    }

    /**
     * Saves tasks from a <code>duke.core.TaskList</code> to the local file.
     *
     * @param taskList The <code>duke.core.TaskList</code> storing tasks.
     * @throws DukeException If writing to the local file failed.
     */
    public void saveTasks(TaskList taskList) throws DukeException {
        File file = new File(this.path);
        try {
            PrintWriter writeIn = new PrintWriter(file);
            for (int i = 0; i < taskList.getSize(); i++) {
                Task task = taskList.getTask(i);
                writeIn.println(task.getFormat());
            }
            writeIn.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fail to save tasks to hard disk");
        }
    }
}
