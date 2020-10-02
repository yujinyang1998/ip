package duke;

import duke.exception.DukeException;
import duke.task.Task;

import java.util.Vector;

/**
 * Parse the user's input
 */
public class Parser {
    /**
     * Checks the user input to determine the command
     * @param firstWord the first word in the users input
     * @param input the entire user input
     * @param dataStorage the vector list of all the tasks
     * @param counter the number of tasks in the list
     * @return the number of tasks in the list
     * @throws DukeException
     */
    public static int checkInput(String firstWord, String input, Vector<Task> dataStorage, int counter) throws DukeException {
        switch (firstWord.toLowerCase()) {
            case "bye":
                Duke.breakCheck = true;
                break;

            case "":
                Ui.userPrompt();
                break;

            case "list":
                TaskList.printList(dataStorage, counter);
                break;

            case "done":
                TaskList.markAsDone(input, dataStorage, counter);
                break;

            case "delete":
                counter = TaskList.deleteTask(input, dataStorage, counter);
                break;

            case "find":
                TaskList.findTask(input, dataStorage, counter);
                break;
            default:
                counter = TaskList.addTask(input, dataStorage, counter);
                break;
        }
        return counter;
    }
}
