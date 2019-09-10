package core;

import task.Task;

import java.util.ArrayList;

/**
 * It serves as a container of tasks.Can perform various operating
 * such as getter, adding, removing etc to the taskList.
 */
public class TaskList {

    private ArrayList<Task> taskList;

    /**
     * Constructs a new core.TaskList with a default empty list.
     */
    public TaskList() {
        taskList = new ArrayList<>();
    }

    /**
     * Constructor that takes in a ArrayList<task.Task>
     *
     * @param taskList An existing ArrayList of tasks.
     */
    public TaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    /**
     * Returns the ArrayList of tasks
     *
     * @return TheArrayList of tasks stored
     */
    ArrayList<Task> getList() {
        return this.taskList;
    }

    /**
     * A getter. To return task from taskList with given index
     *
     * @param An integer representing the index of the task.Task .
     * @return The task.Task in the list with this specific index.
     */
    public Task getTask(int i) {
        return taskList.get(i);
    }

    /**
     * An Adder. To add the argument task.Task to the taskList.
     *
     * @param t The task.Task to be added to the list.
     */
    public void addTask(Task t) {
        taskList.add(t);
    }

    /**
     * A remover. Delete the task with the given index from the taskList
     *
     * @param An integer representing the index of the task to be removed.
     */
    public void removeTask(int i) {
        taskList.remove(i);
    }

    /**
     * Returns the size of taskList
     *
     * @return An integer representing the size of the taskList.
     */
    public int getSize() {
        return taskList.size();
    }
}