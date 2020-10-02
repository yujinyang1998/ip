package duke;

import duke.exception.DukeException;
import duke.task.Task;

import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

/**
 * Duke
 */
public class Duke {
    public static boolean breakCheck = false;

    public static void main(String[] args) throws IOException {

        Ui.welcomeMessage();

        String input,firstWord;
        Vector<Task> dataStorage = new Vector<>();
        int counter = 1;
        Scanner in = new Scanner(System.in);

        Storage file = new Storage();
        counter = file.openFile(dataStorage,counter);

        while(!breakCheck) {
            input = in.nextLine().trim();
            firstWord = input.split(" ",2)[0];

            try {
                counter = Parser.checkInput(firstWord,input,dataStorage,counter);
            } catch (DukeException e){
                System.out.println(e.description);
            }
            file.updateFile(dataStorage,counter);
        }
        Ui.goodbyeMessage();
    }

}
