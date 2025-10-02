package com.omar.todo;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class JsonEditor {
    Gson gson = new Gson();
    Scanner scanner = new Scanner(System.in);
    public void TaskAdd(UserData user){
        try (FileWriter writer = new FileWriter("/Users/omaratakishi/IdeaProjects/todolist-cli/src/main/java/com/omar/todo/todolist.json")){
            gson.toJson(user, writer);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public int taskcounter(){
        int nextID = 1;
        try (FileReader reader = new FileReader("/Users/omaratakishi/IdeaProjects/todolist-cli/src/main/java/com/omar/todo/todolist.json")){
            UserData data = new Gson().fromJson(reader, UserData.class);
            nextID = data.todos.size() + 1;

        } catch (IOException e){
            nextID = 1;
        }
        return nextID;
    }

    public UserData newuser(){
        UserData user;
        try (FileReader reader = new FileReader("/Users/omaratakishi/IdeaProjects/todolist-cli/src/main/java/com/omar/todo/todolist.json")){
            user = new Gson().fromJson(reader, UserData.class);
        }catch (IOException e){
            System.out.println("Please enter your name for registration");
            String nameofuser = scanner.nextLine();
            user = new UserData();
            user.name = nameofuser;
        }
        return user;
    }
}
