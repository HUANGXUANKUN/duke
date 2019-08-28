import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from I'm Duke\n" + logo);
        System.out.println("What can I do for you?");
        Scanner input = new Scanner(System.in);

        while (true) {
            String userInput;
            userInput = input.nextLine();

            if (userInput.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }

            else{
                System.out.println(userInput);
            }
        }
    }
}