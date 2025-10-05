package com.omar.todo;

public class MyFunctions {
        public boolean isInteger(String str){
            try {
                Integer.parseInt(str);
                return true;
            }catch (NumberFormatException e){
                return false;
            }
        }
}
