package duke.task;

/**
 * A base class for the different types of tasks
 */
public class Task {
    public String description;
    public boolean isDone;

    /**
     * constructor of task
     * @param description name of task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns a done or not done status
     * @return tick or X symbols
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    /**
     * Overrides the toString() function
     * @return a string in the format to be printed to the user
     */
    public String toString(){
        return "[" + getStatusIcon() + "]" + description;
    }

}
