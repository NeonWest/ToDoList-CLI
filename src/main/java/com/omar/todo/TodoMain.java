package com.omar.todo;
import java.io.FileWriter;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Scanner;

public class TodoMain {
    public static void main(String[] args) {
        System.out.println("---To Do Cli Application---");
        System.out.println("Please enter your name for registration");

        Scanner scanner = new Scanner(System.in);
        Gson gson = new Gson();
        String nameofuser = scanner.nextLine();

        try (FileWriter writer = new FileWriter("/Users/omaratakishi/IdeaProjects/todolist-cli/src/main/java/com/omar/todo/todolist.json")){
            gson.toJson(nameofuser, writer);
        } catch (IOException e){
            e.printStackTrace();
        }




    }
}
