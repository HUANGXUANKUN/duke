package core;

/**
 * Exception that is related to Duke
 */
public class DukeException extends Exception {
    /**
     * Constructs a exception that is specific to duke with a error log string
     *
     * @param errorMessage A string that describes the specific duke error
     */
    public DukeException(String errorMessage) {
        super(errorMessage);
    }
}