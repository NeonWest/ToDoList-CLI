package com.omar.todo;
import java.io.FileReader;
import java.io.FileWriter;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Scanner;

public class TodoMain {
    public static void main(String[] args) {
        System.out.println("---To Do Cli Application---");
        Gson gson = new Gson();
        Scanner scanner = new Scanner(System.in);
        UserData user;
        try (FileReader reader = new FileReader("/Users/omaratakishi/IdeaProjects/todolist-cli/src/main/java/com/omar/todo/todolist.json")){
            user = new Gson().fromJson(reader, UserData.class);
        }catch (IOException e){
            System.out.println("Please enter your name for registration");
            String nameofuser = scanner.nextLine();
            user = new UserData();
            user.name = nameofuser;
        }
        int option = scanner.nextInt();
        switch (option){
            case 0:
                scanner.nextLine();
                System.out.println("Please enter the task: ");
                String task = scanner.nextLine();
                user.todos.add(new Todoformat(taskcounter(user.name), task, false));
                break;
            case 1:
                System.out.println("Your Tasks: ");
                for (int i = 0; i < taskcounter(user.name)-1; i++){
                    Todoformat todo = user.todos.get(i);
                    String description = todo.task;
                    System.out.println(description);
                }
                break;

        }



//Json writing
        try (FileWriter writer = new FileWriter("/Users/omaratakishi/IdeaProjects/todolist-cli/src/main/java/com/omar/todo/todolist.json")){
            gson.toJson(user, writer);
        } catch (IOException e){
            e.printStackTrace();
        }

    }
    public static int taskcounter(String username){
        int nextID = 1;
        try (FileReader reader = new FileReader("/Users/omaratakishi/IdeaProjects/todolist-cli/src/main/java/com/omar/todo/todolist.json")){
            UserData data = new Gson().fromJson(reader, UserData.class);
            nextID = data.todos.size() + 1;

        } catch (IOException e){
            nextID = 1;
        }
        return nextID;
    }
}
