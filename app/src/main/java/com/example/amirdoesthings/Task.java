package com.example.amirdoesthings;

public class Task {
    public String title;
    public String description;
    public String dueDate;

    public Task(){

    }

    public Task (String title, String description, String dueDate){
        this.title=title;
        this.description=description;
        this.dueDate=dueDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}


