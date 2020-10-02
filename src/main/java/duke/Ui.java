package duke;

/**
 * Displays messages to the user
 */
public class Ui {
    public static void welcomeMessage(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("Hello! I'm duke.Duke");
        System.out.println("What can I do for you?\n");
    }

    public static void goodbyeMessage() {
        System.out.println("Bye. Hope to see you again soon!\n");
    }

    public static void userPrompt(){
        System.out.println("Please enter something.");
    }

    public static void markedAsDone(){
        System.out.println("Nice! I've marked this task as done: ");
    }

    public static void addedTask(){
        System.out.println("Got it. I've added this task:");
    }

    public static void tasksCounter(int i){
        System.out.println("Now you have " + i + " tasks in the list.");
    }

    public static void removedTask(){
        System.out.println("Noted. I've removed this task:");
    }
}
