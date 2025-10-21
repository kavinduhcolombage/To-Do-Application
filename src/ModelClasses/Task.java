/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelClasses;

import java.time.LocalDate;

/**
 *
 * @author Kavindu
 */
public class Task {
    private int id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private boolean isCompleted;
    public Task next;

    public Task(int id, String title, String description, LocalDate dueDate, boolean isCompleted) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.isCompleted = isCompleted;
        next = null;
    }

    public Task(int id, String title, String description, LocalDate dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        isCompleted = false;
        next = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }
    
}
