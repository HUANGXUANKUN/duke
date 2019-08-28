import java.util.ArrayList;
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

        ArrayList<String> taskList = new ArrayList<String>();
        int taskNumber = 0;
        while (true) {
            String userInput;
            userInput = input.nextLine();

            if (userInput.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }

            else if (userInput.equals("list")){
                for(int i = 0; i < taskNumber; i++){
                    System.out.println((i + 1) + ". " + taskList.get(i));

                }
            }
            else{
                taskNumber++;
                taskList.add(userInput);
                System.out.println("added: " + userInput);
            }
        }
    }
}
