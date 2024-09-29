package com.example.idk_tofes;

public class Note {
    private int id;
    private String content;
    private static int idCounter = 0;

    public Note(String content) {
        idCounter++;
        this.id = idCounter;
        this.content = content;
    }

    public static void setIdCounter(int idCounter) {
        Note.idCounter = idCounter;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
