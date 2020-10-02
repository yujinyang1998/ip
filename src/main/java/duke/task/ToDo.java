package duke.task;

/**
 * An extension of task
 */
public class ToDo extends Task {

    public ToDo(String description) {
        super(description);
    }

    /**
     * Overrides the toString() function
     * @return
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}