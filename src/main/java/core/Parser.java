package core;

import command.*;
import task.Deadline;
import task.Event;
import task.Task;
import task.Todo;

import java.util.Arrays;

/**
 * It parses user command into a Duke's understandable commands
 */
public class Parser {

    /**
     * Check if the keyword appears in the given string
     *
     * @param stringArr The string array to be inspected.
     * @param keyword The string to be searched.
     * @return A boolean value indicates if the keyword is found in the string array.
     */
    private static boolean findKeyword(String[] stringArr, String keyword) {
        if (Arrays.asList(stringArr).contains(keyword)){
            return true;
        }
        return false;
    }

    /**
     * Parses a task.Task from a command string
     *
     * @param s The string array to be parsed.
     * @return The task.Task that is parsed from the string array.
     */
    private static Task parseTask(String s) {
        String[] textArr = s.split(" ", 2);

        if (s.startsWith("deadline")) {
            String[] contentArr = textArr[1].split(" /by ");
            String description = contentArr[0];
            String by = contentArr[1];
            return new Deadline(description, by);
        } else if (s.startsWith("event")) {
            String[] contentArr = textArr[1].split(" /at ");
            String description = contentArr[0];
            String at = contentArr[1];
            return new Event(description, at);
        } else {
            return new Todo(textArr[1]);
        }
    }

    /**
     * Checks for illegal user input and throws exceptions accordingly.
     *
     * @param words The string array to be checked.
     * @throws A Duke specificed Exception describing the error
     */
    private static void checkValidity(String[] words) throws DukeException {
        String firstWord = words[0];
        if (!(firstWord.equals("done") || firstWord.equals("todo") || firstWord.equals("deadline") || firstWord.equals("event")
                || firstWord.equals("delete") || firstWord.equals("list") || firstWord.equals("bye") || firstWord.equals("find"))) {
            throw new DukeException("OOPS!!! I'm sorry, but I don't know what that means :-(");
        }

        // Check if task description is empty
        if ((firstWord.equals("todo") || firstWord.equals("done") || firstWord.equals("delete") || firstWord.equals("find")) && words.length < 2) {
            System.out.println("wordlength = " + words.length);
            throw new DukeException("OOPS!!! The description of the command " + firstWord + " is empty.");
        }

        // Check if tasks task.Deadline or task.Event contains keyword of date and time
        if ((firstWord.equals("deadline") && !findKeyword(words, "/by"))
                || (firstWord.equals("event") && !findKeyword(words, "/at"))) {
            throw new DukeException("OOPS!!! The date/time of a " + firstWord + " is not provided.");
        }


    }

    /**
     * Parses a user command into a Duke's understandable command type
     *
     * @param s The string represents user command.
     * @return A command.Command that represents the type of command to be executed
     *
     * @throws DukeException Duke-specified Exception describing the error
     */
    public static Command parse(String s) throws DukeException {
        String[] words = s.split(" ");
        checkValidity(words);
        switch (words[0]) {
            case "bye":
                return new ExitCommand();
            case "done":
                return new DoneCommand(Integer.parseInt(words[1]));
            case "delete":
                return new DeleteCommand(Integer.parseInt(words[1]));
            case "list":
                return new ListCommand();
            case "find":
                return new FindCommand(words[1]);
            default:
                Task t = parseTask(s);
                return new AddCommand(t);
        }
    }
}