package com.example.idk_tofes;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Model {
    ArrayList<User> users = new ArrayList<>();
    private final ArrayList<Note> notes = new ArrayList<>();
    SharedPreferences sharedPreferences;

    private static Model instance;

    private Model(Context context) {
        sharedPreferences = context.getSharedPreferences("users", Context.MODE_PRIVATE);
        loadData();

    }

    public static Model getInstance(Context context) {
        return instance == null ? instance = new Model(context) : instance;
    }

    public void addUser(User user) {
        users.add(user);

        saveData(user);

    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void addNotes(Note note) {
        notes.add(note);
    }

    public void editNotes(int id, String content) {
        notes.get(id).setContent(content);
    }

    public void deleteNotes(int id) {
        notes.remove(id);

        Note.setIdCounter(Note.getIdCounter() - 1);

        for(int i = id; i < notes.size(); i++) {
            notes.get(i).setId(i);
        }
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
