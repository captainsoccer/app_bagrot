package com.example.idk_tofes;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Model {
    private final String USER_NAME_KEY  = "userName";
    ArrayList<User> users = new ArrayList<>();
    SharedPreferences sharedPreferences;

    public Model(Context context) {
        sharedPreferences = context.getSharedPreferences("users", Context.MODE_PRIVATE);
        loadData();

    }

    public void addUser(User user) {
        users.add(user);

        saveData(user);

    }

    private void loadData(){
        int length = sharedPreferences.getInt("length", 0);

        for(int i = 0; i < length; i++) {
            String userString = sharedPreferences.getString("user" + i, "");

            if(userString.isEmpty()) continue;

            users.add(new User(userString));
        }
    }

    private  void saveData(User user){
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("length", users.size());

        editor.putString("user" + (users.size() - 1), user.toString());

        editor.apply();
    }


}
