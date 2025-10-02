package com.omar.todo;
import java.io.FileReader;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Scanner;


public class TodoMain {
    public static void main(String[] args) {
        JsonEditor jsonEdit = new JsonEditor();
        Gson gson = new Gson();
        Scanner scanner = new Scanner(System.in);
        UserData user = jsonEdit.newuser();;


        int option;





        do {
            System.out.println("---To Do Cli Application---"
                    + "\nOptions: "
                    + "\n1:Add a new task."
                    + "\n2.Show your tasks"
                    + "\n3.Quit");
            option = scanner.nextInt();
            switch (option){
                case 1:
                    scanner.nextLine();
                    System.out.println("Please enter the task: ");
                    String task = scanner.nextLine();
                    user.todos.add(new Todoformat(jsonEdit.taskcounter(), task, false));
                    jsonEdit.TaskAdd(user);
                    System.out.println("Task added successfully!" +
                            "\nPress enter to continue...");
                    scanner.nextLine();
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("Your Tasks: ");
                    for (int i = 0; i < jsonEdit.taskcounter()-1; i++){
                        System.out.println(user.todos.get(i).numberoftask + "." +user.todos.get(i).task);
                    }
                    System.out.println("\nPress enter to continue...");
                    scanner.nextLine();
                    break;
                case 3:
                    System.out.println("Quitting...");
                    break;

            }
        } while (option != 3);


    }

}
