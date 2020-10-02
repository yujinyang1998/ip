package duke;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

/**
 * Deals with the read and write of the save file
 */
public class Storage {

    private static File file = null;
    private static Scanner scanner;

    /**
     * Scans for a save file and reads from it if it exists else it creates a new save file
     * @param dataStorage the vector list of all the tasks
     * @param counter the number of tasks in the list
     * @return the number of tasks in the list
     */
    public static int openFile(Vector<Task> dataStorage, int counter){
        try{
            file = new File("Saves/Duke.txt");
            file.getParentFile().mkdirs();
            file.createNewFile();
            counter = readFile(dataStorage,counter);
        } catch (IOException e) {

        }
        return counter;
    }

    /**
     *
     * @param dataStorage the vector list of all the tasks the vector list of all the tasks
     * @param counter the number of tasks in the list
     * @throws IOException
     */
    public static void updateFile(Vector<Task> dataStorage, int counter) throws IOException {
        FileWriter fw = new FileWriter(file.getPath());
        for (int i = 0; i < counter - 1; i++) {
            fw.write(dataStorage.get(i).toString());
            if(i != counter-1) {
                fw.write("\n");
            }
        }
        fw.close();
    }

    /**
     * Reads the data from the save file
     * @param dataStorage the vector list of all the tasks
     * @param counter the number of tasks in the list
     * @return the number of tasks in the list
     * @throws FileNotFoundException
     */
    public static int readFile(Vector<Task> dataStorage,int counter) throws FileNotFoundException {
        Scanner s = new Scanner(file); // create a Scanner using the File as the source
        dataStorage.clear();
        while (s.hasNextLine()) {
            String line  = s.nextLine();
            Boolean isDone = (line.charAt(4) == '\u2713');
            String formattedLine = line.substring(6).trim();
            String description = formattedLine.split("\\(",2)[0].trim();

            switch (line.toUpperCase().charAt(1)){
                case 'T':
                    ToDo toDo = new ToDo(description);
                    toDo.isDone = isDone;
                    dataStorage.add(toDo);
                    counter++;
                    break;
                case 'E':
                    String at = formattedLine.split("at:",2)[1].substring(0,(formattedLine.split("at:",2)[1].length()-1));
                    Event event = new Event(description, at.trim());
                    event.isDone = isDone;
                    dataStorage.add(event);
                    counter++;
                    break;
                case 'D':
                    String by = formattedLine.split("by:",2)[1].substring(0,(formattedLine.split("by:",2)[1].length()-1));
                    Deadline deadline = new Deadline(description, by.trim());
                    deadline.isDone = isDone;
                    dataStorage.add(deadline);
                    counter++;
                    break;
                default:

            }
        }
        return counter;
    }

}
