import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class Duke {
    public static void main(String[] args) {
        SystemMessages.welcomeMessage();

        boolean breakCheck = false;
        String input,firstWord;
        Vector<Task> dataStorage = new Vector<>();
        int counter = 1;
        Scanner in = new Scanner(System.in);

        while(!breakCheck) {
            input = in.nextLine().trim();
            firstWord = input.split(" ",2)[0];

            switch (firstWord.toLowerCase()) {
                case "bye":
                    breakCheck = true;
                    break;

                case "":
                    System.out.println("Please enter something.");
                    break;

                case "list":
                    printList(dataStorage,counter);
                    break;

                case "done":
                    markAsDone(input, dataStorage, counter);
                    break;

                default:
                    counter = addTask(input, dataStorage, counter);
            }
        }

        SystemMessages.goodbyeMessage();
    }

    private static void markAsDone(String input, Vector<Task> dataStorage, int counter) {
        //checking for invalid input
        if(input.split(" ").length>2 || !input.split(" ")[1].matches("^-?\\d+$")){
            System.out.println("Invalid input.");
            return;
        }

        int completedIndex = Integer.parseInt(input.split(" ")[1].trim());

        if(completedIndex <= counter && !dataStorage.get(completedIndex - 1).isDone){
            Task replacement = new Task(dataStorage.get(completedIndex-1).description);
            replacement.isDone = true;
            dataStorage.set(completedIndex-1,replacement);
            System.out.println("Nice! I've marked this task as done: ");
            System.out.println("[" + dataStorage.get(completedIndex-1).getStatusIcon() + "]" + dataStorage.get(completedIndex-1).description);
        }else if(completedIndex <= counter && dataStorage.get(completedIndex - 1).isDone){
            System.out.println("The task has already been marked as completed.");
        }else{
            System.out.println("This task does not exist.");
        }
    }

    private static void printList(Vector<Task> dataStorage,int counter) {
        for (int i = 0; i<counter-1; i++){
            System.out.println((i+1) + "." + dataStorage.get(i).toString());
        }
    }

    private static int addTask(String input, Vector<Task> dataStorage, int counter) {
        switch (input.toLowerCase().split(" ")[0]){
            case "todo":
                ToDo newToDo = new ToDo(input.split("todo",2)[1].trim());
                dataStorage.add(newToDo);
                System.out.println("Got it. I've added this task:");
                System.out.println(dataStorage.get(counter - 1).toString());
                System.out.println("Now you have " + counter + " tasks in the list.");
                counter++;
                break;
            case "deadline":
                Deadline newDeadline = new Deadline(input.split(" ",2)[1].split("/by",2)[0].trim(),input.split(" ",2)[1].split("/by",2)[1].trim());
                dataStorage.add(newDeadline);
                System.out.println("Got it. I've added this task:");
                System.out.println(dataStorage.get(counter - 1).toString());
                System.out.println("Now you have " + counter + " tasks in the list.");
                counter++;
                break;
            case "event":
                Event newEvent = new Event(input.split(" ",2)[1].split("/at",2)[0].trim(),input.split(" ",2)[1].split("/at",2)[1].trim());
                dataStorage.add(newEvent);
                System.out.println("Got it. I've added this task:");
                System.out.println(dataStorage.get(counter - 1).toString());
                System.out.println("Now you have " + counter + " tasks in the list.");
                counter++;
                break;
            default:
                System.out.println("Invalid Command");


        }
        return counter;
    }
}
