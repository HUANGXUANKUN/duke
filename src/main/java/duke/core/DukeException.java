package duke.core;

/**
 * Exception that is related to duke.Duke
 */
public class DukeException extends Exception {
    /**
     * Constructs a exception that is specific to duke with a error log
     *
     * @param errorMessage A string that describes the specific duke error begins with "OOPS!!!"
     */
    public DukeException(String errorMessage) {
        super("OOPS!!! " + errorMessage);
    }
}