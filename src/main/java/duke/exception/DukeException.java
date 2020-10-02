package duke.exception;

/**
 * Handles most exceptions in Duke
 */
public class DukeException extends Exception{
    public String description;

    /**
     * Handles most exceptions in Duke
     * @param description the description of the error
     */
    public DukeException (String description){
        this.description = description;
    }
}