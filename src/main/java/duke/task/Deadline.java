package duke.task;

/**
 * An extension of task with a "by" deadline feature
 */
public class Deadline extends Task {

    public String by;

    /**
     * Constructor for deadline
     * @param description name of task
     * @param by when the task is due
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Overrides the toString() function
     * @return a string in the format to be printed to the user
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}