package com.omar.todo;

import com.google.gson.Gson;

import java.util.Scanner;


public class TodoMain {
    public static void main(String[] args) {
        JsonEditor jsonEdit = new JsonEditor();
        Gson gson = new Gson();
        Scanner scanner = new Scanner(System.in);
        UserData user = jsonEdit.newuser();
        MyFunctions functions = new MyFunctions();




        boolean quit = true;
        do {
            System.out.println("---To Do Cli Application---"
                    + "\nOptions: "
                    + "\n1:Add a new task."
                    + "\n2.Show your tasks"
                    + "\n3.Delete task"
                    + "\n4.Mark task complete"
                    + "\n5.Show completed tasks"
                    + "\n6.Quit");
            String optioninput = scanner.nextLine();
            int option = -1;
            while(!functions.isInteger(optioninput)){
                System.out.println("Wrong input! Please try again!");
                optioninput = scanner.nextLine();
            }
            option = Integer.parseInt(optioninput);
            switch (option) {
                case 1:
                    System.out.println("Please enter the task: ");
                    String task = scanner.nextLine();
                    user.todos.add(new Todoformat(jsonEdit.taskcounter(), task, false));
                    jsonEdit.TaskAdd(user);
                    System.out.println("Task added successfully!" +
                            "\nPress enter to continue...");
                    scanner.nextLine();
                    break;
                case 2:
                    System.out.println("Your Tasks: ");
                    for (int i = 0; i < jsonEdit.taskcounter()-1; i++){
                        if(user.todos.get(i).status == false){
                            System.out.println(user.todos.get(i).numberoftask + "." +user.todos.get(i).task);
                        }
                    }
                    System.out.println("\nPress enter to continue...");
                    scanner.nextLine();
                    break;
                case 3:
                    System.out.println("Which task you want to be removen? (ID): ");
                    String deletioninput = scanner.nextLine();
                    int deletedtask = -1;
                    while(!functions.isInteger(deletioninput)){
                        System.out.println("Wrong input! Please try again!");
                        deletioninput = scanner.nextLine();
                    }
                    deletedtask = Integer.parseInt(deletioninput);
                    boolean removed = false;
                    for (int i = 0; i < user.todos.size(); i++){
                        if(deletedtask == user.todos.get(i).numberoftask){
                            user.todos.remove(i);
                            removed = true;
                            break;
                        }
                    }
                    if(!removed){
                        System.out.println("Task not found!");
                    }

                    jsonEdit.renumberjson(user);
                    jsonEdit.TaskAdd(user);
                    System.out.println("\nPress enter to continue...");
                    scanner.nextLine();
                    break;

                case 4:
                    System.out.println("Which task is completed? (ID): ");
                    String archiveinput = scanner.nextLine();
                    int completedtask = -1;
                    while(!functions.isInteger(archiveinput)){
                        System.out.println("Wrong input! Please try again!");
                        archiveinput = scanner.nextLine();
                    }
                    completedtask = Integer.parseInt(archiveinput);
                    boolean completed = false;
                    for (int i = 0; i < user.todos.size(); i++){
                        if(completedtask == user.todos.get(i).numberoftask){
                            user.todos.get(i).status = true;
                            completed = true;
                            break;
                        }
                    }
                    if(!completed){
                        System.out.println("Task not found!");
                    }
                    jsonEdit.renumberjson(user);
                    jsonEdit.TaskAdd(user);
                    System.out.println("\nPress enter to continue...");
                    scanner.nextLine();
                    break;
                case 5:
                    System.out.println("Completed Tasks:");
                    for (int i = 0; i < user.todos.size(); i++){
                        if(user.todos.get(i).status == true){
                            System.out.println("✓" + user.todos.get(i).task);
                        }
                    }
                    System.out.println("\nPress enter to continue...");
                    scanner.nextLine();
                    break;
                case 6:
                    System.out.println("Quitting...");
                    quit = false;
                    break;
                default:
                    System.out.println("Invalid input!");
                    System.out.println("\nPress enter to continue...");
                    scanner.nextLine();
                    break;
            }
        } while (quit);


    }

}
