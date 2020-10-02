package duke.task;

/**
 * An extension of task with a "at" time feature
 */
public class Event extends Task{
    public String at;

    /**
     * Constructor for event
     * @param description name of task
     * @param at when the task takes place
     */
    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    /**
     * Overrides the toString() function
     * @return a string in the format to be printed to the user
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }
}
